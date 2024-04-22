package org.linketinder.model

import org.linketinder.DBDAO.CompanyDAO
import org.linketinder.entities.Company
import org.linketinder.menus.CompanyRegistrationMenu

class CompanyProfileRegistration {

    void registerCompany(){

        try {
            CompanyRegistrationMenu newRegistration = new CompanyRegistrationMenu()
            Company newCandidate = newRegistration.registerCompanyInformations()

            CompanyDAO dbRegistration = new CompanyDAO(newCandidate)
            dbRegistration.register()
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }
}