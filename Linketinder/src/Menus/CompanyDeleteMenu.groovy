package Menus

class CompanyDeleteMenu {

    static Scanner scanner = new Scanner(System.in)

    static chosenOption(){

        while (true){

            Integer answer

            println('\n' + '*' * 25 + '\n\t\tDeletar dado\n' + '*' * 25)

            println("1 para Nome da empresa")
            println("2 para Email")
            println("3 para País")
            println("4 para CEP")
            println("5 para Estado ")
            println("6 para Descrição")
            println("7 para CNPJ")
            println("8 para Senha")

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
