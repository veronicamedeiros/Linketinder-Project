package Menus

class Menu {

    static String mainMenu(){

        Scanner scanner = new Scanner(System.in)
        String resp

        while(resp !in "12"){
            print("\n" + "*" * 40 + "\n")
            println " " * 15 + "Menu"
            print("*" * 40 +"\n")
            println "1 - Listar Candidatos"
            println "2 - Listar Empresas"
            println "3 - Listar Vagas"
            println "4 - Listar Habilidades"
            println "5 - Cadastrar Candidatos"
            println "6 - Cadastrar Empresas"
            println "7 - Cadastrar Vagas"
            println "8 - Atualizar Vagas"
            println "9 - Atualizar Candidatos"
            println "10 - Atualizar Empresas"
            println "11 - Excluir dados da Empresas"
            println "12 - Excluir dados do Candidato"
            println "13 - Excluir dados da Vaga"
            println "0 - Sair"

            print "\nInforme o número da opção desejada: "
            resp = scanner.next()
            println ""

            if (resp == "13" || resp == "12" || resp == "11" || resp == "10" || resp == "9" || resp == "8" || resp == "7" || resp == "6" || resp == "5" || resp == "4" ||resp == "3" || resp == "2" || resp == "1" || resp == "0"){
                return resp
            }
                println "\nOpção inválida!\n"

        }
    }
}
