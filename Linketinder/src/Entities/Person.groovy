package Entities

class Person{
    String name
    String email
    String country
    String cep
    String state
    String description

    @Override
    String toString() {
        return "\n\nnome: $name" +
                "\ne-mail: $email" +
                "\\país: $country" +
                "\nestado: $state" +
                "\nCEP: $cep" +
                "\ndescrição: $description"
    }
}
