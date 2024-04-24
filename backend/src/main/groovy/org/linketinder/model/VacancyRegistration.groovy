package org.linketinder.model

import org.linketinder.DBDAO.VacancyDAO
import org.linketinder.entities.Vacancy
import org.linketinder.menus.VacancyRegistrationMenu

class VacancyRegistration {

    void registerVacancy(){

        try {
            VacancyRegistrationMenu newRegistration = new VacancyRegistrationMenu()
            Vacancy newVacancy = newRegistration.registerVacancyInformations()

            VacancyDAO dbRegistration = new VacancyDAO(newVacancy)
            dbRegistration.register()
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }
}
