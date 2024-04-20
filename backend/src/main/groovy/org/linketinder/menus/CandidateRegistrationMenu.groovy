package org.linketinder.menus


import org.linketinder.entities.Candidate

class CandidateRegistrationMenu{


    Candidate registerCandidateInformations(){

        List<Integer> skills = new ArrayList<>()
        Scanner scanner = new Scanner(System.in)


        try {
            print "Informe seu primeiro nome: "
            String name = scanner.nextLine()

            print "Informe seu sobrenome: "
            String surname = scanner.nextLine()

            print "Informe sua data de nascimento (\"yyyy-MM-dd\"): "
            String birth = scanner.next()
            String fixBug = scanner.nextLine()

            print "Crie uma senha de pelo menos 6 dígitos: "
            String password = scanner.nextLine()

            print "Informe sua idade: "
            Integer age = scanner.nextInt()

            print "Informe seu CPF: "
            String fixBug2 = scanner.nextLine()
            String cpf = scanner.nextLine()

            print "Informe seu melhor e-mail: "
            String email = scanner.nextLine()

            print "Informe o País: "
            String country = scanner.nextLine()

            print "Informe o Estado: "
            String state = scanner.nextLine()

            print "Informe o CEP: "
            String cep = scanner.nextLine()

            print "Escreva uma breve descrição sobre seu perfil profissional: "
            String description = scanner.nextLine()

            SkillsSelection selection = new SkillsSelection()

            skills = selection.chooseSkills()

            Candidate newCandidate = new Candidate(name, surname, birth, email, country, cep, state, description, age, cpf, skills, password)

            return newCandidate
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }
}