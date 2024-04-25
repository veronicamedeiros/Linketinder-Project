package org.linketinder.tasks


import org.linketinder.DBDAO.IdValidationDAO


class IdValidation{

    private Integer id
    private String tableName

    IdValidation(id, tableName){
        setId(id)
        setTableName(tableName)
    }


    boolean execute(){

        try {
            IdValidationDAO validation = new IdValidationDAO(id, tableName)
            boolean validationId = validation.idExists()
            if(!validationId){
                println("\nCadastro não encontrado.")
            }
            return validationId
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