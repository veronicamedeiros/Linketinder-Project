package org.linketinder

import org.linketinder.menus.InformationRequest
import org.linketinder.menus.MenuOptionsSelection
import org.linketinder.tasks.candidate.CandidateInformationsDeletion
import org.linketinder.menus.Menu
import org.linketinder.tasks.candidate.CandidateProfileRegistration
import org.linketinder.tasks.candidate.CandidateInformationsUpdate
import org.linketinder.tasks.company.CompanyInformationsDeletion
import org.linketinder.tasks.company.CompanyInformationsUpdate
import org.linketinder.tasks.company.CompanyProfileRegistration
import org.linketinder.tasks.IdValidation
import org.linketinder.tasks.vacancy.VacancyInformationsDeletion
import org.linketinder.tasks.vacancy.VacancyInformationsUpdate
import org.linketinder.tasks.vacancy.VacancyRegistration
import org.linketinder.traits.EntitiesDisplayInvoke

class Initial implements EntitiesDisplayInvoke {

    List<String> candidateInformations = ["Nome", "Sobrenome", "Ano de Nascimento", "Email", "País", "CEP", "Estado", "Descrição", "Idade", "CPF", "Senha", "Habilidades"]
    List<String> companyInformations = ["Nome da Empresa", "Email", "País", "CEP", "Estado", "Descrição", "CNPJ", "Senha"]
    List<String> vacancyInformations = ["Nome ", "Nível", "Turno", "Modelo", "Cidade", "Estado", "Descrição", "Competências"]


    final String candidateTable = "candidates"
    final String companyTable = "company"
    final String vacancyTable = "vacancy"

    Initial(){}


     void execute() {

        Menu menu = new Menu()
        String resp

        while (resp != "13"){

            resp =  menu.mainMenu()

            switch (resp){

                case("1"):
                    try {
                        showCandidates()
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("2"):
                    try {
                        CandidateProfileRegistration candidateRegistration = new CandidateProfileRegistration()
                        candidateRegistration.registerCandidate()
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("3"):
                    try {
                        Integer id = InformationRequest.requestId()
                        IdValidation validation = new IdValidation(id, candidateTable)
                        validation.execute()

                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(candidateInformations, "Atualizar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        if (chosenOption < 12){
                            String updatedInformation = (String) InformationRequest.addUpdatedInformation()
                            CandidateInformationsUpdate update = new CandidateInformationsUpdate(candidateTable, id, chosenOption, updatedInformation)
                            update.execute()
                        }
                        else {
                            CandidateInformationsUpdate update = new CandidateInformationsUpdate(candidateTable, id, chosenOption)
                            update.execute()
                        }

                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("4"):
                    try {
                        Integer id = InformationRequest.requestId()

                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(candidateInformations, "Deletar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        CandidateInformationsDeletion deletion = new CandidateInformationsDeletion(candidateTable, id, chosenOption)
                        deletion.execute()

                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("5"):
                    try {
                        showCompanies()
                    }
                    catch (Exception e){

                        e.printStackTrace()
                    }
                    break

                case("6"):
                    try {
                        CompanyProfileRegistration companyRegistration = new CompanyProfileRegistration()
                        companyRegistration.registerCompany()
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("7"):

                    try {
                        Integer id = InformationRequest.requestId()
                        IdValidation validation = new IdValidation(id, companyTable)
                        validation.execute()

                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(companyInformations, "Atualizar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        String updatedInformation = (String) InformationRequest.addUpdatedInformation()
                        CompanyInformationsUpdate update = new CompanyInformationsUpdate(companyTable, id, chosenOption, updatedInformation)
                        update.execute()
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("8"):
                    try {
                        Integer id = InformationRequest.requestId()
                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(companyInformations, "Deletar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        CompanyInformationsDeletion deletion = new CompanyInformationsDeletion(companyTable, id, chosenOption)
                        deletion.execute()
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }

                    break

                case("9"):
                    try {
                        showVacancies()
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }

                    break

                case("10"):
                    try {
                        VacancyRegistration vacancyRegistration = new VacancyRegistration()
                        vacancyRegistration.registerVacancy()
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("11"):
                    try {
                        Integer id = InformationRequest.requestId()
                        IdValidation validation = new IdValidation(id, vacancyTable)
                        validation.execute()

                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(vacancyInformations, "Atualizar Dados da Vaga")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        if (chosenOption < 8){
                            String updatedInformation = (String) InformationRequest.addUpdatedInformation()
                            VacancyInformationsUpdate update = new VacancyInformationsUpdate(vacancyTable, id, chosenOption, updatedInformation)
                            update.execute()
                        }
                        else {
                            VacancyInformationsUpdate update = new VacancyInformationsUpdate(vacancyTable, id, chosenOption)
                            update.execute()
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("12"):
                    try {
                        Integer id = InformationRequest.requestId()

                        MenuOptionsSelection menuOptions = new MenuOptionsSelection(vacancyInformations, "Deletar Dados")
                        Integer chosenOption = menuOptions.selecMenuOption()

                        VacancyInformationsDeletion deletion = new VacancyInformationsDeletion(vacancyTable, id, chosenOption)
                        deletion.execute()
                    }
                    catch (Exception e){
                        e.printStackTrace()
                    }
                    break

                case("13"):
                    println "Encerrando..."
                    break
            }
        }
    }
}