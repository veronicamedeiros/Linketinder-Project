package org.linketinder.model

import org.linketinder.DBDAO.CompanyDAO


class CompanyInformationsDeletion {

    String tableName
    Integer id
    Integer chosenOption


    CompanyInformationsDeletion(tableName, id, chosenOption) {
        this.tableName = tableName
        this.id = id
        this.chosenOption = chosenOption
    }


    void execute() {

        IdValidation validation = new IdValidation(id, tableName)
        validation.execute()

        CompanyDAO companyDao = new CompanyDAO(id, chosenOption)
        companyDao.delete()
    }
}
