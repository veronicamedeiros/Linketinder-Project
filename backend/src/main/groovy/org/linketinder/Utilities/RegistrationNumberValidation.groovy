package org.linketinder.Utilities

import org.linketinder.DatabaseConnection.CandidateConnection
import org.linketinder.DatabaseConnection.CompanyConnection
import org.linketinder.DatabaseConnection.VacancyConnection
import static org.linketinder.Utilities.RegistrationNumberValidation.registrationNumber


static registrationNumber(String typeRegistration){

    Scanner scanner = new Scanner(System.in)

    while (true){

        print('Informe o número de cadastro: ')

        Integer idRegistration = scanner.nextInt()

        boolean registrationExists


        switch (typeRegistration){

            case("candidate"):
                registrationExists = CandidateConnection.candidateExists(idRegistration)
                break
            case("company"):
                registrationExists = CompanyConnection.companyExists(idRegistration)
                break
            case("vacancy"):
                registrationExists = VacancyConnection.numberVacancyExists(idRegistration)
                break
        }


        if (registrationExists){

            return idRegistration
        }
        else{
            println("\nCadastro não encontrada.\n")
        }
    }
}
