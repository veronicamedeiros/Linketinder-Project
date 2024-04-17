package org.linketinder.menus

class Menu {

    static String mainMenu(){

        List<String> mainMenuOptions = ["Listar Candidatos", "Cadastrar Candidatos", "Atualizar Candidato", "Excluir dados do Candidato",
                                        "Listar Empresas", "Cadastrar Empresas", "Atualizar Empresas", "Excluir dados da Empresa",
                                        "Listar Vagas", "Cadastrar Vagas", "Atualizar Vaga", "Excluir dados da Vaga", "Sair"]


        Integer manuChoosenOption = MenuOptionsSelection.selecMenuOption(mainMenuOptions, "Menu")

        return manuChoosenOption
    }
}
