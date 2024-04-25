package org.linketinder.display


class CompanyDisplay {

    private List<Map> descriptions

    CompanyDisplay(List<Map> descriptions) {
        setDescriptions(descriptions)
    }

    void display(){

        try {
            descriptions.forEach({
                println("\nDESCRIÇÃO: " + it.description)})
        }
        catch (e){
            e.printStackTrace()
        }
    }


    List<Map> getDescriptions() {
        return descriptions
    }

    void setDescriptions(List<Map> descriptions) {
        this.descriptions = descriptions
    }
}
