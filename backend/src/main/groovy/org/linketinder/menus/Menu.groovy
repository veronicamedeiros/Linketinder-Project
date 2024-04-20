package org.linketinder.menus
import org.linketinder.menus.MenuOptionsSelection

class Menu {

    String mainMenu(){



        List<String> mainMenuOptions = ["Listar Candidatos", "Cadastrar Candidatos", "Atualizar Candidato", "Excluir dados do Candidato",
                                        "Listar Empresas", "Cadastrar Empresas", "Atualizar Empresas", "Excluir dados da Empresa",
                                        "Listar Vagas", "Cadastrar Vagas", "Atualizar Vaga", "Excluir dados da Vaga", "Sair"]


        MenuOptionsSelection menuChoosenOption = new MenuOptionsSelection(mainMenuOptions, "Menu")
        Integer choosen = menuChoosenOption.selecMenuOption()
        print(" CHOOSEN: " + choosen)
        return choosen
    }
}
