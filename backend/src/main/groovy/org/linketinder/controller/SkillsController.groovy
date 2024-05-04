package org.linketinder.controller

import org.linketinder.controller.controllerInterface.IskillsController
import org.linketinder.service.SkillsService

class SkillsController implements IskillsController{

    SkillsService skillsService = new SkillsService()

    SkillsController() {}

     List<Map> getSkillsCatalog() {
        List<Map> allSkills = skillsService.getSkillsCatalog()
        return allSkills
    }


    List<Map> getCandidateSkills(Integer id){
        List<Map> candidateSkills = skillsService.getCandidateSkills(id)
        return candidateSkills
    }


    List<Map> getVacancySkills(Integer id){
        List<Map> vacancySkills = skillsService.getVacancySkills(id)
        return vacancySkills
    }
}
