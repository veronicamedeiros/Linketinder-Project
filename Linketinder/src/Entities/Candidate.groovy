package Entities

class Candidate extends Person {
    private int age
    private String cpf
    private List<String> skills

 

    Candidate(String name, String email, String country, String cep, String state, String description, int age, String cpf, List<String> skills) {
        super(name, email, country, cep, state, description)
        setAge(age)
        setCpf(cpf)
        setSkills(skills)
    }

    int getAge() {
        return age
    }

    void setAge(int age) {
        this.age = age
    }

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    List<String> getSkills() {
        return skills
    }

    void setSkills(List<String> skills) {
        this.skills = skills
    }

    @Override
    String toString() {
        return super.toString()+
                "\nidade: $age" +
                "\nCPF: $cpf" +
                "\ncompetências: $skills"
    }
}


