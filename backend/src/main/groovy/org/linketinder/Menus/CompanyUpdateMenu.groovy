package org.linketinder.Menus

import org.linketinder.DatabaseConnection.CompanyConnection

class CompanyUpdateMenu {

    static Scanner scanner = new Scanner(System.in)

    static companyRegistrationNumber(){

        while (true){

            print('Informe o número de cadastro da empresa: ')

            Integer idCompany = scanner.nextInt()

            boolean companyExists = CompanyConnection.companyExists(idCompany)

            if (companyExists){

                return idCompany
            }
            else{

                println("\nEmpresa não encontrada.\n")
            }
        }
    }


    static chosenOption(){

        Integer answer

        while (true){

            println('\n' + '*' * 25 + '\n\t\tAtualização\n' + '*' * 25)

            println("1 para Nome da empresa")
            println("2 para Email")
            println("3 para País")
            println("4 para CEP")
            println("5 para Estado ")
            println("6 para Descrição")
            println("7 para CNPJ")
            println("8 para Senha")

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
}
