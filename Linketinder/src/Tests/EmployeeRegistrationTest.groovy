package Tests;

import Entities.Candidate;
import Registration.EmployeeRegistration;
import Utilities.CandidatesArray


class EmployeeRegistrationTest {

    public static addCandidateTest() {

        //Given

        Candidate candidateTest = new Candidate("Anderson da Silva", "silva@gmail.com", "Brasil", "008169-736", "Ceará",
                "Sou movido pela curiosidade e pela busca pelo conhecimento. " +
                        "Tenho uma mente analítica e adoro explorar novos conceitos e tecnologias. ",
                42, "333.331.333-01", ["Python", "Java", "Spring", "Framework", "Angular"])

        List candidateList = CandidatesArray.Candidates()

        //When

        boolean result = EmployeeRegistration.addCandidate(candidateTest, candidateList)

        //Then

        if (result) {
            println "TEST: OK"
        } else {
            println "TEST: ERROR"

        }
    }
}