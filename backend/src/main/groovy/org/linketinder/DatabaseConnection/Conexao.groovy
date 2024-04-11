package org.linketinder.DatabaseConnection

import groovy.sql.Sql

class Conexao {

     protected static connectDataBase() {

        try {
            String url = 'jdbc:postgresql://localhost:5432/linketinder_banco'
            String user = 'postgres'
            String password = 'postgres'
            String driver = 'org.postgresql.Driver'
            Sql.newInstance url, user, password, driver
        }
        catch (Exception e){

            println("Não foi possível se conectar ao banco de dados: $e")
        }
    }
}
