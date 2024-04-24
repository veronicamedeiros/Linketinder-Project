package org.linketinder.model

import org.linketinder.DBDAO.VacancyDAO

class VacancyDisplay {

    static execute(){

        try {

            VacancyDAO vacancyDao = new VacancyDAO()
            List<Map> skills = vacancyDao.list()

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
}

