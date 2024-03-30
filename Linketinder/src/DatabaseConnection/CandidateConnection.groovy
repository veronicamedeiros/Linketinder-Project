package DatabaseConnection

import Entities.Candidate
import Registration.EmployeeRegistration
import groovy.sql.Sql
class CandidateConnection {

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

    static listarCandidatos(){

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

        Candidate newCandidate = EmployeeRegistration.registration()


        def result = sql.executeInsert("INSERT INTO candidates (candidate_name, candidate_surname, candidate_birth, candidate_email, candidate_country, candidate_cep, candidate_state, candidate_description, candidate_age, candidate_cpf, candidate_password) VALUES ($newCandidate.name, $newCandidate.surname, TO_DATE($newCandidate.birth, 'YYYY-MM-DD'), $newCandidate.email, $newCandidate.country, $newCandidate.cep, $newCandidate.state, $newCandidate.description, $newCandidate.age, $newCandidate.cpf, $newCandidate.password) RETURNING id")
        println('OK')

        def generatedId = result[0][0]

        for (newSkill in newCandidate.skills){
            sql.execute("INSERT INTO candidate_skills (id_candidate, id_skill) VALUES ($generatedId, $newSkill)")
        }

    }
}


