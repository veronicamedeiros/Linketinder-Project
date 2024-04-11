package org.linketinder.Menus


static Integer selecMenuOption(ArrayList<String> menuOptions, String menuHeaderMsg) {

    Scanner scanner = new Scanner(System.in)

    while (true){

        try{

            println('\n' + '*' * 40 + "\n${menuHeaderMsg.center(40)}\n" + '*' * 40)

            menuOptions.eachWithIndex { String option, int index ->
                print("\n${index + 1} para $option")
            }

            print('\n\nDigite o número da opção que você deseja selecionar: ')
            Integer answer = (Integer) scanner.nextInt()

            if (answer <= menuOptions.size() & answer >= 0){
                return answer
            }else{
                println("\nOpção inválida.\n")
            }
        }
        catch (Exception e){
            e.getMessage()
        }
    }
}


static addUpdatedInformation(){

    Scanner scanner = new Scanner(System.in)

    print("\nInsira a nova informação e pressione enter: ")
    String updatedInformation = scanner.nextLine()

    return updatedInformation
}
