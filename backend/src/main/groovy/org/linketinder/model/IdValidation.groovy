package org.linketinder.model

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.CompanyDAO
import org.linketinder.DBDAO.DAO
import org.linketinder.DBDAO.VacancyDAO
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
