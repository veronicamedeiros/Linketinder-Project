package org.linketinder.utilities

import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.DBDAO.CompanyDAO
import org.linketinder.DBDAO.VacancyDAO


static validateId(String personType){

    Scanner scanner = new Scanner(System.in)

    while (true){

        print('Informe o número de cadastro: ')

        Integer id = scanner.nextInt()

        boolean idExists


        switch (personType){

            case("candidate"):
                idExists = CandidateDAO.candidateExists(id)
                break
            case("company"):
                idExists = CompanyDAO.companyExists(id)
                break
            case("vacancy"):
                idExists = VacancyDAO.vacancyExists(id)
                break
        }


        if (idExists){

            return id
        }
        else{
            println("\nCadastro não encontrada.\n")
        }
    }
}
