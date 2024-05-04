package org.linketinder.DBDAO

import groovy.sql.Sql
import org.linketinder.DBDAO.DAOinterfaces.Ientities
import org.linketinder.DBDAO.DAOinterfaces.Iskills
import org.linketinder.model.entities.Vacancy

class VacancyDAO implements Ientities, Iskills{

    Vacancy newVacancy
    Sql dbConnection

    VacancyDAO(){}

    VacancyDAO(Sql dbConnection){
        this.dbConnection = dbConnection
    }

    VacancyDAO(Vacancy newVacancy, Sql dbConnection){
        this.newVacancy = newVacancy
        this.dbConnection = dbConnection
    }


    static String[] vacancyTableHeader = ['vacancy_position', 'vacancy_level', 'vacancy_shift', 'vacancy_model',
                                          'vacancy_city', 'vacancy_state', 'job_description', 'id_company']


    List<Map> list(){

        try {
            List<Map> allVacancies = []
            ArrayList<Integer> ids = []

            dbConnection.eachRow("""
                            SELECT vacancy.id FROM vacancy
                            """){ row ->

                ids.add(row.getInt(1))
            }

            for(id in ids){

                ArrayList<String> skills = []

                dbConnection.eachRow("""
                            SELECT vacancy_position, vacancy_level, vacancy_shift, vacancy_model, 
                            vacancy_state, vacancy_city, job_description, company_description
                            FROM vacancy, company 
                            WHERE vacancy.id_company = company.id AND vacancy.id = $id
                            """)
                { row ->

                    String position = row.getString(1)
                    String level = row.getString(2)
                    String shift = row.getString(3)
                    String model = row.getString(4)
                    String state = row.getString(5)
                    String city = row.getString(6)
                    String job_description = row.getString(7)
                    String company_description = row.getString(8)


                    dbConnection.eachRow("""
                                SELECT skill FROM vacancy_skills, skills
                                WHERE vacancy_skills.id_skill = skills.id AND id_vacancy = $id;
                                """) {rows ->

                                    String skill = rows.getString(1)
                                    skills.add(skill)
                                }

                        allVacancies.add([position: position,
                                          level: level,
                                          shift: shift,
                                          model: model,
                                          city: city,
                                          state: state,
                                          job_description: job_description,
                                          company_description: company_description,
                                          skills: skills])
                }
            }
            return allVacancies
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    void register(){

        try {

            List<List<Object>> result = dbConnection.executeInsert("""
                                            INSERT INTO vacancy (vacancy_position, vacancy_level, vacancy_shift, vacancy_model, 
                                                                vacancy_city, vacancy_state, job_description, id_company)
                                            VALUES ($newVacancy.position, $newVacancy.level, $newVacancy.shift, $newVacancy.model, 
                                                    $newVacancy.city, $newVacancy.state, $newVacancy.jobDescription, $newVacancy.idCompany)
                                            """)
            
            Integer generatedId = (Integer) result[0][0]

            for (newSkill in newVacancy.desiredSkills){
                dbConnection.execute("""
                            INSERT INTO vacancy_skills (id_vacancy, id_skill)
                            VALUES ($generatedId, $newSkill)
                            """)
            }
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    void update(Integer vacancyId, Integer chosenOption, String updatedInformation){

        try {

            String textChosenOpt = (String) vacancyTableHeader[chosenOption - 1]

            dbConnection.execute("""
                        UPDATE vacancy 
                        SET $textChosenOpt = '$updatedInformation' 
                        WHERE id = $vacancyId;
                        """.toString())
        }
        catch(Exception e){
            e.printStackTrace()
        }
    }


    void updateSkills(Integer vacancyId, Integer oldSkill, Integer newSkill){

        try {
                dbConnection.execute("""
                            UPDATE vacancy_skills SET id_skill = $newSkill
                            WHERE id_skill = $oldSkill AND id_vacancy = $vacancyId;
                            """.toString())
        }
        catch(Exception e){
            e.printStackTrace()
        }
    }


    void delete(Integer vacancyId, Integer chosenOption){

        try {
            String textChosenOption = (String) vacancyTableHeader[chosenOption - 1]

            dbConnection.execute("""
                        UPDATE vacancy SET $textChosenOption = '' 
                        WHERE id = $vacancyId;
                        """.toString())
        }
        catch(Exception e){

            e.printStackTrace()
        }
    }


    void deleteSkills(Integer vacancyId, Integer oldSkill){

        try {
            dbConnection.execute("""
                        DELETE FROM vacancy_skills 
                        WHERE id_skill = $oldSkill AND vacancy_skills.id_vacancy = ${vacancyId}
                        """.toString())
        }
        catch(Exception e){

            e.printStackTrace()
        }
    }
}