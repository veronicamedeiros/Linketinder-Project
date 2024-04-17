package org.linketinder.DBDAO

class SkillsDAO {

    static Object sql = DAO.connectDataBase()

    static listAllSkills(){

        try {

            sql.query('SELECT id, skill FROM skills;') { resultSet ->

                while (resultSet.next()) {
                    def codeSkills = resultSet.getString(1)
                    def nameSkills = resultSet.getString(2)

                    println("$codeSkills - $nameSkills")
                }
            }
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }
}
