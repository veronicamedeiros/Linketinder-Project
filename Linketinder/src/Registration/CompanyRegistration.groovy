package Registration
import Entities.Company


class CompanyRegistration {

     static Company registration(){

        List<String> desiredSkills = new ArrayList<>()

        Scanner scanner = new Scanner(System.in)

        String skill

        try {
            print "Informe a razão social da empresa: "
            String name = scanner.nextLine()

            print "Informe o CNPJ: "
            String cnpj = scanner.nextLine()

            print "Informe o e-mail comercial:  "
            String email = scanner.nextLine()

            print "Informe o País: "
            String country = scanner.nextLine()

            print "Informe o Estado: "
            String state = scanner.nextLine()

            print "Informe o CEP: "
            String cep = scanner.nextLine()

            print "Escreva uma breve descrição sobre o perfil da empresa: "
            String description = scanner.nextLine()

            while (skill != "0"){

                println "\nHabilidades - Informe as habilidade desejadas em um candidato e pressione enter, insira quantas desejar."
                println "Caso não deseje informar mais nenhuma, pressione 0.\n"
                print "Habilidade: "
                skill = scanner.nextLine()

                if (skill == "0"){
                    break
                }

                desiredSkills.add(skill)
            }

            Company newCompany= new Company(name, email, country, cep, state, description, cnpj, desiredSkills)
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
        }
    }


    static addCompany(Company newCompany, List CompanyList){

        try {
            CompanyList.add(newCompany)
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
            return false
        }
    }
}
