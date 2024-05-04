package org.linketinder.controller

import org.linketinder.controller.controllerInterface.IvacancyController
import org.linketinder.service.VacancyService


class VacancyController implements IvacancyController{


    VacancyService vacancyService = new VacancyService()
    VacancyController(){}


    void registerVacancy(List vacancyInfo){

        vacancyService.registerVacancy(vacancyInfo)
    }


    void updateVacancy(Integer id, Integer chosenOption, String updatedInformation) {

        vacancyService.updateVacancy(id, chosenOption, updatedInformation)
    }


    void updateVacancySkills(Integer id, Integer oldSkill, Integer newSkill){

        vacancyService.updateVacancySkills(id, oldSkill, newSkill)
    }


    void deleteVacancyInfo(Integer id, Integer oldSkill) {

        vacancyService.deleteVacancyInfo(id, oldSkill)
    }


    void deleteVacancySkills(Integer id, Integer oldSkill){

        vacancyService.deleteVacancySkills(id, oldSkill)
    }


    List<Map> getVacancies(){

        List<Map> vacancies = vacancyService.getVacancies()
        return vacancies
    }
}
