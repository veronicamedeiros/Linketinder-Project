package org.linketinder


import org.linketinder.menus.Menu
import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.CompanyDAO
import org.linketinder.DBDAO.VacancyDAO



class Main{
    static void main(String[] args) {

        String resp;

        while (resp != "13"){

            resp = Menu.mainMenu()

            switch (resp){

            case("1"):
                CandidateDAO.listAllCandidates()
                break

            case("2"):
                CandidateDAO.registerCandidates()
                break

            case("3"):
                CandidateDAO.updateCandidatesInformations()
                break

            case("4"):
                CandidateDAO.deleteCandidatesInformations()
                break

            case("5"):
                CompanyDAO.listAllCompanies()
                break

            case("6"):
                CompanyDAO.registerCompanies()
                break

            case("7"):
                CompanyDAO.updateCompaniesInformations()
                break

            case("8"):
                CompanyDAO.deleteCompaniesInformations()
                break

            case("9"):
                VacancyDAO.listAllVacancies()
                break

            case("10"):
                VacancyDAO.registerVacancies()
                break

            case("11"):
                VacancyDAO.updateVacanciesInformations()
                break

            case("12"):
                VacancyDAO.deleteVacanciesInformations()
                break

            case("13"):
                println "Encerrando..."
                break
            }
        }
    }
}


