package org.linketinder


import org.linketinder.menus.InformationRequest
import org.linketinder.menus.MenuOptionsSelection
import org.linketinder.model.CandidateInformationsDeletion
import org.linketinder.model.CandidatesDisplay
import org.linketinder.menus.Menu
import org.linketinder.model.CandidateProfileRegistration
import org.linketinder.model.CandidateInformationsUpdate
import org.linketinder.model.CompanyInformationsDeletion
import org.linketinder.model.CompanyInformationsUpdate
import org.linketinder.model.CompanyProfileRegistration

class Initial {

    List<String> candidateInformations = ["Nome", "Sobrenome", "Ano de Nascimento", "Email", "País", "CEP", "Estado", "Descrição", "Idade", "CPF", "Senha", "Habilidades", ]
    List<String> companyInformations = ["Nome da Empresa", "Email", "País", "CEP", "Estado", "Descrição", "CNPJ", "Senha"]
    List<String> vacancyInformations = ["Nome ", "Nível", "Turno", "Modelo", "Cidade", "Estado", "Descrição", "Competências"]


    final String tableCandidate = "candidates"
    final String tableCompany = "company"

    Initial(){}


     void execute() {

        Menu menu = new Menu()
        final resp =  menu.mainMenu()

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

                        Integer id = InformationRequest.requestId()
                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(candidateInformations, "Atualizar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        if (chosenOption < 12){
                            String updatedInformation = (String) InformationRequest.addUpdatedInformation()
                            CandidateInformationsUpdate update = new CandidateInformationsUpdate(tableCandidate, id, chosenOption, updatedInformation)
                            update.execute()
                        }
                        else {
                            CandidateInformationsUpdate update = new CandidateInformationsUpdate(tableCandidate, id, chosenOption)
                            update.execute()
                        }
                        break

                    case("4"):
                        Integer id = InformationRequest.requestId()
                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(candidateInformations, "Deletar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        CandidateInformationsDeletion deletion = new CandidateInformationsDeletion(tableCandidate, id, chosenOption)
                        deletion.execute()

                        break

                    case("5"):
                        try {
                            CompanyDisplay.execute()
                        }
                        catch (Exception e){
                            e.printStackTrace()
                        }
                        break

                    case("6"):
                        try {
                            CompanyProfileRegistration companyRegistration = new CompanyProfileRegistration()
                            companyRegistration.registerCompany()
                            print("Cadastro realizado com sucesso.")
                        }
                        catch (Exception e){
                            e.printStackTrace()
                        }
                        break

                    case("7"):
                        Integer id = InformationRequest.requestId()
                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(companyInformations, "Atualizar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        String updatedInformation = (String) InformationRequest.addUpdatedInformation()
                        CompanyInformationsUpdate update = new CompanyInformationsUpdate(tableCompany, id, chosenOption, updatedInformation)
                        update.execute()

                        break

                    case("8"):
                        Integer id = InformationRequest.requestId()
                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(companyInformations, "Deletar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        CompanyInformationsDeletion deletion = new CompanyInformationsDeletion(tableCompany, id, chosenOption)
                        deletion.execute()
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
