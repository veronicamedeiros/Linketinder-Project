package org.linketinder.DBDAO

import org.linketinder.entities.Vacancy
import org.linketinder.interfaces.Ientities

class VacancyDAO implements Ientities{

    private Integer vacancyId
    private Integer chosenOption
    private Integer oldSkill
    private Integer newSkill
    private String updatedInformation
    private Vacancy newVacancy

    VacancyDAO(){}

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
            ArrayList<Integer> ids = []

            sql.eachRow("""
                            SELECT vacancy.id FROM vacancy
                            """){ row ->

                ids.add(row.getInt(1))
            }

            for(id in ids){

                ArrayList<String> skills = []

                sql.eachRow("""
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


                    sql.eachRow("""
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

                String textChosenOption = (String) vacancyTableHeader[chosenOption - 1]

                sql.execute("""
                            UPDATE vacancy 
                            SET $textChosenOption = '$updatedInformation' 
                            WHERE id = $vacancyId;
                            """.toString())
            }

            if (chosenOption == 8){

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

                String textChosenOption = (String) vacancyTableHeader[chosenOption - 1]

                sql.execute("""
                            UPDATE vacancy SET $textChosenOption = '' 
                            WHERE id = $vacancyId;
                            """.toString())
            }

            if (chosenOption == 8){

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