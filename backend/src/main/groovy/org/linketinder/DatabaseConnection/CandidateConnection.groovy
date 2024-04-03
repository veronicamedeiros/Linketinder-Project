package org.linketinder.DatabaseConnection
import org.linketinder.Entities.Candidate
import org.linketinder.Menus.CandidateDeleteMenu
import org.linketinder.Menus.CandidateUpdateMenu
import org.linketinder.Menus.CandidateRegistrationMenu
import groovy.sql.Sql

class CandidateConnection {

    static String[] candidateInformation = ['candidate_name', 'candidate_surname', 'candidate_birth', 'candidate_email', 'candidate_country', 'candidate_cep', 'candidate_state', 'candidate_description', 'candidate_age', 'candidate_cpf', 'candidate_password']

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

        def x

        try {
            connectDataBase()

            sql.eachRow('SELECT candidate_description, skills.skill FROM candidates, candidate_skills, skills WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id; ') { resultSet ->
                while (resultSet.next()) {

                    def description = resultSet.getString(1)

                    if (x != description){
                        println('\n---- \n')
                        println('DESCRIÇÃO: '+ description + '\n')
                        println('HABIDADES: ')
                    }

                    def skills = resultSet.getString(2)

                    println(skills)

                    x = description
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

            Integer idCandidate = (Integer) CandidateUpdateMenu.candidateRegistrationNumber()

            Integer chosenOption = CandidateUpdateMenu.chosenOption()


            if (chosenOption < 12) {

                chosenOption -=  1

                String textChosenOption = (String) candidateInformation[chosenOption]
                String updatedInformation = (String) CandidateUpdateMenu.updatedInformation()

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

                Integer changeSKill = (Integer) CandidateUpdateMenu.changeSKill()
                String updatedInformation = (String) CandidateUpdateMenu.updatedSkill()


                sql.execute("UPDATE candidate_skills SET id_skill = ${updatedInformation} WHERE id_skill = ${changeSKill} AND candidate_skills.id_candidate = ${idCandidate};".toString())

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

            Integer idCandidate = (Integer) CandidateUpdateMenu.candidateRegistrationNumber()

            Integer chosenOption = CandidateDeleteMenu.chosenOption()

            if (chosenOption < 12) {

                chosenOption -=  1

                String textChosenOption = (String) candidateInformation[chosenOption]

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

                Integer changeSKill = (Integer) CandidateUpdateMenu.changeSKill()

                sql.execute("DELETE FROM candidate_skills WHERE id_skill = $changeSKill AND candidate_skills.id_candidate = ${idCandidate}".toString())

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

