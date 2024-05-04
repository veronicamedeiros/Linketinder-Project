package org.linketinder.controller

import org.linketinder.controller.controllerInterface.IcompanyController
import org.linketinder.service.CompanyService

class CompanyController implements IcompanyController{


    CompanyService companyService = new CompanyService()

    CompanyController(){}


     void registerCompany(List companyInfo){

        companyService.registerCompany(companyInfo)
    }


    void updateCompany(Integer id, Integer chosenOption, String updatedInformation){

        companyService.updateCompany(id, chosenOption, updatedInformation)
    }


    void deleteCompanyInfo(Integer id, Integer chosenOption){
        companyService.deleteCompanyInfo(id, chosenOption)
    }


    List<Map> getCompanies(){

        List<Map> companies = companyService.getCompanies()
        return companies
    }
}
