package org.linketinder.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VacancyTest {

    @Test
    void createVacancyTest() {

        //Given
        Vacancy vacancyTest = new Vacancy("Engenheiro de Dados", "Pleno", "Tarde", "Presencial", "Campinas", "São Paulo",
                "Elabora relatórios gerenciais e prevê tendências de mercado. Responsável pelo desenvolvimento e manutenção de aplicativos web e móveis.",
                [4, 7, 8], 44)

        //When
        boolean vacancyExists = vacancyTest

        //Than
        assertTrue(vacancyExists)
    }
}