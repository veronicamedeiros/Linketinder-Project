package org.linketinder.tasks.candidate

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.connection.ConnectionFactory
import org.linketinder.connection.DBconnection
import org.linketinder.menus.SkillsSelection
import org.linketinder.traits.SkillsCatalogInvoke


class CandidateInformationsUpdate implements SkillsCatalogInvoke {

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

        //DBconnection dbConnection = new ConnectionFactory().connectDataBase(Db.POSTGRESQL) implantar posteriormente

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

            showSkillsCatalog()

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