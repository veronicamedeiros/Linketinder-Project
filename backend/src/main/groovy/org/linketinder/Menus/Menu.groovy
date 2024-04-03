package org.linketinder.Menus

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
            println "4 - Cadastrar Candidatos"
            println "5 - Cadastrar Empresas"
            println "6 - Cadastrar Vagas"
            println "7 - Atualizar Vagas"
            println "8 - Atualizar Candidatos"
            println "9 - Atualizar Empresas"
            println "10 - Excluir dados da Empresas"
            println "11 - Excluir dados do Candidato"
            println "12 - Excluir dados da Vaga"
            println "0 - Sair"

            print "\nInforme o número da opção desejada: "
            resp = scanner.next()
            println ""

            if (resp == "12" || resp == "11" || resp == "10" || resp == "9" || resp == "8" || resp == "7" || resp == "6" || resp == "5" || resp == "4" ||resp == "3" || resp == "2" || resp == "1" || resp == "0"){
                return resp
            }
                println "\nOpção inválida!\n"

        }
    }
}
