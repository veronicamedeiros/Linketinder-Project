package Menus

class CandidateDeleteMenu {

    static Scanner scanner = new Scanner(System.in)

    static chosenOption(){

        Integer answer

        while (true){

            println('\n' + '*' * 25 + '\n\t\tDeletar dados\n' + '*' * 25)

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

            println()
            print('\nDigite o número da informação você deseja apagar: ')
            answer = (Integer) scanner.nextInt()

            if ( answer < 13 & answer > 0 ){

                return answer
            }
            else{
                println("\nOpção inválida.\n")
            }
        }
    }

}
