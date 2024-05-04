package org.linketinder.service.serviceInterfaces


interface IvacancyService {

    void registerVacancy(List vacancyInfo)

    void updateVacancy(Integer id, Integer chosenOption, String updatedInformation)

    void updateVacancySkills(Integer id, Integer oldSkill, String updatedInformation)

    void deleteVacancyInfo(Integer id, Integer oldSkill)

    void deleteVacancySkills(Integer id, Integer oldSkill)

    List<Map> getVacancies()
}



