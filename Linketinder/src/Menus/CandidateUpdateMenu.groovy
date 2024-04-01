package Menus

import DatabaseConnection.CandidateConnection
import DatabaseConnection.SkillsConnection
import DatabaseConnection.VacancyConnection

class CandidateUpdateMenu {
    static Scanner scanner = new Scanner(System.in)

    static candidateRegistrationNumber(){

        while (true){

            print('Informe o número de cadastro de usuário: ')

            Integer idCandidate = scanner.nextInt()

            boolean candidateExists = CandidateConnection.candidateExists(idCandidate)

            if (candidateExists){

                return idCandidate
            }
            else{

                println("\nUsuário não encontrada.\n")
            }
        }
    }


    static chosenOption(){

        Integer answer

        while (true){

            println('\n' + '*' * 25 + '\n\t\tAtualização\n' + '*' * 25)

            println("1 para Nome")
            println("2 para Sobrenome")
            println("3 para Data de Nascimento")
            println("4 para Email")
            println("5 para País")
            println("6 para CEP")
            println("7 para Estado ")
            println("8 para Descrição")
            println("9 para Idade")
            println("10 para CPF")
            println("11 para Senha")
            println("12 para Habilidades")


            print('\nDigite o número da informação você deseja atualizar: ')
            answer = (Integer) scanner.nextInt()

            if ( answer < 13 & answer > 0 ){

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

        print("\nInforme o número da habilidade que deseja atualizar: ")
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
