package org.linketinder.model

class EntitiesSkillsDisplay {

    List<Map> skills

    EntitiesSkillsDisplay(skills){
        this.skills = skills
    }

     void display(){
        try {
            skills.forEach({
                print(it.skillCode + " - " + it.skillName + "\n")
            })
        }catch (Exception e){
            e.printStackTrace()
        }
    }
}
