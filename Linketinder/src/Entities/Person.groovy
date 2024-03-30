package Entities

class Person{
    private String name
    private String email
    private String country
    private String cep
    private String state
    private String description
    private String password

    Person (String name, String email, String country, String cep, String state, String description, password){
        setName(name)
        setEmail(email)
        setCountry(country)
        setCep(cep)
        setState(state)
        setDescription(description)
        setPassword(password)
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getCountry() {
        return country
    }

    void setCountry(String country) {
        this.country = country
    }

    String getCep() {
        return cep
    }

    void setCep(String cep) {
        this.cep = cep
    }

    String getState() {
        return state
    }

    void setState(String state) {
        this.state = state
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    String getPassword(){
        return password
    }

    void setPassword(String password){
        this.password = password
    }


 /*   @Override
    String toString() {
        return "\n\nnome: $name" +
                "\ne-mail: $email" +
                "\npaís: $country" +
                "\nestado: $state" +
                "\nCEP: $cep" +
                "\ndescrição: $description"
    }*/
}
