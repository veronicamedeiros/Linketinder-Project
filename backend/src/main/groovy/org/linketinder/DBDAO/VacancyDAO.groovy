package org.linketinder.DBDAO

import org.linketinder.entities.Vacancy
import org.linketinder.interfaces.Ientities
import org.linketinder.menus.SkillsSelection
import org.linketinder.menus.MenuOptionsSelection

class VacancyDAO implements Ientities{

    Integer vacancyId
    Integer chosenOption
    Integer oldSkill
    Integer newSkill
    String updatedInformation
    Vacancy newVacancy


    VacancyDAO(newVacancy){
        this.newVacancy = newVacancy
    }

    VacancyDAO(vacancyId, chosenOption){
        this.vacancyId = vacancyId
        this.chosenOption = chosenOption
    }

    VacancyDAO(vacancyId, chosenOption, updatedInformation){
        this.vacancyId = vacancyId
        this.chosenOption = chosenOption
        this.updatedInformation = updatedInformation
    }

    VacancyDAO(vacancyId, chosenOption, oldSkill, newSkill){
        this.vacancyId = vacancyId
        this.chosenOption = chosenOption
        this.oldSkill = oldSkill
        this.newSkill = newSkill
    }

    static Object sql = DAO.connectDataBase()

    static String[] vacancyTableHeader = ['vacancy_position', 'vacancy_level', 'vacancy_shift', 'vacancy_model',
                                          'vacancy_city', 'vacancy_state', 'job_description', 'id_company']


    List<Map> list(){

        try {

            List<Map> allVacancies = []

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
                allVacancies.add([vacancy_position: vacancy_position, vacancy_level: vacancy_level, vacancy_shift: vacancy_shift, vacancy_model:vacancy_model])
            }
            return allVacancies
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    void register(){

        try {

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


    void update(){

        try {

            if (chosenOption < 8) {

                chosenOption -=  1

                String updatedInformation = (String) MenuOptionsSelection.addUpdatedInformation()
                String textChosenOption = (String) vacancyTableHeader[chosenOption]

                sql.execute("""
                            UPDATE vacancy 
                            SET $textChosenOption = '$updatedInformation' 
                            WHERE id = $vacancyId;
                            """.toString())
            }

            if (chosenOption == 8){

                sql.query("""
                            SELECT skills.id, skills.skill 
                            FROM vacancy, vacancy_skills, skills 
                            WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND id_vacancy = ${vacancyId};
                            """.toString()) { resultSet ->

                    while (resultSet.next()) {

                        String vacancyNumber = resultSet.getString(1)
                        String vacancySkill = resultSet.getString(2)
                        println(vacancyNumber + " - " + vacancySkill)
                    }
                }


                sql.execute("""
                            UPDATE vacancy_skills SET id_skill = ${newSkill} 
                            WHERE id_skill = ${oldSkill} AND id_vacancy = ${vacancyId};
                            """.toString())

            }
        }
        catch(Exception e){
            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }


    void delete(){

        try {

            if (chosenOption < 8) {

                chosenOption -=  1
                String textChosenOption = (String) vacancyTableHeader[chosenOption]

                sql.execute("""
                            UPDATE vacancy SET $textChosenOption = '' 
                            WHERE id = $vacancyId;
                            """.toString())

            }

            if (chosenOption == 8){

                sql.query("""
                            SELECT skills.id, skills.skill 
                            FROM vacancy, vacancy_skills, skills 
                            WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND id_vacancy = ${vacancyId};
                            """.toString()) { resultSet ->

                    while (resultSet.next()) {

                        String vacancyNumber = resultSet.getString(1)
                        String vacancySkill = resultSet.getString(2)
                        println(vacancyNumber + " - " + vacancySkill)
                    }
                }

                Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()

                sql.execute("""
                            DELETE FROM vacancy_skills 
                            WHERE id_skill = $oldSkill AND vacancy_skills.id_vacancy = ${vacancyId}
                            """.toString())
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
