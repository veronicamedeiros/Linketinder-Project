package Menus

import DatabaseConnection.SkillsConnection
import DatabaseConnection.VacancyConnection


class VacancyUpdateMenu {

    static Scanner scanner = new Scanner(System.in)

    static vacancyRegistrationNumber(){

        while (true){

            print('Informe o número do cadastro da vaga que deseja atualizar: ')

            Integer idVaga = scanner.nextInt()

            boolean numberExist = VacancyConnection.numberVacancyExists(idVaga)

            if (numberExist){

                return idVaga
            }
            else{

                println("\nVaga não encontrada.\n")
            }
        }
    }


    static chosenOption(){

        Integer answer

        while (true){

            println('\n' + '*' * 25 + '\n\t\tAtualização\n' + '*' * 25)

            println("1 para Nome do cargo")
            println("2 para Nível do cargo")
            println("3 para Turno do cargo")
            println("4 para Modelo do cargo")
            println("5 para Cidade do cargo")
            println("6 para Estado do cargo")
            println("7 para a Descrição do cargo")
            println("8 para as competências do cargo")

            print('\nDigite o número da informação você deseja atualizar: ')
            answer = (Integer) scanner.nextInt()

            if ( answer < 9 & answer > 0 ){

                return answer
            }
            else{
                println("\nOpção inválida.\n")
            }
        }
    }

    static updatedInformation(){

        print("\nInsira a nova informação e pressione enter: ")
        String x = scanner.nextLine()
        String updatedInformation = scanner.nextLine()
        return updatedInformation
    }

    static changeSKill(){

        print("\nInforme o número da habilidade que deseja selecionar: ")
        Integer changeSKill = (Integer) scanner.nextInt()
        return changeSKill
    }

    static updatedSkill(){

        SkillsConnection.listarSkills()

        print("\nInsira o número da nova habilidade e pressione enter: ")
        Integer updatedInformation = (Integer) scanner.nextInt()
        return updatedInformation
    }
}








