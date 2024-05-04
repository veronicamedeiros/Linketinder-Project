package org.linketinder.controller.controllerInterface



interface IvacancyController {

    void registerVacancy(List vacancyInfo)

    void updateVacancy(Integer id, Integer chosenOption, String updatedInformation)

    void updateVacancySkills(Integer id, Integer oldSkill, Integer newSkill)

    void deleteVacancyInfo(Integer id, Integer oldSkill)

    void deleteVacancySkills(Integer id, Integer oldSkill)

    List<Map> getVacancies()
}
