package org.linketinder.tasks.candidate

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.connection.ConnectionFactory
import org.linketinder.connection.DBconnection
import org.linketinder.display.EntitiesSkillsDisplay
import org.linketinder.entities.Candidate
import org.linketinder.menus.SkillsSelection
import org.linketinder.tasks.IdValidation
import org.linketinder.utilities.enums.Db


class CandidateInformationsDeletion{

    private String tableName
    private Integer id
    private Integer chosenOption


    CandidateInformationsDeletion(tableName, id, chosenOption) {
        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
    }


    void execute() {

        //DBconnection dbConnection = new ConnectionFactory().connectDataBase(Db.POSTGRESQL).connect()

        //CandidateDAO candidateDao = new Candidate(dbConnection)

        IdValidation validation = new IdValidation(id, tableName)
        validation.execute()

        if(chosenOption < 12){
            CandidateDAO candidateDao = new CandidateDAO(id, chosenOption)
            candidateDao.delete()
        }
        else {

            SkillsDAO skillsDao = new SkillsDAO(id)

            List<Map> candidateCurrentSkills = skillsDao.getCandidateSkills()
            EntitiesSkillsDisplay entitiesSkills = new EntitiesSkillsDisplay()
            entitiesSkills.skills = candidateCurrentSkills
            entitiesSkills.display()

            Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()

            CandidateDAO candidateDao = new CandidateDAO(id, chosenOption, oldSkill, 0)
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