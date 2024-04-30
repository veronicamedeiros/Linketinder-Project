package org.linketinder.connection

import groovy.sql.Sql

class PostgreSQL implements DAO{

    @Override
     Sql connect(){
        try {
            String url = 'jdbc:postgresql://localhost:5432/linketinder_banco'
            String user = 'postgres'
            String password = 'postgres'
            String driver = 'org.postgresql.Driver'
            Sql sql = Sql.newInstance url, user, password, driver
            return sql
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }

    @Override
    void disconnect(connection) {
        connection.close()
    }
}
