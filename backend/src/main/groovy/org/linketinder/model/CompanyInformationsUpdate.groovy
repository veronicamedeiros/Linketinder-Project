package org.linketinder.model

import org.linketinder.DBDAO.CompanyDAO


class CompanyInformationsUpdate {

    String tableName
    Integer id
    Integer chosenOption
    String updatedInformation


    CompanyInformationsUpdate(String tableName, Integer id, Integer chosenOption, String updatedInformation) {

        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
        setUpdatedInformation(updatedInformation)
    }


    void execute() {

        CompanyDAO companyDAO = new CompanyDAO(id, chosenOption, updatedInformation)
        companyDAO.update()
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

    String getUpdatedInformation() {
        return updatedInformation
    }

    void setUpdatedInformation(String updatedInformation) {
        this.updatedInformation = updatedInformation
    }
}