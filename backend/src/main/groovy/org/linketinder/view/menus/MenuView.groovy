package org.linketinder.view.menus


class MenuView {

    static String mainMenu(){

        List<String> mainMenuOptions = ["Listar Candidatos", "Cadastrar Candidatos", "Atualizar Candidato", "Excluir dados do Candidato",
                                        "Listar Empresas", "Cadastrar Empresas", "Atualizar Empresas", "Excluir dados da Empresa",
                                        "Listar Vagas", "Cadastrar Vagas", "Atualizar Vaga", "Excluir dados da Vaga", "Sair"]


        MenuOptionsSelectionView menuChoosenOption = new MenuOptionsSelectionView()
        Integer choosen = menuChoosenOption.selecMenuOption(mainMenuOptions, "Menu")
        return choosen
    }
}
