package Menus

class Menu {

    static String mainMenu(){

        Scanner scanner = new Scanner(System.in)
        String resp

        while(resp !in "12"){
            print("*" * 40 + "\n")
            println " " * 15 + "Menu"
            print("*" * 40 +"\n")
            println "1 - Listar Candidatos"
            println "2 - Listar Empresas"
            println "5 - Listar Vagas"
            println "6 - Listar Habilidades"
            println "3 - Cadastrar Candidatos"
            println "4 - Cadastrar Empresas"
            println "0 - Sair"

            print "\nInforme o número da opção desejada: "
            resp = scanner.next()
            println ""

            if (resp == "6" || resp == "5" || resp == "4" ||resp == "3" || resp == "2" || resp == "1" || resp == "0"){
                return resp
            }
                println "\nOpção inválida!\n"

        }
    }
}
