package Registration

import Entities.Candidate


class EmployeeRegistration {

     static Candidate registration(){

        List<String> skills = new ArrayList<>()

        Scanner scanner = new Scanner(System.in)

        String skill

        try {
            print "Informe seu nome completo: "
            String name = scanner.nextLine()

            print "Informe sua idade: "
            int age = scanner.nextInt()

            print "Informe seu CPF: "
            String x = scanner.nextLine()
            String cpf = scanner.nextLine()

            print "Informe seu melhor e-mail:  "
            String email = scanner.nextLine()

            print "Informe o País: "
            String country = scanner.nextLine()

            print "Informe o Estado: "
            String state = scanner.nextLine()

            print "Informe o CEP: "
            String cep = scanner.nextLine()

            print "Escreva uma breve descrição sobre seu perfil profissional: "
            String description = scanner.nextLine()

            while (skill != "0"){

                println "\nHabilidades - Informe uma habilidade e pressione enter, insira quantas desejar."
                println "Caso não deseje informar mais nenhuma, pressione 0.\n"
                print "Habilidade: "
                skill = scanner.nextLine()

                if (skill == "0"){
                    break
                }

                skills.add(skill)
            }

            Candidate newCandidate = new Candidate(name, email, country, cep, state, description, age, cpf, skills)
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
        }
    }


    static addCandidate(Candidate newCandidate, List candidateList){

        try {
            candidateList.add(newCandidate)
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
            return false
        }
    }
}
