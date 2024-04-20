package org.linketinder.model
import org.linketinder.DBDAO.CandidateDAO

class CandidatesDisplay {

    static execute(){

        try {
            def resposta = CandidateDAO.list()

            resposta.forEach({
                println("\nDESCRIÇÃO: " + it.description)
                println("HABILIDADES: " + it.skills)})
        }
        catch (e){
            e.printStackTrace()
        }
    }
}
