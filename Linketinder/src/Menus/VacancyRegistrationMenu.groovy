package Menus

import DatabaseConnection.SkillsConnection
import Entities.Vacancy

class VacancyRegistrationMenu {

    static Vacancy registration(){

        List<Integer> desiredSkills = new ArrayList<>()
        Scanner scanner = new Scanner(System.in)
        Integer skill


        try {
            print "Informe o nome do cargo: "
            String position = scanner.nextLine()

            print "Informe o nível do cargo: "
            String level = scanner.nextLine()

            print "Informe o turno de trabalho (manhã, tarde, noite): "
            String shift = scanner.nextLine()

            print "Informe o modelo de trabalho (presencial, remoto, híbrido): "
            String model = scanner.nextLine()

            print "Informe a Cidade: "
            String city = scanner.nextLine()

            print "Informe o Estado: "
            String state = scanner.nextLine()

            print "Descreva o cargo: "
            String jobDescription = scanner.nextLine()

            print "Informe o número de cadastro da empresa: "
            int  idCompany = scanner.nextInt()

            while (skill != 0){

                print("*" * 40 + "\n")
                println " " * 15 + "Habilidades"
                print("*" * 40 +"\n")

                SkillsConnection.listAllSkills()
                println "\nDigite o número referente à habilidade desejada para a vaga e pressione enter."
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
                        desiredSkills.add(skill)
                    }
                }
            }

            Vacancy newVacancy = new Vacancy(position, level, shift, model, city, state, jobDescription, desiredSkills, idCompany)
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
        }
    }

    static addVacancy(Vacancy newVacancy){

        try {
            return newVacancy
        }
        catch (Exception e){
            println "\nOcorreu um erro: $e \n"
            return false
        }
    }
}
