package org.linketinder.DBDAO

import org.linketinder.entities.Vacancy
import org.linketinder.menus.ChooseSkills
import org.linketinder.menus.VacancyRegistrationMenu
import org.linketinder.menus.ChooseMenuOptions
import org.linketinder.utilities.idValidation

class VacancyDAO {

    static Object sql = DAO.connectDataBase()

    static String[] vacancyTableHeader = ['vacancy_position', 'vacancy_level', 'vacancy_shift', 'vacancy_model',
                                          'vacancy_city', 'vacancy_state', 'job_description', 'id_company']
    static List<String> vacancyMenuOptions = ["Nome ", "Nível", "Turno", "Modelo", "Cidade", "Estado", "Descrição", "Competências"]


    static listAllVacancies(){

        try {

            Integer previousVacancyId

            sql.eachRow("""
                        SELECT vacancy.id, vacancy_position, vacancy_level, vacancy_shift, vacancy_model, 
                        vacancy_state, vacancy_city, job_description, skills.skill, company_description
                        FROM vacancy, vacancy_skills, skills, company 
                        WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND vacancy.id_company = company.id 
                        ORDER BY vacancy;
                        """) { resultSet ->

                while (resultSet.next()) {

                    String vacancyId = resultSet.getString(1)
                    String vacancy_position = resultSet.getString(2)
                    String vacancy_level = resultSet.getString(3)
                    String vacancy_shift = resultSet.getString(4)
                    String vacancy_model = resultSet.getString(5)
                    String vacancy_state = resultSet.getString(6)
                    String vacancy_city = resultSet.getString(7)
                    String job_description = resultSet.getString(8)
                    String company_description = resultSet.getString(10)

                    if (previousVacancyId != vacancyId){
                        
                        println('\n----')
                        println("\nCargo: $vacancy_position \nNível: $vacancy_level \nTurno: $vacancy_shift \nModelo de Trabalho: $vacancy_model")
                        println("Local: $vacancy_city - $vacancy_state")
                        println("\nSobre a empresa: $company_description")
                        println("\nDescrição do Cargo: $job_description\n")
                        println('Habilidades desejadas para a vaga:')
                    }

                    String skills = resultSet.getString(9)

                    println(skills)

                    previousVacancyId = vacancyId
                }
            }
        }
        catch (Exception e){

            e.printStackTrace()
        }
        println()
    }


    static vacancyExists(Integer vacancyId){

        try {
            sql.rows("""
                    SELECT id 
                    FROM vacancy 
                    WHERE id = $vacancyId;
                    """.toString()){resultSet ->}
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    static registerVacancies(){

        try {

            Vacancy newVacancy = VacancyRegistrationMenu.register()

            List<List<Object>> result = sql.executeInsert("""
                                            INSERT INTO vacancy (vacancy_position, vacancy_level, vacancy_shift, vacancy_model, 
                                                                vacancy_city, vacancy_state, job_description, id_company)
                                            VALUES ($newVacancy.position, $newVacancy.level, $newVacancy.shift, $newVacancy.model, 
                                                    $newVacancy.city, $newVacancy.state, $newVacancy.jobDescription, $newVacancy.idCompany)
                                            """)
            
            Integer generatedId = (Integer) result[0][0]

            for (newSkill in newVacancy.desiredSkills){
                sql.execute("""
                            INSERT INTO vacancy_skills (id_vacancy, id_skill)
                            VALUES ($generatedId, $newSkill)
                            """)
            }
        }
        catch (Exception e){

            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }


    static updateVacanciesInformations(){

        try {

            Integer idVacancy = (Integer) idValidation.validateId("vacancy")
            Integer chosenOption = ChooseMenuOptions.selecMenuOption(vacancyMenuOptions, "Atualizar dados")


            if (chosenOption < 8) {

                chosenOption -=  1

                String updatedInformation = (String) ChooseMenuOptions.addUpdatedInformation()
                String textChosenOption = (String) vacancyTableHeader[chosenOption]

                sql.execute("""
                            UPDATE vacancy 
                            SET $textChosenOption = '$updatedInformation' 
                            WHERE id = $idVacancy;
                            """.toString())

                println("\nOperação realizada com sucesso")
            }

            if (chosenOption == 8){

                sql.query("""
                            SELECT skills.id, skills.skill 
                            FROM vacancy, vacancy_skills, skills 
                            WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND id_vacancy = ${idVacancy};
                            """.toString()) { resultSet ->

                    while (resultSet.next()) {

                        String vacancyNumber = resultSet.getString(1)
                        String vacancySkill = resultSet.getString(2)
                        println(vacancyNumber + " - " + vacancySkill)
                    }
                }

                Integer oldSkill = (Integer) ChooseSkills.chooseOldSKill()
                Integer newSkill = (Integer) ChooseSkills.chooseNewSkill()

                sql.execute("""
                            UPDATE vacancy_skills SET id_skill = ${newSkill} 
                            WHERE id_skill = ${oldSkill} AND id_vacancy = ${idVacancy};
                            """.toString())

                println("\nOperação realizada com sucesso")
            }
        }
        catch(Exception e){
            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }


    static deleteVacanciesInformations(){

        try {

            Integer idVacancy = (Integer) idValidation.validateId("vacancy")
            Integer chosenOption = ChooseMenuOptions.selecMenuOption(vacancyMenuOptions, "Deletar Dados")


            if (chosenOption < 8) {

                chosenOption -=  1
                String textChosenOption = (String) vacancyTableHeader[chosenOption]

                sql.execute("""
                            UPDATE vacancy SET $textChosenOption = '' 
                            WHERE id = $idVacancy;
                            """.toString())

                println("\nInformação excluÍda com sucesso")
            }

            if (chosenOption == 8){

                sql.query("""
                            SELECT skills.id, skills.skill 
                            FROM vacancy, vacancy_skills, skills 
                            WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND id_vacancy = ${idVacancy};
                            """.toString()) { resultSet ->

                    while (resultSet.next()) {

                        String vacancyNumber = resultSet.getString(1)
                        String vacancySkill = resultSet.getString(2)
                        println(vacancyNumber + " - " + vacancySkill)
                    }
                }

                Integer oldSkill = (Integer) ChooseSkills.chooseOldSKill()

                sql.execute("""
                            DELETE FROM vacancy_skills 
                            WHERE id_skill = $oldSkill AND vacancy_skills.id_vacancy = ${idVacancy}
                            """.toString())

                println("\nInformação excluída com sucesso")
            }
        }
        catch(Exception e){

            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }
}
