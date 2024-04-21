package org.linketinder.model

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.menus.MenuOptionsSelection
import org.linketinder.model.IdValidation

class CandidateInformationsUpdate {

    List<String> candidateMenuOptions

    CandidateInformationsUpdate() {}

    List<String> menuOptions

    execute() {

        print("Informe o número de cadastro de usuário")
        Scanner scanner = new Scanner(System.in)
        Integer id = scanner.nextInt()

        IdValidation validation = new IdValidation(id, "candidates")

        validation.execute()

        MenuOptionsSelection menu = new MenuOptionsSelection(candidateMenuOptions, "Atualizar Dados")

        Integer chosenOption = menu.selecMenuOption()

        if (chosenOption < 12){
            String updatedInformation = (String) MenuOptionsSelection.addUpdatedInformation()
            //adicionar no construtor do CandidateDAO
        }


        CandidateDAO candidate = new CandidateDAO(id, chosenOption)

        candidate.update()
    }
}