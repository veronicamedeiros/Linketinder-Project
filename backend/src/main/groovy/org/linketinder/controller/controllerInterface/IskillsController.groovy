package org.linketinder.controller.controllerInterface


interface IskillsController {

    List<Map> getSkillsCatalog()

    List<Map> getCandidateSkills(Integer id)

    List<Map> getVacancySkills(Integer id)
}
