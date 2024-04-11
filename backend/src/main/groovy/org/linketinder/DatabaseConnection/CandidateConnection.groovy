package org.linketinder.DatabaseConnection
import org.linketinder.Entities.Candidate

import org.linketinder.Menus.CandidateRegistrationMenu
import org.linketinder.Menus.ChooseMenuOptions
import groovy.sql.Sql
import org.linketinder.Menus.ChooseSkills
import org.linketinder.Utilities.RegistrationNumberValidation

class CandidateConnection {

    static String[] candidateTableHeader = ['candidate_name', 'candidate_surname', 'candidate_birth', 'candidate_email', 'candidate_country', 'candidate_cep', 'candidate_state', 'candidate_description', 'candidate_age', 'candidate_cpf', 'candidate_password']
    static List<String> candidateMenuOptions = ["Nome", "Sobrenome", "Data de Nascimento", "Email", "País", "CEP", "Estado", "Descrição", "Idade", "CPF", "Senha", "Habilidades"]

    static def url = 'jdbc:postgresql://localhost:5432/linketinder_banco'
    static def user = 'postgres'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'
    static def sql

    static connectDataBase() {

        try {
            sql = Sql.newInstance url, user, password, driver
        }
        catch (Exception e){
            println(e)
            println('Não foi possível se conectar ao banco de dados')
        }
    }

    static listAllCandidates(){

        def previousDescription

        try {
            connectDataBase()

            sql.eachRow('SELECT candidate_description, skills.skill FROM candidates, candidate_skills, skills WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id; ') { resultSet ->
                while (resultSet.next()) {

                    def description = resultSet.getString(1)

                    if (previousDescription != description){
                        println('\n---- \n')
                        println('DESCRIÇÃO: '+ description + '\n')
                        println('HABIDADES: ')
                    }

                    def skills = resultSet.getString(2)

                    println(skills)

                    previousDescription = description
                }
            }
            println()
        }
        catch (Exception e){
            println("\nOcorreu um erro: $e")
        }
    }


    static insertInformations(){

        try {
            connectDataBase()

            Candidate newCandidate = CandidateRegistrationMenu.registration()

            def result = sql.executeInsert("INSERT INTO candidates (candidate_name, candidate_surname, candidate_birth, candidate_email, candidate_country, candidate_cep, candidate_state, candidate_description, candidate_age, candidate_cpf, candidate_password) VALUES ($newCandidate.name, $newCandidate.surname, TO_DATE($newCandidate.birth, 'YYYY-MM-DD'), $newCandidate.email, $newCandidate.country, $newCandidate.cep, $newCandidate.state, $newCandidate.description, $newCandidate.age, $newCandidate.cpf, $newCandidate.password) RETURNING id")

            def generatedId = result[0][0]

            for (newSkill in newCandidate.skills){
                sql.execute("INSERT INTO candidate_skills (id_candidate, id_skill) VALUES ($generatedId, $newSkill)")
            }

            println('Operação realizada com sucesso.')
        }
        catch (Exception e){
            println("Ocorreu um erro: $e")
        }
        finally {
            sql.close()
        }
    }


    static candidateExists(Integer numberCandidate){

        try {
            connectDataBase()

            sql.rows("SELECT id FROM candidates WHERE id = $numberCandidate;".toString()){ resultSet ->} //se não existir o número do id do candidato, retorna false
        }
        catch (Exception e){
            println("Ocorreu um erro: $e")
        }
    }


    static updateInformations(){

        try {
            connectDataBase()

            Integer idCandidate = (Integer) RegistrationNumberValidation.registrationNumber("candidate")

            Integer chosenOption = ChooseMenuOptions.selecMenuOption(candidateMenuOptions, "Atualizar dados")


            if (chosenOption < 12) {

                String textChosenOption = (String) candidateTableHeader[chosenOption - 1]
                String updatedInformation = (String) ChooseMenuOptions.addUpdatedInformation()

                sql.execute("UPDATE candidates SET $textChosenOption = '$updatedInformation' WHERE id = $idCandidate;".toString())

                println('\nOperação realizada com sucesso.')
            }

            if (chosenOption == 12){

                sql.query("SELECT skills.id, skills.skill FROM candidates, candidate_skills, skills WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = ${idCandidate};".toString()) { resultSet ->

                    while (resultSet.next()) {

                        def candidateNumber = resultSet.getString(1)
                        def candidateSkill = resultSet.getString(2)
                        println(candidateNumber + " - " + candidateSkill)
                    }
                }

                Integer oldSkill = (Integer) ChooseSkills.chooseOldSKill()
                String newSkill = (String) ChooseSkills.chooseNewSkill()


                sql.execute("UPDATE candidate_skills SET id_skill = ${newSkill} WHERE id_skill = ${oldSkill} AND candidate_skills.id_candidate = ${idCandidate};".toString())

                println('\nOperação realizada com sucesso.')
            }
        }
        catch (Exception e){

            println("n\não foi possível atualizar os dados. Erro: $e")
        }
        finally {

            sql.close()
        }
    }


    static deleteInformations(){

        try {
            connectDataBase()

            Integer idCandidate = (Integer) RegistrationNumberValidation.registrationNumber("candidate")

            Integer chosenOption = ChooseMenuOptions.selecMenuOption(candidateMenuOptions, "Deletar dados")

            if (chosenOption < 12) {

                String textChosenOption = (String) candidateTableHeader[chosenOption - 1]

                sql.execute("UPDATE candidates SET $textChosenOption = '' WHERE id = $idCandidate;".toString())

                println("\nInformação excluída com sucesso")
            }

            if (chosenOption == 12){

                sql.query("SELECT skills.id, skills.skill FROM candidates, candidate_skills, skills WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = ${idCandidate};".toString()) { resultSet ->

                    while (resultSet.next()) {

                        def candidateNumber = resultSet.getString(1)
                        def candidateSkill = resultSet.getString(2)
                        println(candidateNumber + " - " + candidateSkill)
                    }
                }

                Integer oldSkill = (Integer) ChooseSkills.chooseOldSKill()

                sql.execute("DELETE FROM candidate_skills WHERE id_skill = $oldSkill AND candidate_skills.id_candidate = ${idCandidate}".toString())

                println("\nInformação excluída com sucesso")
            }
        }
        catch(Exception e){
            println("\nNão foi possível excluir os dados. Erro: $e")
        }
        finally {
            sql.close()
        }
    }
}

