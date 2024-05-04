package org.linketinder.view.display


class CandidatesView {

    CandidatesView() {}


    void display(List<Map> candidates){

        try {

            candidates.forEach({
                println("\nDESCRIÇÃO: " + it.description)
                println("HABILIDADES: " + it.skills)})
        }
        catch (e){
            e.printStackTrace()
        }
    }
}
