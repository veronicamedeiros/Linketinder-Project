package org.linketinder.view.menus

import org.linketinder.controller.IdValidationController

class InformationRequestView {


    static String addUpdatedInformation() {

        print("\nInsira a nova informação e pressione enter: ")
        Scanner scanner = new Scanner(System.in)
        String updatedInformation = scanner.nextLine()

        return updatedInformation
    }


    static Integer requestId(String tableName){

        Integer id

        while (true){
            print("\nInforme o número de cadastro: ")
            Scanner scanner = new Scanner(System.in)
            id = scanner.nextInt()

            IdValidationController idValidationController = new IdValidationController()
            boolean validationId= idValidationController.validate(id, tableName)

            if(!validationId){
                println("\nCadastro não encontrado.")
            }
            else{
                return id
            }
        }
    }
}
