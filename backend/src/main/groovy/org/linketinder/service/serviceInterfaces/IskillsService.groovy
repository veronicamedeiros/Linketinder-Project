package org.linketinder.service.serviceInterfaces


interface IskillsService {

    List<Map> getSkillsCatalog()

    List<Map> getCandidateSkills(Integer id)

    List<Map> getVacancySkills(Integer id)
}