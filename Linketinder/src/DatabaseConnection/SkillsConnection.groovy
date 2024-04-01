package DatabaseConnection

import groovy.sql.Sql

class SkillsConnection {

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

    static listAllSkills(){

        connectDataBase()
        def x
        sql.query('SELECT id, skill FROM skills;') { resultSet ->

            while (resultSet.next()) {
                def codeSkills = resultSet.getString(1)
                def nameSkills = resultSet.getString(2)

                println("$codeSkills - $nameSkills")
            }
        }
    }
}
