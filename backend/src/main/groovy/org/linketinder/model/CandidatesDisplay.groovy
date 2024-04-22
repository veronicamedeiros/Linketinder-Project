package org.linketinder.model
import org.linketinder.DBDAO.CandidateDAO

class CandidatesDisplay {

    static execute(){

        try {

            CandidateDAO candidateDao = new CandidateDAO()
            List<Map> skills = candidateDao.list()

            skills.forEach({
                println("\nDESCRIÇÃO: " + it.description)
                println("HABILIDADES: " + it.skills)})
        }
        catch (e){
            e.printStackTrace()
        }
    }
}
