package org.linketinder.DatabaseConnection

import org.linketinder.Menus.CompanyRegistrationMenu
import org.linketinder.Entities.Company
import org.linketinder.Menus.CompanyDeleteMenu
import org.linketinder.Menus.CompanyUpdateMenu
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


    static listAllCompanies(){

        try {
            connectDataBase()
            def x

            sql.eachRow('SELECT company_description FROM company;') { resultSet ->

                while (resultSet.next()) {

                    def description = resultSet.getString(1)

                    println('DESCRIÇÃO: '+ description)
                    println('\n---- \n')
                }
            }
        }catch (Exception e){
            println("\nNão foi possível realizar a operação. Erro: $e")
        }
        finally {
            sql.close()
        }
    }


    static companyExists(Integer numberCompany){

        try {
            connectDataBase()

            sql.rows("SELECT id FROM company WHERE id = $numberCompany;".toString()){ resultSet ->} //se não existir o id da empresa, retorna false
        }
        catch (Exception e){
            println("\nNão foi possível realizar a operação. Erro: $e")
        }
    }


    static insertInformations(){

        try {
            connectDataBase()

            Company newCompany = CompanyRegistrationMenu.registration()

            sql.executeInsert("INSERT INTO company (company_name, company_email, company_country, company_cep, company_state, company_description, company_cnpj, company_password) VALUES ($newCompany.name, $newCompany.email, $newCompany.country, $newCompany.cep, $newCompany.state, $newCompany.description, $newCompany.cnpj, $newCompany.password)")
            println("\nCadastro realizado com sucesso.")
        }
        catch (Exception e){
            println("Não foi possível inserir os dados no sistema. Erro: $e")
        }
        finally {
            sql.close()
        }
    }


    static updateInformations(){

        try {
            connectDataBase()

            Integer idCompany = (Integer) CompanyUpdateMenu.companyRegistrationNumber()

            Integer chosenOption = CompanyUpdateMenu.chosenOption() - 1

            String updatedInformation = (String) CompanyUpdateMenu.updatedInformation()

            String textChosenOption = (String) companyInformation[chosenOption]

            sql.execute("UPDATE company SET $textChosenOption = '$updatedInformation' WHERE id = $idCompany;".toString())

            println("\nAtualização realizada com sucesso.\n")
        }
        catch(Exception e){
            println("\não foi possível atualizar os dados. Erro: $e")
        }
        finally {
            sql.close()
        }
    }


    static deleteInformations(){

        try {
            connectDataBase()

            Integer idCompany = (Integer) CompanyUpdateMenu.companyRegistrationNumber()

            Integer chosenOption = CompanyDeleteMenu.chosenOption() - 1

            String textChosenOption = (String) companyInformation[chosenOption]

            sql.execute("UPDATE company SET $textChosenOption = '' WHERE id = $idCompany".toString())

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