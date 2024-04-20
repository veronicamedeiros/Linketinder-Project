package org.linketinder.DBDAO

class IdValidationDAO {

    Integer id
    String tableName

    IdValidationDAO(id, tableName){
        setId(id)
        setTableName(tableName)
    }

    static Object sql = DAO.connectDataBase()

     boolean idExists(){

        try {
            boolean query = sql.rows("""
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
