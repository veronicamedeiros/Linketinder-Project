package org.linketinder.tasks.company

import org.linketinder.DBDAO.CompanyDAO
import org.linketinder.tasks.IdValidation


class CompanyInformationsDeletion {

    private String tableName
    private Integer id
    private Integer chosenOption


    CompanyInformationsDeletion(String tableName, Integer id, Integer chosenOption) {

        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
    }


    void execute() {

        IdValidation validation = new IdValidation(id, tableName)
        validation.execute()

        CompanyDAO companyDao = new CompanyDAO(id, chosenOption)
        companyDao.delete()
    }



    String getTableName() {
        return tableName
    }

    void setTableName(String tableName) {
        this.tableName = tableName
    }

    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    Integer getChosenOption() {
        return chosenOption
    }

    void setChosenOption(Integer chosenOption) {
        this.chosenOption = chosenOption
    }
}
