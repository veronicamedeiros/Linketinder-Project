package org.linketinder.display


class VacancyDisplay {

    private List<Map> skills

    VacancyDisplay(List<Map> skills) {
        setSkills(skills)
    }

    void display(){

        try {
            skills.forEach({
                println"""
                Cargo: $it.position
                Nível: $it.level
                Turno: $it.shift
                Modelo de Trabalho: $it.model
                Local: $it.city - $it.state
                Sobre a empresa: $it.company_description
                
                Descrição do Cargo: $it.job_description
                Habilidades desejadas para a vaga: $it.skills
                """
            })
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