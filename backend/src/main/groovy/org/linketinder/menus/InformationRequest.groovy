package org.linketinder.menus

class InformationRequest {


    static String addUpdatedInformation() {

        print("\nInsira a nova informação e pressione enter: ")
        Scanner scanner = new Scanner(System.in)
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
