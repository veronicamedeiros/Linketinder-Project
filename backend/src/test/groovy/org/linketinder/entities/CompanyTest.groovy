package org.linketinder.entities;

import org.junit.jupiter.api.Test
import org.linketinder.model.entities.Company;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void createCompanyTest() {
        //Given
        Company companyTest = new Company("Tecnologia X", "x@tech.com", "Brasil",
                                        "09824-560", "Bahia", "Nossa empresa é...",
                                        "15.618.143/0001-09", "123456")

        //When
        boolean companyExists = companyTest

        //Than
        assertTrue(companyExists)
    }
}