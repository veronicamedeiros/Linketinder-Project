package org.linketinder.tasks.vacancy

import org.linketinder.DBDAO.VacancyDAO
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.display.EntitiesSkillsDisplay
import org.linketinder.menus.SkillsSelection
import org.linketinder.tasks.IdValidation


class VacancyInformationsDeletion {

    private String tableName
    private Integer id
    private Integer chosenOption


    VacancyInformationsDeletion (tableName, id, chosenOption) {
        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
    }


    void execute() {

        IdValidation validation = new IdValidation(id, tableName)
        validation.execute()

        if(chosenOption < 8){
            VacancyDAO vacancyDao = new VacancyDAO(id, chosenOption)
            vacancyDao.delete()
        }
        else {
            SkillsDAO skillsDao = new SkillsDAO(id)

            EntitiesSkillsDisplay entitiesSkills = new EntitiesSkillsDisplay()

            List<Map> vacancyCurrentSkills = skillsDao.getVacancySkills()
            entitiesSkills.skills = vacancyCurrentSkills
            entitiesSkills.display()

            Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()

            VacancyDAO vacancyDao = new VacancyDAO(id, chosenOption, oldSkill, 0)
            vacancyDao.delete()
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
