package DatabaseConnection

import groovy.sql.Sql

class VacancyConnection {

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

    static listarVagas(){

        connectDataBase()
        def x

        sql.eachRow('SELECT vacancy.id, vacancy_position, vacancy_level, vacancy_shift, vacancy_model, vacancy_state, vacancy_city, job_description, skills.skill, company_description FROM vacancy, vacancy_skills, skills, company WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND vacancy.id_company = company.id; ') { resultSet ->
            while (resultSet.next()) {

            //vacancy_level, vacancy_shift, vacancy_model, vacancy_state, vacancy_city, job_description, company_description, skill

                def numerodaVaga = resultSet.getString(1)
                def vacancy_position = resultSet.getString(2)

                def vacancy_level = resultSet.getString(3)
                def vacancy_shift = resultSet.getString(4)
                def vacancy_model = resultSet.getString(5)
                def vacancy_state = resultSet.getString(6)
                def vacancy_city = resultSet.getString(7)
                def job_description = resultSet.getString(8)
                def company_description = resultSet.getString(10)

                if (x != numerodaVaga){
                    println('\n---- \n')
                    println("\nCargo: $vacancy_position \nNível: $vacancy_level \nTurno: $vacancy_shift \nModelo de Trabalho: $vacancy_model")
                    println("Local: $vacancy_city - $vacancy_state")
                    println("Sobre a empresa: $company_description")
                    println("Descrição do Cargo: $job_description \n")
                    println('Habilidades desejadas para a vaga: \n')
                }

                def skills = resultSet.getString(9)

                println(skills)

                x = numerodaVaga;
            }
        }
        println()
    }

}