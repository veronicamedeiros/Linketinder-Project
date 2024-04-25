package org.linketinder.traits

import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.display.EntitiesSkillsDisplay

trait SkillsCatalogInvoke {

    EntitiesSkillsDisplay entitiesSkills = new EntitiesSkillsDisplay()
    EntitiesSkillsDisplay skillsCatalog = new EntitiesSkillsDisplay()

    void showSkillsCatalog(){
        SkillsDAO skillsDao = new SkillsDAO()
        List<Map> allSkills = skillsDao.getAllSkills()
        skillsCatalog.skills = allSkills
        skillsCatalog.display()
    }
}