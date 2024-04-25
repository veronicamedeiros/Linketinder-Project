package org.linketinder.traits

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.CompanyDAO
import org.linketinder.DBDAO.VacancyDAO
import org.linketinder.display.CandidatesDisplay
import org.linketinder.display.CompanyDisplay
import org.linketinder.display.VacancyDisplay


trait EntitiesDisplayInvoke {


    void showCandidates(){

        CandidateDAO candidateDao = new CandidateDAO()
        List<Map> skills = candidateDao.list()

        CandidatesDisplay candidate = new CandidatesDisplay(skills)
        candidate.display()
    }


   void showCompanies(){

       CompanyDAO companyDao = new CompanyDAO()
       List<Map> descriptions = companyDao.list()

       CompanyDisplay companies = new CompanyDisplay(descriptions)
       companies.display()
    }


    void showVacancies(){

        VacancyDAO vacancyDao = new VacancyDAO()
        List<Map> skills = vacancyDao.list()

        VacancyDisplay vacancies = new VacancyDisplay(skills)
        vacancies.display()
    }
}