package org.linketinder.DBDAO

import org.linketinder.interfaces.Ientities
import org.linketinder.entities.Company

class CompanyDAO implements Ientities {

    private Integer companyId
    private Integer chosenOption
    private String updatedInformation
    private Company newCompany

    CompanyDAO(){}

    CompanyDAO(newCompany){
        setNewCompany(newCompany)
    }

    CompanyDAO(companyId, chosenOption){
        setCompanyId(companyId)
        setChosenOption(chosenOption)
    }

    CompanyDAO(companyId, chosenOption, updatedInformation){
        setCompanyId(companyId)
        setChosenOption(chosenOption)
        setUpdatedInformation(updatedInformation)
    }


    static Object sql = DAO.connectDataBase()

    static String[] companyTableHeader = ['company_name', 'company_email', 'company_country', 'company_cep',
                                          'company_state', 'company_description', 'company_cnpj', 'company_password']


    List<Map> list(){

        try {
            List<Map> allCompanies= []

            sql.eachRow("""
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
            sql.executeInsert("""
                                INSERT INTO company (company_name, company_email, company_country, company_cep, 
                                                    company_state, company_description, company_cnpj, company_password) 
                                VALUES ($newCompany.name, $newCompany.email, $newCompany.country, $newCompany.cep, 
                                        $newCompany.state, $newCompany.description, $newCompany.cnpj, $newCompany.password)
                                """)
        }
        catch (Exception e){

            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }


     void update(){

        try {

            String textChosenOption = (String) companyTableHeader[chosenOption - 1]

            sql.execute("""
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

            sql.execute("""
                        UPDATE company 
                        SET $textChosenOption = '' 
                        WHERE id = $companyId
                        """.toString())
        }
        catch(Exception e){

            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }

    Integer getCompanyId() {
        return companyId
    }

    void setCompanyId(Integer companyId) {
        this.companyId = companyId
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

    Company getNewCompany() {
        return newCompany
    }

    void setNewCompany(Company newCompany) {
        this.newCompany = newCompany
    }
}