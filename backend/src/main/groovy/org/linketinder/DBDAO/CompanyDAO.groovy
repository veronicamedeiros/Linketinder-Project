package org.linketinder.DBDAO

import org.linketinder.menus.CompanyRegistrationMenu
import org.linketinder.entities.Company
import org.linketinder.menus.MenuOptionsSelection
import org.linketinder.utilities.IdValidation

class CompanyDAO {

    static Object sql = DAO.connectDataBase()

    static String[] companyTableHeader = ['company_name', 'company_email', 'company_country', 'company_cep',
                                          'company_state', 'company_description', 'company_cnpj', 'company_password']

    static List<String> companyMenuOptions = ["Nome da Empresa", "Email", "País", "CEP", "Estado", "Descrição", "CNPJ", "Senha"]


    static listAllCompanies(){

        try {
            sql.eachRow("""
                            SELECT company_description 
                            FROM company;
                            """) { resultSet ->

                while (resultSet.next()) {

                    String description = resultSet.getString(1)

                    println('DESCRIÇÃO: '+ description)
                    println('\n----\n')
                }
            }
        }catch (Exception e){

            e.printStackTrace()
        }
    }



    static registerCompanies(){

        try {
            Company newCompany = CompanyRegistrationMenu.register()

            sql.executeInsert("""
                                INSERT INTO company (company_name, company_email, company_country, company_cep, 
                                                    company_state, company_description, company_cnpj, company_password) 
                                VALUES ($newCompany.name, $newCompany.email, $newCompany.country, $newCompany.cep, 
                                        $newCompany.state, $newCompany.description, $newCompany.cnpj, $newCompany.password)
                                """)

            println("\nCadastro realizado com sucesso.")
        }
        catch (Exception e){

            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }


    static updateCompaniesInformations(){

        try {
            Integer companyId = (Integer) IdValidation.validateId("company")
            Integer chosenOption = MenuOptionsSelection.selecMenuOption(companyMenuOptions, "Atualizar Dados")
            String updatedInformation = (String) MenuOptionsSelection.addUpdatedInformation()
            String textChosenOption = (String) companyTableHeader[chosenOption - 1]

            sql.execute("""
                        UPDATE company 
                        SET $textChosenOption = '$updatedInformation' 
                        WHERE id = $companyId;
                        """.toString())

            println("\nAtualização realizada com sucesso.\n")
        }
        catch(Exception e){

            e.printStackTrace()
        }
    }


    static deleteCompaniesInformations(){

        try {
            Integer idCompany = (Integer) IdValidation.validateId("company")
            Integer chosenOption = MenuOptionsSelection.selecMenuOption(companyMenuOptions, "Deletar Dados")
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