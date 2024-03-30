package DatabaseConnection

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

                x = description;
            }
        }
        println()
    }
}


