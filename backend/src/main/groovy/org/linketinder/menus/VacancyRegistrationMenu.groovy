package org.linketinder.menus

import org.linketinder.entities.Vacancy

class VacancyRegistrationMenu {

     Vacancy registerVacancyInformations(){

        List<Integer> desiredSkills = new ArrayList<>()
        Scanner scanner = new Scanner(System.in)


        try {
            print "Informe o número de cadastro da empresa: "
            int  idCompany = scanner.nextInt()

            String fixBug = scanner.nextLine()

            print "Informe o nome do cargo: "
            String position = scanner.nextLine()

            print "Informe o nível do cargo: "
            String level = scanner.nextLine()

            print "Informe o turno de trabalho (manhã, tarde, noite): "
            String shift = scanner.nextLine()

            print "Informe o modelo de trabalho (presencial, remoto, híbrido): "
            String model = scanner.nextLine()

            print "Informe a Cidade: "
            String city = scanner.nextLine()

            print "Informe o Estado: "
            String state = scanner.nextLine()

            print "Descreva o cargo: "
            String jobDescription = scanner.nextLine()

            SkillsSelection selection = new SkillsSelection()
            desiredSkills = selection.chooseSkills()

            Vacancy newVacancy = new Vacancy(position, level, shift, model, city, state, jobDescription, desiredSkills, idCompany)

            return newVacancy
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }
}
