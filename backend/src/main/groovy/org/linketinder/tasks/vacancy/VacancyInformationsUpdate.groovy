package org.linketinder.tasks.vacancy

import org.linketinder.DBDAO.VacancyDAO
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.menus.SkillsSelection
import org.linketinder.traits.SkillsCatalogInvoke

class VacancyInformationsUpdate implements SkillsCatalogInvoke{

    private String tableName
    private Integer id
    private Integer chosenOption
    private String updatedInformation


    VacancyInformationsUpdate(String tableName, Integer id, Integer chosenOption) {
        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
    }

    VacancyInformationsUpdate(String tableName, Integer id, Integer chosenOption, String updatedInformation) {
        setTableName(tableName)
        setId(id)
        setChosenOption(chosenOption)
        setUpdatedInformation(updatedInformation)
    }


    void execute() {

        if(chosenOption < 8){
            VacancyDAO vacancyDao = new VacancyDAO(id, chosenOption, updatedInformation)
            vacancyDao.update()
        }
        else {

            SkillsDAO skillsDao = new SkillsDAO(id)

            List<Map> vacancyCurrentSkills = skillsDao.getVacancySkills()
            entitiesSkills.skills = vacancyCurrentSkills
            entitiesSkills.display()

            Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()

            showSkillsCatalog()

            Integer newSkill = (Integer) SkillsSelection.chooseNewSkill()

            VacancyDAO vacancyDao= new VacancyDAO(id, chosenOption, oldSkill, newSkill)
            vacancyDao.update()
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
