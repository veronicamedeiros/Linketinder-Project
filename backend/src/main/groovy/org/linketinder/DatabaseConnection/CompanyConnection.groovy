package org.linketinder.DatabaseConnection

import org.linketinder.Menus.CompanyRegistrationMenu
import org.linketinder.Entities.Company
import org.linketinder.Menus.ChooseMenuOptions
import org.linketinder.Utilities.idValidation


class CompanyConnection {

    static Object sql = Connection.connectDataBase()

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

            println("\nNão foi possível realizar a operação. Erro: $e")
        }
    }


    static companyExists(Integer companyId){

        try {
            sql.rows("SELECT id FROM company WHERE id = $companyId;".toString()){ resultSet ->}
        }
        catch (Exception e){

            println("\nNão foi possível realizar a operação. Erro: $e")
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

            println("Não foi possível inserir os dados no sistema. Erro: $e")
        }
        finally {
            sql.close()
        }
    }


    static updateCompaniesInformations(){

        try {
            Integer companyId = (Integer) idValidation.validateId("company")
            Integer chosenOption = ChooseMenuOptions.selecMenuOption(companyMenuOptions, "Atualizar Dados")
            String updatedInformation = (String) ChooseMenuOptions.addUpdatedInformation()
            String textChosenOption = (String) companyTableHeader[chosenOption - 1]

            sql.execute("""
                        UPDATE company 
                        SET $textChosenOption = '$updatedInformation' 
                        WHERE id = $companyId;
                        """.toString())

            println("\nAtualização realizada com sucesso.\n")
        }
        catch(Exception e){

            println("\não foi possível atualizar os dados. Erro: $e")
        }
    }


    static deleteCompaniesInformations(){

        try {
            Integer idCompany = (Integer) idValidation.validateId("company")
            Integer chosenOption = ChooseMenuOptions.selecMenuOption(companyMenuOptions, "Deletar Dados")
            String textChosenOption = (String) companyTableHeader[chosenOption - 1]

            sql.execute("""
                        UPDATE company 
                        SET $textChosenOption = '' 
                        WHERE id = $idCompany
                        """.toString())

            println("Dado deletado com sucesso.")

        }
        catch(Exception e){

            println("\nOcorreu um erro: $e")
        }
        finally {
            sql.close()
        }
    }
}