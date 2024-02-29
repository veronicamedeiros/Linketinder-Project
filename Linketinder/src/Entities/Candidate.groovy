package Entities

class Candidate extends Person {
    int age
    String cpf
    List skills

    @Override
    String toString() {
        return super.toString()+
                "\nidade: $age" +
                "\nCPF: $cpf" +
                "\ncompetências: $skills"
    }
}


