package Utilities

import Entities.Company

class CompanyArray {

    static List Company(){
        List companyList =
                [new Company("Tecnologia Star", "empresa@tecnologia.com.br", "Brasil", "098169-726", "Bahia",
                        "Nossa empresa lidera o caminho em desenvolvimento de software, fornecendo soluções tecnológicas de ponta para impulsionar o crescimento dos negócios.",
                       "15.331.333-0001/09", ["Ruby", "Java", "Spring", "React", "Angular"]),

                new Company("TI – Soluções", "empresa@tecnologia.com.br", "Brasil", "028169-726", "São Paulo",
                        "Especialistas em segurança cibernética: Protegemos o futuro digital das empresas, oferecendo soluções de segurança robustas e personalizadas para enfrentar os desafios da cibersegurança.",
                        "15.531.333-0001/08", ["Wireshark", "Java", "Spring", "React", "OSSEC"]),

                new Company("X -Tecnologia", "empresa@tecnologia.com.br", "Brasil", "002169-721", "Goiás",
                        "Conduzindo a inovação tecnológica: Estamos na vanguarda da transformação digital, desenvolvendo soluções disruptivas que capacitam nossos clientes a se destacarem em um mercado competitivo.",
                        "15.331.833-0001/09", ["PHP", "Java", "React", "OSSEC"]),

                new Company("WBD-Tech", "empresa@tecnologia.com.br", "Brasil", "096169-723", "Rio de Janeiro",
                         "Oferecemos suporte técnico especializado e soluções de infraestrutura confiáveis, permitindo que empresas concentrem-se em seu core business enquanto cuidamos de sua tecnologia.",
                        "15.731.333-0001/09", ["Gradle", "Java", "C++", "Ruby", "OSSEC"]),

                new Company("X -Tecnologia", "empresa@tecnologia.com.br", "Brasil", "098169-727", "Pernambuco",
                         "Conduzindo a inovação tecnológica: Estamos na vanguarda da transformação digital, desenvolvendo soluções disruptivas que capacitam nossos clientes a se destacarem em um mercado competitivo.",
                        "15.531.333-0001/09", ["Snort", "Java", "React", "C#"])
                ]

        return companyList
    }
}
