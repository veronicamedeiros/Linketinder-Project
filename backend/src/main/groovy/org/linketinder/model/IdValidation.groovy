package org.linketinder.model


import org.linketinder.DBDAO.IdValidationDAO


class IdValidation{

    protected Integer id
    protected String tableName

    IdValidation(id, tableName){
        setId(id)
        setTableName(tableName)
    }


    boolean execute(){

        IdValidationDAO validation = new IdValidationDAO(id, tableName)
        boolean validationId = validation.idExists()

        if(!validationId){
            print("Cadastro não encontrado.")
        }

        return validationId
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
