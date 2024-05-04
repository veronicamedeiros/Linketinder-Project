package org.linketinder.view.menus


class CompanyRegistrationMenuView {

    static List registerCompanyInformations(){

         Scanner scanner = new Scanner(System.in)

        try {
            print "Informe a razão social da empresa: "
            String name = scanner.nextLine()

            print "Informe o CNPJ: "
            String cnpj = scanner.nextLine()

            print "Informe o e-mail comercial: "
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

            List companyInfo = [name, email, country, cep, state, description, cnpj, password]

            return companyInfo
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }
}
