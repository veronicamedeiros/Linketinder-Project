package org.linketinder.Entities

class Candidate extends Person {

    private String surname
    private String birth
    private Integer age
    private String cpf
    private List<Integer> skills

    Candidate(String name, String surname, String birth, String email, String country, String cep, String state, String description, Integer age, String cpf, List<Integer> skills, String password) {
        super(name, email, country, cep, state, description, password)
        setSurname(surname)
        setBirth(birth)
        setAge(age)
        setCpf(cpf)
        setSkills(skills)
    }

    Integer getAge() {
        return age
    }

    void setAge(Integer age) {
        this.age = age
    }

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    List<Integer> getSkills() {
        return skills
    }

    void setSkills(List<Integer> skills) {
        this.skills = skills
    }

    String getSurname() {
        return surname
    }

    void setSurname(String surname) {
        this.surname = surname
    }

    String getBirth() {
        return birth
    }

    void setBirth(String birth) {
        this.birth = birth
    }
}