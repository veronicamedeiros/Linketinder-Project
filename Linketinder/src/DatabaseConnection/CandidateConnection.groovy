package DatabaseConnection

import Entities.Candidate
import Menus.CandidateDeleteMenu
import Menus.CandidateUpdateMenu
import Menus.CandidateRegistrationMenu
import Menus.VacancyUpdateMenu
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

        connectDataBase()
        def x

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


    static insertInformations(){

        connectDataBase()

        Candidate newCandidate = CandidateRegistrationMenu.registration()

        def result = sql.executeInsert("INSERT INTO candidates (candidate_name, candidate_surname, candidate_birth, candidate_email, candidate_country, candidate_cep, candidate_state, candidate_description, candidate_age, candidate_cpf, candidate_password) VALUES ($newCandidate.name, $newCandidate.surname, TO_DATE($newCandidate.birth, 'YYYY-MM-DD'), $newCandidate.email, $newCandidate.country, $newCandidate.cep, $newCandidate.state, $newCandidate.description, $newCandidate.age, $newCandidate.cpf, $newCandidate.password) RETURNING id")
        println('OK')

        def generatedId = result[0][0]

        for (newSkill in newCandidate.skills){
            sql.execute("INSERT INTO candidate_skills (id_candidate, id_skill) VALUES ($generatedId, $newSkill)")
        }
    }


    static candidateExists(Integer numberCandidate){

        connectDataBase()

        sql.rows("SELECT id FROM candidates WHERE id = $numberCandidate;".toString()){ resultSet ->} //se não existir o número do id do candidato, retorna false
    }


    static updateInformations(){

        connectDataBase()

        try {
            Integer idCandidate = (Integer) CandidateUpdateMenu.candidateRegistrationNumber()

            Integer chosenOption = CandidateUpdateMenu.chosenOption()


            if (chosenOption < 12) {

                chosenOption -=  1

                //String deleteddInformation = (String) CandidateUpdateMenu.updatedInformation()

                String textChosenOption = (String) candidateInformation[chosenOption]

                sql.execute("UPDATE candidates SET $textChosenOption = '' WHERE id = $idCandidate;".toString())
            }

            if (chosenOption == 12){

                sql.query("SELECT skills.id, skills.skill FROM candidates, candidate_skills, skills WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = ${idCandidate};".toString()) { resultSet ->

                    while (resultSet.next()) {

                        def vacancyNumber = resultSet.getString(1)
                        def vacancySkill = resultSet.getString(2)
                        println(vacancyNumber + " - " + vacancySkill)
                    }
                }

                Integer changeSKill = (Integer) VacancyUpdateMenu.changeSKill()

                sql.execute("UPDATE candidate_skills SET id_skill = ${changeSKill} = '' WHERE id_skill = ${changeSKill} AND candidate_skills.id_candidate = ${idCandidate};".toString())
            }
        }
        catch(Exception e){
            println("n\não foi possível atualizar os dados. Erro: $e")
        }
    }


    static deleteInformations(){

        connectDataBase()

        try {
            Integer idCandidate = (Integer) CandidateUpdateMenu.candidateRegistrationNumber()

            Integer chosenOption = CandidateDeleteMenu.chosenOption()


            if (chosenOption < 12) {

                chosenOption -=  1

                String textChosenOption = (String) candidateInformation[chosenOption]

                sql.execute("UPDATE candidates SET $textChosenOption = '' WHERE id = $idCandidate;".toString())

                println("\nInformação excluiída com sucesso")
            }

            if (chosenOption == 12){

                sql.query("SELECT skills.id, skills.skill FROM candidates, candidate_skills, skills WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = ${idCandidate};".toString()) { resultSet ->

                    while (resultSet.next()) {

                        def vacancyNumber = resultSet.getString(1)
                        def vacancySkill = resultSet.getString(2)
                        println(vacancyNumber + " - " + vacancySkill)
                    }
                }

                Integer changeSKill = (Integer) VacancyUpdateMenu.changeSKill()

                sql.execute("DELETE FROM candidate_skills WHERE id_skill = $changeSKill AND candidate_skills.id_candidate = ${idCandidate}".toString())

                println("\nInformação excluiída com sucesso")
            }
        }
        catch(Exception e){
            println("\nNão foi possível atualizar os dados. Erro: $e")
        }
    }
}


