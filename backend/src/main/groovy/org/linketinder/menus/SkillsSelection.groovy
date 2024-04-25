package org.linketinder.menus

import org.linketinder.traits.SkillsCatalogInvoke


class SkillsSelection implements SkillsCatalogInvoke{

     List<Integer> chooseSkills() {

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

        print("\nInforme o número da habilidade que deseja selecionar: ")

        Scanner scanner = new Scanner(System.in)
        Integer oldSkill = (Integer) scanner.nextInt()

        return oldSkill
    }


    static Integer chooseNewSkill(String msg = "Insira o número da nova habilidade e pressione enter: "){

        print("\n$msg")

        Scanner scanner = new Scanner(System.in)
        Integer newSkill = (Integer) scanner.nextInt()

        return newSkill
    }
}