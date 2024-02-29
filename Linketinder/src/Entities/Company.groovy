package Entities

class Company extends Person{
    String cnpj
    ArrayList desiredSkills    //lista de competências desejadas do candidato

    @Override
    String toString() {
        return super.toString()+
                "\nCNPJ: $cnpj" +
                "\nCompetências desejadas: $desiredSkills"
    }
}
