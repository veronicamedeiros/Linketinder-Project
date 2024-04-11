package org.linketinder


import org.linketinder.Menus.Menu
import org.linketinder.DatabaseConnection.CandidateConnection
import org.linketinder.DatabaseConnection.CompanyConnection
import org.linketinder.DatabaseConnection.VacancyConnection



class Main{
    static void main(String[] args) {

        String resp;

        while (resp != "13"){

            resp = Menu.mainMenu()

            switch (resp){

            case("1"):
                CandidateConnection.listAllCandidates()
                break

            case("2"):
                CandidateConnection.insertInformations()
                break

            case("3"):
                CandidateConnection.updateInformations()
                break

            case("4"):
                CandidateConnection.deleteInformations()
                break

            case("5"):
                CompanyConnection.listAllCompanies()
                break

            case("6"):
                CompanyConnection.insertInformations()
                break

            case("7"):
                CompanyConnection.updateInformations()
                break

            case("8"):
                CompanyConnection.deleteInformations()
                break

            case("9"):
                VacancyConnection.listAllVacancies()
                break

            case("10"):
                VacancyConnection.insertInformations()
                break

            case("11"):
                VacancyConnection.updateInformations()
                break

            case("12"):
                VacancyConnection.deleteInformations()
                break

            case("13"):
                println "Encerrando..."
                break
            }
        }
    }
}


