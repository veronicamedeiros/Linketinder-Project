package Menus

class VacancyDeleteMenu {

    static Scanner scanner = new Scanner(System.in)

    static chosenOption(){

        Integer answer

        while (true){

            println('\n' + '*' * 25 + '\n\t\tDeletar dados\n' + '*' * 25)

            println("1 para Nome do cargo")
            println("2 para Nível do cargo")
            println("3 para Turno do cargo")
            println("4 para Modelo do cargo")
            println("5 para Cidade do cargo")
            println("6 para Estado do cargo")
            println("7 para a Descrição do cargo")
            println("8 para as competências do cargo")

            println()
            print('\nDigite o número da informação você deseja apagar: ')
            answer = (Integer) scanner.nextInt()

            if ( answer < 9 & answer > 0 ){

                return answer
            }
            else{
                println("\nOpção inválida.\n")
            }
        }
    }
}
