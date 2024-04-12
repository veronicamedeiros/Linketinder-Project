package org.linketinder.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateTest {

    @Test
    void createCandidateTest() {
        //Given
        Candidate candidateTest = new Candidate("Ana Júlia", "da Silva", "1991-05-09","ana.silva@gmail.com", "Brasil",
                "098169-726", "São Paulo", "Sou uma profissional que acredita no poder da colaboração para impulsionar o sucesso... ",
                39, "323.331.333-01", ["Java", "Angular"], "123456")

        //When
        boolean candidateExists = candidateTest

        //Than
        assertTrue(candidateExists)
    }
}