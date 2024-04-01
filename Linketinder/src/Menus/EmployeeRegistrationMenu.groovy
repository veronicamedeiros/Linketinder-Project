package Menus

import DatabaseConnection.SkillsConnection
import Entities.Candidate


class EmployeeRegistrationMenu {

     static Candidate registration(){

        List<Integer> skills = new ArrayList<>()
        Scanner scanner = new Scanner(System.in)
        Integer skill


        try {
            print "Informe seu primeiro nome: "
            String name = scanner.nextLine()

            print "Informe seu sobrenome: "
            String surname = scanner.nextLine()

            print "Informe sua data de nascimento (\"yyyy-MM-dd\"): "
            String birth = scanner.next()
            String y = scanner.nextLine()

            print "Crie uma senha de pelo menos 6 dígitos: "
            String password = scanner.nextLine()

            print "Informe sua idade: "
            Integer age = scanner.nextInt()

            print "Informe seu CPF: "
            String x = scanner.nextLine()
            String cpf = scanner.nextLine()

            print "Informe seu melhor e-mail: "
            String email = scanner.nextLine()

            print "Informe o País: "
            String country = scanner.nextLine()

            print "Informe o Estado: "
            String state = scanner.nextLine()

            print "Informe o CEP: "
            String cep = scanner.nextLine()

            print "Escreva uma breve descrição sobre seu perfil profissional: "
            String description = scanner.nextLine()

            while (skill != 0){

                print("*" * 40 + "\n")
                println " " * 15 + "Habilidades"
                print("*" * 40 +"\n")

                SkillsConnection.listarSkills()
                println "\nDigite o número referente à habilidade desejada e pressione enter."
                println "Caso não deseje informar mais nenhuma, pressione 0.\n"

                print("Habilidade: ")
                skill = (Integer) scanner.nextInt()


                if(skill < 0 | skill > 21) {
                    println("Opção inválida.")
                }
                else{
                    if (skill == 0) {
                        break
                    }else{
                        skills.add(skill)
                    }
                }
            }

            Candidate newCandidate = new Candidate(name, surname, birth, email, country, cep, state, description, age, cpf, skills as List<String>, password)
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
        }
    }

    static addCandidate(Candidate newCandidate){

        try {
            return newCandidate
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
            return false
        }
    }
}
