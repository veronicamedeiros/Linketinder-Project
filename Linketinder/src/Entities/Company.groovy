package Entities

class Company extends Person{
    String cnpj
    List<String> desiredSkills

    Company(String name, String email, String country, String cep, String state, String description, String cnpj, List<String> desiredSkills) {
        super(name, email, country, cep, state, description)
        setCnpj(cnpj)
        setDesiredSkills(desiredSkills)
    }

    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }

    void setDesiredSkills(List<String> desiredSkills) {
        this.desiredSkills = desiredSkills
    }

    @Override
    String toString() {
        return super.toString()+
                "\nCNPJ: $cnpj" +
                "\nCompetências desejadas: $desiredSkills"
    }
}
