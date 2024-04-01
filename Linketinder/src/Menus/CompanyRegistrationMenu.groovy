package Menus
import Entities.Company


class CompanyRegistrationMenu {

     static Company registration(){

         Scanner scanner = new Scanner(System.in)

        try {
            print "Informe a razão social da empresa: "
            String name = scanner.nextLine()

            print "Informe o CNPJ: "
            String cnpj = scanner.nextLine()

            print "Informe o e-mail comercial:  "
            String email = scanner.nextLine()

            print "Crie uma senha de pelo menos 6 dígitos: "
            String password = scanner.nextLine()

            print "Informe o País: "
            String country = scanner.nextLine()

            print "Informe o Estado: "
            String state = scanner.nextLine()

            print "Informe o CEP: "
            String cep = scanner.nextLine()

            print "Escreva uma breve descrição sobre o perfil da empresa (apenas informações que não identifiquem a empresa): "
            String description = scanner.nextLine()


            Company newCompany= new Company(name, email, country, cep, state, description, cnpj, password)
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
        }
    }


    static addCompany(Company newCompany, List CompanyList){

        try {
            return newCompany
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
            return false
        }
    }
}
