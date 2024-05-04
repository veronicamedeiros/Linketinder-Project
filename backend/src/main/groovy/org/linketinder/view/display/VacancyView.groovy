package org.linketinder.view.display


class VacancyView {

    VacancyView() {}


    void display(List<Map> vacancies){

        try {
            vacancies.forEach({
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
}