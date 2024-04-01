package DatabaseConnection

import Entities.Vacancy
import Menus.VacancyDeleteMenu
import Menus.VacancyRegistrationMenu
import Menus.VacancyUpdateMenu
import groovy.sql.Sql

class VacancyConnection {

    static String[] vacancyInformation = ['vacancy_position', 'vacancy_level', 'vacancy_shift', 'vacancy_model', 'vacancy_city', 'vacancy_state', 'job_description', 'id_company']


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

    static listAllVacancies(){

        connectDataBase()
        def x

        sql.eachRow('SELECT vacancy.id, vacancy_position, vacancy_level, vacancy_shift, vacancy_model, vacancy_state, vacancy_city, job_description, skills.skill, company_description FROM vacancy, vacancy_skills, skills, company WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND vacancy.id_company = company.id; ') { resultSet ->
            while (resultSet.next()) {

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

                x = numerodaVaga
            }
        }
        println()
    }


    static numberVacancyExists(Integer cadastro){

        connectDataBase()

        sql.rows("SELECT id FROM vacancy WHERE id = $cadastro;".toString()){ resultSet ->
        } //se não existir o número da vaga, retorna false
    }


    static insertInformations(){

        connectDataBase()

        Vacancy newVacancy = VacancyRegistrationMenu.registration()

        try {

            def result = sql.executeInsert("INSERT INTO vacancy (vacancy_position, vacancy_level, vacancy_shift, vacancy_model, vacancy_city, vacancy_state, job_description, id_company) VALUES ($newVacancy.position, $newVacancy.level, $newVacancy.shift, $newVacancy.model, $newVacancy.city, $newVacancy.state, $newVacancy.jobDescription, $newVacancy.idCompany)")

            def generatedId = (Integer) result[0][0]

            for (newSkill in newVacancy.desiredSkills){
                sql.execute("INSERT INTO vacancy_skills (id_vacancy, id_skill) VALUES ($generatedId, $newSkill)")
            }
        }
        catch (Exception e){

            println("Ocorreu um erro ao cadastrar a vaga: $e")
        }

    }


    static updateInformations(){

        connectDataBase()

        try {
            Integer idVacancy = (Integer) VacancyUpdateMenu.vacancyRegistrationNumber()

            Integer chosenOption = VacancyUpdateMenu.chosenOption()


            if (chosenOption < 8) {

                chosenOption -=  1

                println("Primeira parte")

                String updatedInformation = (String) VacancyUpdateMenu.updatedInformation()

                String textChosenOption = (String) vacancyInformation[chosenOption]

                sql.execute("UPDATE vacancy SET $textChosenOption = '$updatedInformation' WHERE id = $idVacancy;".toString())
            }

            if (chosenOption == 8){

                sql.query("SELECT skills.id, skills.skill FROM vacancy, vacancy_skills, skills WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND id_vacancy = ${idVacancy};".toString()) { resultSet ->

                    while (resultSet.next()) {

                        def vacancyNumber = resultSet.getString(1)
                        def vacancySkill = resultSet.getString(2)
                        println(vacancyNumber + " - " + vacancySkill)
                    }
                }

                Integer changeSKill = (Integer) VacancyUpdateMenu.changeSKill()
                Integer updatedSkill = (Integer) VacancyUpdateMenu.updatedSkill()

                sql.execute("UPDATE vacancy_skills SET id_skill = ${updatedSkill} WHERE id_skill = ${changeSKill} AND id_vacancy = ${idVacancy};".toString())
            }
        }
        catch(Exception e){
            println("n\não foi possível atualizar os dados. Erro: $e")
        }
    }


    static deleteInformations(){

        connectDataBase()

        try {
            Integer idVacancy = (Integer) VacancyUpdateMenu.vacancyRegistrationNumber()

            Integer chosenOption = VacancyDeleteMenu.chosenOption()


            if (chosenOption < 8) {

                chosenOption -=  1

                String textChosenOption = (String) vacancyInformation[chosenOption]

                sql.execute("UPDATE vacancy SET $textChosenOption = '' WHERE id = $idVacancy;".toString())

                println("\nInformação excluÍda com sucesso")

            }

            if (chosenOption == 8){

                sql.query("SELECT skills.id, skills.skill FROM vacancy, vacancy_skills, skills WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND id_vacancy = ${idVacancy};".toString()) { resultSet ->

                    while (resultSet.next()) {

                        def vacancyNumber = resultSet.getString(1)
                        def vacancySkill = resultSet.getString(2)
                        println(vacancyNumber + " - " + vacancySkill)
                    }
                }

                Integer changeSKill = (Integer) VacancyUpdateMenu.changeSKill()

                sql.execute("DELETE FROM vacancy_skills WHERE id_skill = $changeSKill AND vacancy_skills.id_vacancy = ${idVacancy}".toString())

                println("\nInformação excluída com sucesso")
            }
        }
        catch(Exception e){
            println("\nNão foi possível atualizar os dados. Erro: $e")
        }
    }

}
