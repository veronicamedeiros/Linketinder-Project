package Application

import Menus.Menu
import DatabaseConnection.CandidateConnection
import DatabaseConnection.CompanyConnection
import DatabaseConnection.VacancyConnection

class App{
    static void main(String[] args) {

        //List candidateList = CandidatesArray.Candidates()
        //List companyList = CompanyArray.Company()

        //EmployeeRegistrationTest.addCandidateTest()  //  Candidate Registration Test
        //CompanyRegistrationTest.addCompanyTest()  //  Company Registration Test

        String resp;

        while (resp != "0"){
            resp = Menu.mainMenu()

            switch (resp){

            case("1"):
                CandidateConnection.listAllCandidates()
                break

            case("2"):
                CompanyConnection.listarEmpresas()
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

            case("13"):
                VacancyConnection.deleteInformations()
                break

            case("0"):
                println "Encerrando..."
                break
            }
        }
    }
}
