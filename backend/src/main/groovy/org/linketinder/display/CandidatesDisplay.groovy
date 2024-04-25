package org.linketinder.display


class CandidatesDisplay {

    private List<Map> skills


    CandidatesDisplay(List<Map> skills) {
        setSkills(skills)
    }


    void display(){

        try {

            skills.forEach({
                println("\nDESCRIÇÃO: " + it.description)
                println("HABILIDADES: " + it.skills)})
        }
        catch (e){
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
