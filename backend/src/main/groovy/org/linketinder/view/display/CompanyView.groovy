package org.linketinder.view.display


class CompanyView {

    CompanyView() {}


    void display(List<Map> descriptions){

        try {
            descriptions.forEach({
                println("\nDESCRIÇÃO: " + it.description)})
        }
        catch (e){
            e.printStackTrace()
        }
    }
}
