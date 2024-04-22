package org.linketinder.model

import org.linketinder.DBDAO.CompanyDAO

class CompanyDisplay {

    static execute(){

        try {

            CompanyDAO companyDao = new CompanyDAO()
            List<Map> descriptions = companyDao.list()

            descriptions.forEach({
                println("\nDESCRIÇÃO: " + it.description)})
        }
        catch (e){
            e.printStackTrace()
        }
    }
}
