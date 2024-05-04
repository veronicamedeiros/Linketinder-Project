package org.linketinder.view.menus

import org.linketinder.controller.CandidateController
import org.linketinder.controller.CompanyController
import org.linketinder.controller.SkillsController
import org.linketinder.controller.VacancyController
import org.linketinder.view.display.CandidatesView
import org.linketinder.view.display.CompanyView
import org.linketinder.view.display.EntitiesSkillsView
import org.linketinder.view.display.VacancyView


class InitialView {

    List<String> candidateInformations = ["Nome", "Sobrenome", "Ano de Nascimento", "Email", "País", "CEP", "Estado", "Descrição", "Idade", "CPF", "Senha", "Habilidades"]
    List<String> companyInformations = ["Nome da Empresa", "Email", "País", "CEP", "Estado", "Descrição", "CNPJ", "Senha"]
    List<String> vacancyInformations = ["Nome ", "Nível", "Turno", "Modelo", "Cidade", "Estado", "Descrição", "Competências"]


    final String candidateTable = "candidates"
    final String companyTable = "company"
    final String vacancyTable = "vacancy"

    InitialView(){}


    CandidateController candidateController = new CandidateController()
    CompanyController companyController = new CompanyController()
    VacancyController vacancyController = new VacancyController()
    SkillsController skillsController = new SkillsController()

    MenuOptionsSelectionView menuOptions = new MenuOptionsSelectionView()
    EntitiesSkillsView entitiesSkillsDisplay = new EntitiesSkillsView()

     void execute() {

        MenuView menu = new MenuView()
        String resp

        while (resp != "13"){

            resp =  menu.mainMenu()

            try{
                switch (resp){

                    case("1"):

                        List<Map> candidates = candidateController.getCandidates()

                        CandidatesView candidatesDisplayView = new CandidatesView()
                        candidatesDisplayView.display(candidates)

                        break

                    case("2"):

                        CandidateRegistrationMenuView newRegistration = new CompanyRegistrationMenuView()
                        List candidateInfoView = newRegistration.registerCandidateInformations()
                        candidateController.registerCandidate(candidateInfoView)

                        break

                    case("3"):

                        Integer id = InformationRequestView.requestId(candidateTable)
                        Integer chosenOption = menuOptions.selecMenuOption(candidateInformations, "Atualizar Dados")

                        if (chosenOption < 12){

                            String updatedInformation = (String) InformationRequestView.addUpdatedInformation()
                            candidateController.updateCandidate(id, chosenOption, updatedInformation)
                        }
                        else {

                            List<Map> skills = skillsController.getCandidateSkills(id)
                            entitiesSkillsDisplay.display(skills)

                            Integer oldSkill = (Integer) SkillsSelectionView.chooseOldSKill()
                            List<Map> skillCatalog = skillsController.getSkillsCatalog()
                            entitiesSkillsDisplay.display(skillCatalog)
                            Integer newSkill = (Integer) SkillsSelectionView.chooseNewSkill()
                            candidateController.updateCandidateSkills(id, oldSkill, newSkill)
                        }
                        break

                    case("4"):

                        Integer id = InformationRequestView.requestId(candidateTable)
                        Integer chosenOption = menuOptions.selecMenuOption(candidateInformations, "Deletar Dados")

                        if (chosenOption < 12){

                            candidateController.deleteCandidateInfo(id, chosenOption)
                        }
                        else {

                            List<Map> skills = skillsController.getCandidateSkills(id)
                            entitiesSkillsDisplay.display(skills)

                            Integer oldSkill = (Integer) SkillsSelectionView.chooseOldSKill()
                            candidateController.deleteCandidateSkills(id, oldSkill)
                        }
                        break

                    case("5"):

                        List<Map> companies = companyController.getCompanies()

                        CompanyView companyDisplayView = new CompanyView()
                        companyDisplayView.display(companies)

                        break

                    case("6"):

                        CompanyRegistrationMenuView newRegistration = new CompanyRegistrationMenuView()
                        List companyInfo = newRegistration.registerCompanyInformations()
                        companyController.registerCompany(companyInfo)

                        break

                    case("7"):

                        Integer id = InformationRequestView.requestId(companyTable)
                        Integer chosenOption = menuOptions.selecMenuOption(companyInformations, "Atualizar Dados")

                        String updatedInformation = (String) InformationRequestView.addUpdatedInformation()
                        companyController.updateCompany(id, chosenOption, updatedInformation)

                        break

                    case("8"):

                        Integer id = InformationRequestView.requestId(companyTable)

                        Integer chosenOption = menuOptions.selecMenuOption(companyInformations, "Deletar Dados")
                        companyController.deleteCompanyInfo(id, chosenOption)

                        break

                    case("9"):

                        List<Map> vacancies = vacancyController.getVacancies()
                        VacancyView VacancyDisplayView = new VacancyView()
                        VacancyDisplayView.display(vacancies)

                        break

                    case("10"):

                        VacancyRegistrationMenuView newRegistration = new VacancyRegistrationMenuView()
                        List vacancyInfo = newRegistration.registerVacancyInformations()
                        vacancyController.registerVacancy(vacancyInfo)

                        break

                    case("11"):

                        Integer id = InformationRequestView.requestId(vacancyTable)
                        Integer chosenOption = menuOptions.selecMenuOption(vacancyInformations, "Atualizar Dados da Vaga")

                        if (chosenOption < 8){
                            String updatedInformation = (String) InformationRequestView.addUpdatedInformation()
                            vacancyController.updateVacancy(id, chosenOption, updatedInformation)
                        }
                        else {
                            List<Map> skills = skillsController.getVacancySkills(id)
                            entitiesSkillsDisplay.display(skills)
                            Integer oldSkill = (Integer) SkillsSelectionView.chooseOldSKill()
                            List<Map> skillCatalog = skillsController.getSkillsCatalog()
                            entitiesSkillsDisplay.display(skillCatalog)
                            Integer newSkill = (Integer) SkillsSelectionView.chooseNewSkill()
                            vacancyController.updateVacancySkills(id, oldSkill, newSkill)
                        }
                        break

                    case("12"):

                        Integer id = InformationRequestView.requestId(vacancyTable)
                        Integer chosenOption = menuOptions.selecMenuOption(vacancyInformations, "Deletar Dados")

                        if(chosenOption < 8) {
                            vacancyController.deleteVacancyInfo(id, chosenOption)
                        }
                        else{
                            List<Map> skills = skillsController.getVacancySkills(id)
                            entitiesSkillsDisplay.display(skills)
                            Integer oldSkill = (Integer) SkillsSelectionView.chooseOldSKill()

                            vacancyController.deleteVacancySkills(id, oldSkill)
                        }
                        break

                    case("13"):
                        println "Encerrando..."
                        break
                }
            }catch(Exception e){
                e.printStackTrace()
            }
        }
    }
 }
