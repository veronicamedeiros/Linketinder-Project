package org.linketinder.DBDAO

import groovy.sql.Sql
import org.linketinder.connection.ConnectionFactory
import org.linketinder.connection.DBconnection

import org.linketinder.interfaces.Ientities
import org.linketinder.entities.Company
import org.linketinder.utilities.enums.Db

class CompanyDAO implements Ientities {

    private Integer companyId
    private Integer chosenOption
    private String updatedInformation
    private Company newCompany

    CompanyDAO(){}

    CompanyDAO(Company newCompany){
        this.newCompany = newCompany
    }

    CompanyDAO(Integer companyId, Integer chosenOption){
        this.companyId = companyId
        this.chosenOption = chosenOption
    }

    CompanyDAO(Integer companyId, Integer chosenOption, String updatedInformation){
        this.companyId = companyId
        this.chosenOption = chosenOption
        this.updatedInformation = updatedInformation
    }


    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase()


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


     void update(){

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


    void delete(){

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