package Application


import Menus.Menu
import DatabaseConnection.CandidateConnection
import DatabaseConnection.CompanyConnection
import DatabaseConnection.VacancyConnection
import DatabaseConnection.SkillsConnection


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
                CandidateConnection.listarCandidatos()
                break

            case("2"):
                CompanyConnection.listarEmpresas()
                break

            case("5"):
                VacancyConnection.listarVagas()
                break

            case("6"):
                SkillsConnection.listarSkills()
                break

            case("3"):
                CandidateConnection.insertInformations()
                break

            case("4"):
                CompanyConnection.insertInformations()
                break

            case("7"):
                VacancyConnection.insertInformations()
                break

            case("8"):
                VacancyConnection.updateInformations()
                break

            case("0"):
                println "Encerrando..."
                break
            }
        }
    }
}
