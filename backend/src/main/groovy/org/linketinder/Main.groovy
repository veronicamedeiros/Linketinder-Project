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
                CandidateConnection.registerCandidates()
                break

            case("3"):
                CandidateConnection.updateCandidatesInformations()
                break

            case("4"):
                CandidateConnection.deleteCandidatesInformations()
                break

            case("5"):
                CompanyConnection.listAllCompanies()
                break

            case("6"):
                CompanyConnection.registerCompanies()
                break

            case("7"):
                CompanyConnection.updateCompaniesInformations()
                break

            case("8"):
                CompanyConnection.deleteCompaniesInformations()
                break

            case("9"):
                VacancyConnection.listAllVacancies()
                break

            case("10"):
                VacancyConnection.registerVacancies()
                break

            case("11"):
                VacancyConnection.updateVacanciesInformations()
                break

            case("12"):
                VacancyConnection.deleteVacanciesInformations()
                break

            case("13"):
                println "Encerrando..."
                break
            }
        }
    }
}


