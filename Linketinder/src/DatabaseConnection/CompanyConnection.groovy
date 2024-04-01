package DatabaseConnection

import Entities.Company
import Menus.CompanyDeleteMenu
import Menus.CompanyRegistrationMenu
import Menus.CompanyUpdateMenu
import groovy.sql.Sql


class CompanyConnection {

    static String[] companyInformation = ['company_name', 'company_email', 'company_country', 'company_cep', 'company_state', 'company_description', 'company_cnpj', 'company_password']


    static def url = 'jdbc:postgresql://localhost:5432/linketinder_banco'
    static def user = 'postgres'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'
    static def sql

    static connectDataBase() {

        try {
            sql = Sql.newInstance url, user, password, driver
        }
        catch (Exception e){
            println(e)
            println('Não foi possível se conectar ao banco de dados')
        }
    }

    static listarEmpresas(){

        connectDataBase()
        def x

        sql.eachRow('SELECT company_description FROM company;') { resultSet ->

            while (resultSet.next()) {

                def description = resultSet.getString(1)

                println('DESCRIÇÃO: '+ description)
                println('\n---- \n')
            }
        }
    }


    static companyExists(Integer numberCompany){

        connectDataBase()

        sql.rows("SELECT id FROM company WHERE id = $numberCompany;".toString()){ resultSet ->} //se não existir o id da empresa, retorna false
    }


    static insertInformations(){

        connectDataBase()

        Company newCompany = CompanyRegistrationMenu.registration()

        try {
            sql.executeInsert("INSERT INTO company (company_name, company_email, company_country, company_cep, company_state, company_description, company_cnpj, company_password) VALUES ($newCompany.name, $newCompany.email, $newCompany.country, $newCompany.cep, $newCompany.state, $newCompany.description, $newCompany.cnpj, $newCompany.password)")
            println("Cadastro realizado com sucesso.")
        }
        catch (Exception e){
            println("Não foi possível inserir os dados no sistema. Erro: $e")
        }
    }


    static updateInformations(){

        try {
            Integer idCompany = (Integer) CompanyUpdateMenu.companyRegistrationNumber()

            Integer chosenOption = CompanyUpdateMenu.chosenOption() - 1

            String updatedInformation = (String) CompanyUpdateMenu.updatedInformation()

            String textChosenOption = (String) companyInformation[chosenOption]

            sql.execute("UPDATE company SET $textChosenOption = '$updatedInformation' WHERE id = $idCompany;".toString())

            println("\n Atualização realizada com sucesso.\n")
        }

        catch(Exception e){
            println("n\não foi possível atualizar os dados. Erro: $e")
        }
    }


    static deleteInformations(){

        connectDataBase()

        try {
            Integer idCompany = (Integer) CompanyUpdateMenu.companyRegistrationNumber()

            Integer chosenOption = CompanyDeleteMenu.chosenOption() - 1

            String textChosenOption = (String) companyInformation[chosenOption]

            sql.execute("UPDATE company SET $textChosenOption = '' WHERE id = $idCompany".toString())

            println("Dado deletado com sucesso.")

        }
        catch(Exception e){
            println("\nOcorreu um erro: $e")
        }
    }
}