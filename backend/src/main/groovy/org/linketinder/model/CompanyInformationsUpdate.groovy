package org.linketinder.model

import org.linketinder.DBDAO.CandidateDAO


class CompanyInformationsUpdate {

    String tableName
    Integer id
    Integer chosenOption
    String updatedInformation


    CompanyInformationsUpdate(tableName, id, chosenOption, updatedInformation) {
        this.tableName = tableName
        this.id = id
        this.chosenOption = chosenOption
        this.updatedInformation = updatedInformation
    }

    void execute() {

        IdValidation validation = new IdValidation(id, tableName)
        validation.execute()

        CandidateDAO candidateDao = new CandidateDAO(id, chosenOption, updatedInformation)
        candidateDao.update()
    }
}
