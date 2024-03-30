package DatabaseConnection

import groovy.sql.Sql


class CompanyConnection {

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

    static listarEmpresas(){

        connectDataBase()
        def x

        sql.eachRow('SELECT company_description FROM company;') { resultSet ->

            while (resultSet.next()) {

                def description = resultSet.getString(1)

                println('DESCRIÇÃO: '+ description)
                println('\n---- \n')
            }
        }
    }
}

