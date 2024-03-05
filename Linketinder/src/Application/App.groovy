package Application

import Utilities.CandidatesArray
import Menus.Menu
import Utilities.CompanyArray
import Registration.EmployeeRegistration
import Tests.EmployeeRegistrationTest

class App{
    static void main(String[] args) {

        List candidateList = CandidatesArray.Candidates()

        List companyList = CompanyArray.Company()

        EmployeeRegistrationTest.addCandidateTest()  //  Candidate Registration Test

        String resp;

        while (resp != "0"){
            resp = Menu.mainMenu()

            switch (resp){

            case("1"):
                candidateList.eachWithIndex {element, index ->
                println "Candidato ${index + 1} \nDescrição: ${element.description} \nCompetências: ${element.skills}\n"}
                break

            case("2"):
                companyList.eachWithIndex {element, index ->
                println "Empresa ${index + 1} \nDescrição: ${element.description} \nCompetências Desejadas: ${element.desiredSkills}\n"}
                break

            case("3"):
                Object candidate = EmployeeRegistration.registration()
                EmployeeRegistration.addCandidate(candidate, candidateList)
                break

            case("0"):
                println "Encerrando..."
                break
            }
        }
    }
}
