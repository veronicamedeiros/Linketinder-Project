package org.linketinder.menus


class MenuOptionsSelection {

    ArrayList<String> menuOptions
    String menuHeaderMsg

    MenuOptionsSelection(menuOptions, menuHeaderMsg) {
        this.menuOptions = menuOptions
        this.menuHeaderMsg = menuHeaderMsg
    }

    Integer selecMenuOption() {

        Scanner scanner = new Scanner(System.in)

        while (true) {

            try {

                println('\n' + '*' * 40 + "\n${menuHeaderMsg.center(40)}\n" + '*' * 40)

                menuOptions.eachWithIndex { String option, int index ->
                    print("\n${index + 1} para $option")
                }

                print('\n\nDigite o número da opção que você deseja selecionar: ')
                Integer answer = scanner.nextInt()

                print(" ANSWER: " + answer)

                if (answer <= this.menuOptions.size() && answer >= 0) {
                    print(" ANSWER: " + answer)
                    return answer
                } else {
                    println("\nOpção inválida.\n")
                }
            }
            catch (Exception e) {
                e.getMessage()
            }
        }
    }


    protected String addUpdatedInformation() {

        Scanner scanner = new Scanner(System.in)

        print("\nInsira a nova informação e pressione enter: ")
        String updatedInformation = scanner.nextLine()

        return updatedInformation
    }
}