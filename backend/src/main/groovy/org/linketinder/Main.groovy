package org.linketinder

import org.linketinder.Menus.Menu
import org.linketinder.DatabaseConnection.CandidateConnection
import org.linketinder.DatabaseConnection.CompanyConnection
import org.linketinder.DatabaseConnection.VacancyConnection


class Main{
    static void main(String[] args) {

        String resp;

        while (resp != "0"){
            resp = Menu.mainMenu()

            switch (resp){

            case("1"):
                CandidateConnection.listAllCandidates()
                break

            case("2"):
                CompanyConnection.listAllCompanies()
                break

            case("3"):
                VacancyConnection.listAllVacancies()
                break

            case("4"):
                CandidateConnection.insertInformations()
                break

            case("5"):
                CompanyConnection.insertInformations()
                break

            case("6"):
                VacancyConnection.insertInformations()
                break

            case("7"):
                VacancyConnection.updateInformations()
                break

            case("8"):
                CandidateConnection.updateInformations()
                break

            case("9"):
                CompanyConnection.updateInformations()
                break

            case("10"):
                CompanyConnection.deleteInformations()
                break

            case("11"):
                 CandidateConnection.deleteInformations()
                break

            case("12"):
                VacancyConnection.deleteInformations()
                break

            case("0"):
                println "Encerrando..."
                break
            }
        }
    }
}
