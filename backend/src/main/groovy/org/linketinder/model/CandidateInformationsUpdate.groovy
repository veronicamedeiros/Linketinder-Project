package org.linketinder.model

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.menus.SkillsSelection
import org.linketinder.traits.display


class CandidateInformationsUpdate implements display{

    private String tableName
    private Integer id
    private Integer chosenOption
    private String updatedInformation


    CandidateInformationsUpdate(String tableName, Integer id, Integer chosenOption) {
        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
    }

    CandidateInformationsUpdate(String tableName, Integer id, Integer chosenOption, String updatedInformation) {
        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
        setUpdatedInformation(updatedInformation)
    }


    void execute() {

        if(chosenOption < 12){
            CandidateDAO candidateDao = new CandidateDAO(id, chosenOption, updatedInformation)
            candidateDao.update()
        }
        else {

            SkillsDAO skillsDao = new SkillsDAO(id)

            List<Map> candidateCurrentSkills = skillsDao.getCandidateSkills()
            entitiesSkills.skills = candidateCurrentSkills
            entitiesSkills.display()

            Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()

            List<Map> allSkills = skillsDao.getAllSkills()
            skillsCatalog.skills = allSkills
            skillsCatalog.display()

            Integer newSkill = (Integer) SkillsSelection.chooseNewSkill()

            CandidateDAO candidateDao= new CandidateDAO(id, chosenOption, oldSkill, newSkill)
            candidateDao.update()
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

    String getUpdatedInformation() {
        return updatedInformation
    }

    void setUpdatedInformation(String updatedInformation) {
        this.updatedInformation = updatedInformation
    }
}