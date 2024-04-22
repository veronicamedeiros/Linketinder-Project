package org.linketinder.DBDAO

class SkillsDAO {

    Integer id

    SkillsDAO(){}

    SkillsDAO(id){
        this.id = id}

    static Object sql = DAO.connectDataBase()


    List<Map> getAllSkills(){

        try {

            List<Map> allSkills = []

            sql.query('SELECT id, skill FROM skills;') { resultSet ->

                while (resultSet.next()) {
                    def skillCode = resultSet.getString(1)
                    def skillName = resultSet.getString(2)

                    allSkills.add([skillCode: skillCode, skillName: skillName])
                }
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

            sql.query("""
                            SELECT skills.id, skills.skill 
                            FROM candidates, candidate_skills, skills 
                            WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = ${id};
                            """.toString()) { resultSet ->

                while (resultSet.next()) {

                    String skillCode = resultSet.getString(1)
                    String skillName = resultSet.getString(2)

                    candidateSkills.add([skillCode: skillCode, skillName: skillName])
                }
            }

            return candidateSkills
        }

        catch(Exception e){
            e.printStackTrace()
        }
    }
}