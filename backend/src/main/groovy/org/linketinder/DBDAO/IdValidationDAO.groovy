package org.linketinder.DBDAO

import org.linketinder.connection.DBConnection

class IdValidationDAO extends DBConnection {

    private Integer id
    private String tableName

    IdValidationDAO(id, tableName){
        setId(id)
        setTableName(tableName)
    }


     boolean idExists(){

        try {
            boolean query = database.rows("""
                        SELECT id FROM ${tableName} 
                        WHERE id = ${id};
                        """.toString()){ resultSet ->}
            return query
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }



    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    String getTableName() {
        return tableName
    }

    void setTableName(String tableName) {
        this.tableName = tableName
    }
}
