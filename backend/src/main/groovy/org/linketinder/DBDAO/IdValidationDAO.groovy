package org.linketinder.DBDAO

import groovy.sql.Sql
import org.linketinder.connection.ConnectionFactory
import org.linketinder.connection.DBconnection
import org.linketinder.utilities.enums.Db

class IdValidationDAO{

    private Integer id
    private String tableName

    IdValidationDAO(id, tableName){
        this.id = id
        this.tableName = tableName
    }


    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase()


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
