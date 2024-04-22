package org.linketinder.DBDAO

import org.linketinder.interfaces.Ientities
import org.linketinder.menus.CompanyRegistrationMenu
import org.linketinder.entities.Company
import org.linketinder.menus.MenuOptionsSelection

class CompanyDAO implements Ientities {

    Integer companyId
    Integer chosenOption
    Integer oldSkill
    Integer newSkill
    String updatedInformation
    Company newCompany

    CompanyDAO(){}

    CompanyDAO(newCompany){
        this.newCompany = newCompany
    }

    CompanyDAO(companyId, chosenOption){
        this.companyId = companyId
        this.chosenOption = chosenOption
    }

    CompanyDAO(companyId, chosenOption, updatedInformation){
        this.companyId = companyId
        this.chosenOption = chosenOption
        this.updatedInformation = updatedInformation
    }

    CompanyDAO(companyId, chosenOption, oldSkill, newSkill){
        this.companyId = companyId
        this.chosenOption = chosenOption
        this.oldSkill = oldSkill
        this.newSkill = newSkill
    }

    static Object sql = DAO.connectDataBase()

    static String[] companyTableHeader = ['company_name', 'company_email', 'company_country', 'company_cep',
                                          'company_state', 'company_description', 'company_cnpj', 'company_password']


    List<Map> list(){

        List<Map> allCompanies= []

        try {
            sql.eachRow("""
                            SELECT company_description 
                            FROM company;
                            """) { resultSet ->

                while (resultSet.next()) {

                    String description = resultSet.getString(1)

                    allCompanies.add([description: description])
                }
            return allCompanies
            }
        }catch (Exception e){

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
                        WHERE id = $idCompany
                        """.toString())

            println("Dado deletado com sucesso.")

        }
        catch(Exception e){

            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }
}