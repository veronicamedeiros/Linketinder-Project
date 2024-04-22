package org.linketinder.model

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.menus.SkillsSelection


class CandidateInformationsUpdate{

    String tableName
    Integer id
    Integer chosenOption
    String updatedInformation


    CandidateInformationsUpdate(tableName, id, chosenOption) {
        this.tableName = tableName
        this.id = id
        this.chosenOption = chosenOption
    }

    CandidateInformationsUpdate(tableName, id, chosenOption, updatedInformation) {
        this.tableName = tableName
        this.id = id
        this.chosenOption = chosenOption
        this.updatedInformation = updatedInformation
    }


    void execute() {

        IdValidation validation = new IdValidation(id, tableName)
        validation.execute()

        if(chosenOption < 12){
            CandidateDAO candidateDao = new CandidateDAO(id, chosenOption, updatedInformation)
            candidateDao.update()
        }
        else {

            SkillsDAO skillsDao = new SkillsDAO(id)

            List<Map> candidateCurrentSkills = skillsDao.getCandidateSkills()
            EntitiesSkillsDisplay candidateSkillsDisplay = new EntitiesSkillsDisplay(candidateCurrentSkills)
            candidateSkillsDisplay.display()

            Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()

            List<Map> allSkills = skillsDao.getAllSkills()
            EntitiesSkillsDisplay allSkillsDisplay = new EntitiesSkillsDisplay(allSkills)
            allSkillsDisplay.display()

            Integer newSkill = (Integer) SkillsSelection.chooseNewSkill()
            CandidateDAO candidateDao= new CandidateDAO(id, chosenOption, oldSkill, newSkill)
            candidateDao.update()

        }
    }
}