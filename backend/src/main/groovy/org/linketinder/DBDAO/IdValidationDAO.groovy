package org.linketinder.DBDAO

import groovy.sql.Sql


class IdValidationDAO{

    private Integer id
    private String tableName
    private Sql dbConnection

    IdValidationDAO(id, tableName, Sql dbConnection){
        this.id = id
        this.tableName = tableName
        this.dbConnection = dbConnection
    }


    boolean idExists(){

        try {
            boolean query = dbConnection.rows("""
                        SELECT id FROM ${tableName} 
                        WHERE id = ${id};
                        """.toString()){ resultSet ->}
            return query
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }
}
