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


                if (answer <= this.menuOptions.size() && answer >= 0) {
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
}