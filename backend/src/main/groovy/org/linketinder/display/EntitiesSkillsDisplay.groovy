package org.linketinder.display

class EntitiesSkillsDisplay {

    private List<Map> skills

    EntitiesSkillsDisplay(){}


     void display(){
        try {
            skills.forEach({
                print(it.skillCode + " - " + it.skillName + "\n")
            })
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }


    List<Map> getSkills() {
        return skills
    }

    void setSkills(List<Map> skills) {
        this.skills = skills
    }
}