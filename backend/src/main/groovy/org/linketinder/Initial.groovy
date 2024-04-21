package org.linketinder

import org.linketinder.menus.CandidateRegistrationMenu
import org.linketinder.model.CandidatesDisplay
import org.linketinder.menus.Menu
import org.linketinder.model.CandidateProfileRegistration
import org.linketinder.model.CandidateInformationsUpdate

class Initial {

     List<String> candidateInformations = ["Nome da Empresa", "Email", "País", "CEP", "Estado", "Descrição", "CNPJ", "Senha"]

    Initial(){}


     void execute() {

/*         IdValidation idValida = new IdValidation(6, "candidates")
         boolean retornooo = idValida.execute()
         print(retornooo)*/

        Menu menu = new Menu()
        final resp =  menu.mainMenu()

        print(" escolha: " + resp)
        try {

            while (resp != "13"){

                switch (resp){

                    case("1"):
                        try {
                            CandidatesDisplay.execute()
                        }
                        catch (Exception e){
                            e.printStackTrace()
                        }
                        break

                    case("2"):
                        try {
                            CandidateProfileRegistration candidateRegistration = new CandidateProfileRegistration()
                            candidateRegistration.registerCandidate()
                            print("Cadastro realizado com sucesso.")
                        }
                        catch (Exception e){
                            e.printStackTrace()
                        }
                        break

                    case("3"):
                        CandidateInformationsUpdate update = new CandidateInformationsUpdate(candidateInformations)
                        //Atualizar informações candidatos
                        break

                    case("4"):
                        //Deletar informações candidatos
                        break

                    case("5"):
                        //listAllCompanies()
                        break

                    case("6"):
                        //registerCompanies()
                        break

                    case("7"):
                        //updateCompaniesInformations()
                        break

                    case("8"):
                        //deleteCompaniesInformations()
                        break

                    case("9"):
                        //listAllVacancies()
                        break

                    case("10"):
                        //registerVacancies()
                        break

                    case("11"):
                        //updateVacanciesInformations()
                        break

                    case("12"):
                        //deleteVacanciesInformations()
                        break

                    case("13"):
                        println "Encerrando..."
                        break
                }
                break
            }
        }catch (e){
            e.printStackTrace()
        }
    }

}
