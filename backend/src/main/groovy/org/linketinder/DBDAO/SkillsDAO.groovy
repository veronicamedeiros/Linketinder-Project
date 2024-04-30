package org.linketinder.DBDAO

import groovy.sql.Sql
import org.linketinder.connection.ConnectionFactory
import org.linketinder.connection.DBconnection
import org.linketinder.utilities.enums.Db

class SkillsDAO{

    private Integer id

    SkillsDAO(){}

    SkillsDAO(id){
        this.id = id
    }


    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase()


    List<Map> getAllSkills(){

        try {

            List<Map> allSkills = []

            dbConnection.eachRow('SELECT id, skill FROM skills;') { row ->

                def skillCode = row.getString(1)
                def skillName = row.getString(2)

                allSkills.add([skillCode: skillCode, skillName: skillName])
            }
            return allSkills
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    List<Map> getCandidateSkills(){

        try {

            List<Map> candidateSkills = []

            dbConnection.eachRow("""
                            SELECT skills.id, skills.skill 
                            FROM candidates, candidate_skills, skills 
                            WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = ${id};
                            """.toString()) { rows ->

                    String skillCode = rows.getString(1)
                    String skillName = rows.getString(2)

                    candidateSkills.add([skillCode: skillCode, skillName: skillName])
            }
            return candidateSkills
        }
        catch(Exception e){
            e.printStackTrace()
        }
    }


    List<Map> getVacancySkills(){

        try {

            List<Map> vacancySkills = []

            dbConnection.eachRow("""
                            SELECT skills.id, skills.skill 
                            FROM vacancy, vacancy_skills, skills 
                            WHERE vacancy_skills.id_vacancy = vacancy.id AND vacancy_skills.id_skill = skills.id AND id_vacancy = ${id};
                            """.toString()) { row ->

                    String skillCode = row.getString(1)
                    String skillName = row.getString(2)

                    vacancySkills.add([skillCode: skillCode, skillName: skillName])
            }
            return vacancySkills
        }
        catch(Exception e){
            e.printStackTrace()
        }
    }
}