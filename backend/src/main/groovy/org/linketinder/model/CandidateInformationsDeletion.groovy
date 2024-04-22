package org.linketinder.model

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.menus.SkillsSelection


class CandidateInformationsDeletion {

    String tableName
    Integer id
    Integer chosenOption


    CandidateInformationsDeletion(tableName, id, chosenOption) {
        this.tableName = tableName
        this.id = id
        this.chosenOption = chosenOption
    }


    void execute() {

        IdValidation validation = new IdValidation(id, tableName)
        validation.execute()

        if(chosenOption < 12){
            CandidateDAO candidateDao = new CandidateDAO(id, chosenOption)
            candidateDao.delete()
        }
        else {

            SkillsDAO skillsDao = new SkillsDAO(id)

            List<Map> candidateCurrentSkills = skillsDao.getCandidateSkills()
            EntitiesSkillsDisplay candidateSkillsDisplay = new EntitiesSkillsDisplay(candidateCurrentSkills)
            candidateSkillsDisplay.display()

            Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()

            CandidateDAO candidateDao = new CandidateDAO(id, chosenOption, oldSkill)
            candidateDao.delete()
        }
    }
}
