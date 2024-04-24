package org.linketinder.model

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.menus.SkillsSelection


class CandidateInformationsDeletion {

    private String tableName
    private Integer id
    private Integer chosenOption


    CandidateInformationsDeletion(tableName, id, chosenOption) {
        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
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


    String getTableName() {
        return tableName
    }

    void setTableName(String tableName) {
        this.tableName = tableName
    }

    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    Integer getChosenOption() {
        return chosenOption
    }

    void setChosenOption(Integer chosenOption) {
        this.chosenOption = chosenOption
    }
}