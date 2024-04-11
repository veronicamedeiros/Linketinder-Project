package org.linketinder.Menus

import org.linketinder.DatabaseConnection.SkillsConnection


static List chooseSkills(){

    Integer skill
    List<Integer> skills = new ArrayList<>()

    while (skill != 0){

        print("\n" +"*" * 40 + "\n" + " " * 15 + "HABILIDADES" + "\n" + "*" * 40 +"\n")

        println "\nDigite o número referente à habilidade desejada e pressione enter."
        println "Caso não deseje informar mais nenhuma, pressione 0.\n"
        skill = chooseNewSkill("Habilidade: ")


        if(skill < 0 | skill > 21) {
            println("Opção inválida.")
        }
        else{
            if (skill == 0) {
                return skills
            }
            else{
                skills.add(skill)
            }
        }

    }
}


static Integer chooseOldSKill(){

    Scanner scanner = new Scanner(System.in)

    print("\nInforme o número da habilidade que deseja selecionar: ")
    Integer oldSkill = (Integer) scanner.nextInt()

    return oldSkill
}


static chooseNewSkill(String msg = "Insira o número da nova habilidade e pressione enter: "){

    SkillsConnection.listAllSkills()

    print("\n $msg")

    Scanner scanner = new Scanner(System.in)
    Integer newSkill = (Integer) scanner.nextInt()

    return newSkill
}