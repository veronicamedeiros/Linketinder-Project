package org.linketinder.service.serviceInterfaces


interface IcompanyService {

    void registerCompany(List companyInfo)

    void updateCompany(Integer id, Integer chosenOption, String updatedInformation)

    void deleteCompanyInfo(Integer id, Integer chosenOption)

    List<Map> getCompanies()
}
