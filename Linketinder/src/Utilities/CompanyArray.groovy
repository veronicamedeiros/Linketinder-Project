package Utilities

import Entities.Company

class CompanyArray {

    static List Company(){
        List companyList =
                [new Company(name: "Tecnologia Star", email: "empresa@tecnologia.com.br", country: "Brasil", cep: "098169-726", state: "Bahia",
                        description: "Nossa empresa lidera o caminho em desenvolvimento de software, fornecendo soluções tecnológicas" +
                                " de ponta para impulsionar o crescimento dos negócios.",
                        cnpj: "15.331.333-0001/09", desiredSkills: ["Ruby", "Java", "Spring", "React", "Angular"]),
                new Company(name: "TI – Soluções", email: "empresa@tecnologia.com.br", country: "Brasil", cep: "028169-726", state: "São Paulo", description: "Especialistas em segurança cibernética: " +
                         "Protegemos o futuro digital das empresas, oferecendo soluções de segurança robustas e personalizadas para enfrentar os desafios da cibersegurança.",
                         cnpj: "15.531.333-0001/08", desiredSkills: ["Wireshark", "Java", "Spring", "React", "OSSEC"]),

                new Company(name: "X -Tecnologia", email: "empresa@tecnologia.com.br", country: "Brasil", cep: "002169-721", state: "Goiás",
                         description: "Conduzindo a inovação tecnológica: Estamos na vanguarda da transformação digital, " +
                                 "desenvolvendo soluções disruptivas que capacitam nossos clientes a se destacarem em um mercado competitivo.",
                         cnpj: "15.331.833-0001/09", desiredSkills: ["PHP", "Java", "React", "OSSEC"]),

                new Company(name: "WBD-Tech", email: "empresa@tecnologia.com.br", country: "Brasil", cep: "096169-723", state: "Rio de Janeiro",
                         description: "Oferecemos suporte técnico especializado e soluções de infraestrutura confiáveis, permitindo " +
                                 "que empresas concentrem-se em seu core business enquanto cuidamos de sua tecnologia.",
                         cnpj: "15.731.333-0001/09", desiredSkills: ["Gradle", "Java", "C++", "Ruby", "OSSEC"]),

                new Company(name: "X -Tecnologia", email: "empresa@tecnologia.com.br", country: "Brasil", cep: "098169-727", state: "Pernambuco",
                         description: "Conduzindo a inovação tecnológica: Estamos na vanguarda da transformação digital, desenvolvendo soluções " +
                                 "disruptivas que capacitam nossos clientes a se destacarem em um mercado competitivo.",
                         cnpj: "15.531.333-0001/09", desiredSkills: ["Snort", "Java", "React", "C#"])
                ]
        companyList
    }
}
