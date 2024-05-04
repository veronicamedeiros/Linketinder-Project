package org.linketinder.DBDAO

import groovy.sql.Sql
import org.linketinder.DBDAO.DAOinterfaces.Ientities
import org.linketinder.model.entities.Company

class CompanyDAO implements Ientities {

    private Company newCompany
    Sql dbConnection

    CompanyDAO(){}

    CompanyDAO(Sql dbConnection){
        this.dbConnection = dbConnection
    }

    CompanyDAO(Company newCompany, Sql dbConnection){
        this.newCompany = newCompany
        this.dbConnection = dbConnection
    }


    static String[] companyTableHeader = ['company_name', 'company_email', 'company_country', 'company_cep',
                                          'company_state', 'company_description', 'company_cnpj', 'company_password']


    List<Map> list(){

        try {
            List<Map> allCompanies= []

            dbConnection.eachRow("""
                            SELECT company_description 
                            FROM company;
                            """) { resultSet ->

                while (resultSet.next()) {

                    String description = resultSet.getString(1)

                    allCompanies.add([description: description])
                }
            }
            return allCompanies
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    void register(){

        try {
            dbConnection.executeInsert("""
                                INSERT INTO company (company_name, company_email, company_country, company_cep, 
                                                    company_state, company_description, company_cnpj, company_password) 
                                VALUES ($newCompany.name, $newCompany.email, $newCompany.country, $newCompany.cep, 
                                        $newCompany.state, $newCompany.description, $newCompany.cnpj, $newCompany.password)
                                """)
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


     void update(Integer companyId, Integer chosenOption, String updatedInformation){

        try {

            String textChosenOption = (String) companyTableHeader[chosenOption - 1]

            dbConnection.execute("""
                        UPDATE company 
                        SET $textChosenOption = '$updatedInformation'
                        WHERE id = $companyId;
                        """.toString())
        }
        catch(Exception e){

            e.printStackTrace()
        }
    }


    void delete(Integer companyId, Integer chosenOption){

        try {
            String textChosenOption = (String) companyTableHeader[chosenOption - 1]

            dbConnection.execute("""
                        UPDATE company 
                        SET $textChosenOption = '' 
                        WHERE id = $companyId
                        """.toString())
        }
        catch(Exception e){

            e.printStackTrace()
        }
    }
}