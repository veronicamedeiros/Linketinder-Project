package org.linketinder.service

import groovy.sql.Sql
import org.linketinder.DBDAO.CompanyDAO
import org.linketinder.model.connection.ConnectionFactory
import org.linketinder.model.connection.DBconnection
import org.linketinder.model.connection.Db
import org.linketinder.model.entities.Company
import org.linketinder.service.serviceInterfaces.IcompanyService

class CompanyService implements IcompanyService{

    CompanyService() {}

    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase() as Sql

    CompanyDAO companyDao = new CompanyDAO(dbConnection)


    void registerCompany(List companyInfo){

        try {

            Company company  = new Company(companyInfo[0], companyInfo[1], companyInfo[2], companyInfo[3], companyInfo[4],
                                            companyInfo[5], companyInfo[6], companyInfo[7])

            CompanyDAO companyDao = new CompanyDAO(company, dbConnection)
            companyDao.register()
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }


    void updateCompany(Integer id, Integer chosenOption, String updatedInformation) {

        companyDao.update(id, chosenOption, updatedInformation)
    }


    void deleteCompanyInfo(Integer id, Integer chosenOption) {

        companyDao.delete(id, chosenOption)
    }


    List<Map> getCompanies(){

        List<Map> companies = companyDao.list()
        return companies
    }
}
