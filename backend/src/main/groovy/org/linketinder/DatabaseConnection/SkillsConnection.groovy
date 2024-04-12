package org.linketinder.DatabaseConnection

class SkillsConnection {

    static Object sql = Connection.connectDataBase()

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
            println("\nNão foi possível realizar a operação. Erro: $e")
        }
    }
}
