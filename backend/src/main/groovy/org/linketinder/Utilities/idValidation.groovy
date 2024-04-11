package org.linketinder.Utilities

import org.linketinder.DatabaseConnection.CandidateConnection
import org.linketinder.DatabaseConnection.CompanyConnection
import org.linketinder.DatabaseConnection.VacancyConnection


static validateId(String personType){

    Scanner scanner = new Scanner(System.in)

    while (true){

        print('Informe o número de cadastro: ')

        Integer id = scanner.nextInt()

        boolean idExists


        switch (personType){

            case("candidate"):
                idExists = CandidateConnection.candidateExists(id)
                break
            case("company"):
                idExists = CompanyConnection.companyExists(id)
                break
            case("vacancy"):
                idExists = VacancyConnection.idExists(id)
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
