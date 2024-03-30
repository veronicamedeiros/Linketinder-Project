package Entities

class Company extends Person{

    private String cnpj


    Company(String name, String email, String country, String cep, String state, String description, String cnpj, String password) {
        super(name, email, country, cep, state, description, password)
        setCnpj(cnpj)
    }


    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }

    String getCnpj() {
        return cnpj
    }


    /*@Override
    String toString() {
        return super.toString()+
                "\nCNPJ: $cnpj" +
                "\nCompetências desejadas: $desiredSkills"
    }*/
}
