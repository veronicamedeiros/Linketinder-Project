package org.linketinder.menus

class InformationRequest {

    static String addUpdatedInformation() {

        Scanner scanner = new Scanner(System.in)

        print("\nInsira a nova informação e pressione enter: ")
        String updatedInformation = scanner.nextLine()

        return updatedInformation
    }

    static Integer requestId(){
        print("\nInforme o número de cadastro: ")
        Scanner scanner = new Scanner(System.in)
        Integer id = scanner.nextInt()
        return id
    }
}
