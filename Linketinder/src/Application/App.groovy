package Application

import Utilities.CandidatesArray
import Menus.Menu
import Utilities.CompanyArray

class App{
    static void main(String[] args) {

        List candidateList = CandidatesArray.Candidates()
        List companyList = CompanyArray.Company()

        while (true){
            String resp = Menu.mainMenu()

            if (resp == "1"){
                candidateList.eachWithIndex {element, index ->
                    println "Candidato ${index + 1} \nDescrição: ${element.description} \nCompetências: ${element.skills}\n"}
            }
            else if (resp == "2"){
                companyList.eachWithIndex {element, index ->
                    println "Empresa ${index + 1} \nDescrição: ${element.description} \nCompetências Desejadas: ${element.desiredSkills}\n"}
            }
            else if (resp == "0"){
                println "Encerrando..."
                break
            }
        }
        }
}
