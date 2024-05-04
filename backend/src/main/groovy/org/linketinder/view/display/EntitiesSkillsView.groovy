package org.linketinder.view.display

class EntitiesSkillsView {

    EntitiesSkillsView(){}


     void display(List<Map> skills){
        try {
            skills.forEach({
                print(it.skillCode + " - " + it.skillName + "\n")
            })
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }

}