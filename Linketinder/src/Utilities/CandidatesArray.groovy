package Utilities

import Entities.Candidate

class CandidatesArray {

    static List Candidates(){
        List Array = [
                new Candidate(name: "Ana Júlia da Silva", email: "ana.silva@gmail.com", country: "Brasil", cep: "098169-726", state: "São Paulo",
                        description: "Sou uma profissional que acredita no poder da colaboração para impulsionar o sucesso. " +
                                "Possuo habilidades sólidas em minha área de atuação e uma forte ética de trabalho.",
                        cpf: "323.331.333-01", age: 39 , skills: ["Python", "Java", "Spring", "Framework", "Angular"]),
                new Candidate(name: "Pedro dos Santos", email: "pedro@gmail.com", country: "Brasil", cep: "078169-726", state: "Bahia",
                        description: "Sou um profissional que acredita no poder da colaboração para impulsionar o sucesso. " +
                                "Tenho habilidades sólidas em minha área de atuação e uma forte ética de trabalho.",
                        cpf: "333.331.333-01", age: 57 ,skills: ["Python", "Java", "Spring", "Framework", "Angular"]),
                new Candidate(name: "Maria Pereira", email: "pereira@gmail.com", country: "Brasil",  cep: "058169-721", state: "Goiás",
                        description: "Acredito firmemente no poder da colaboração e da comunicação eficaz. " +
                                "Possuo habilidade em trabalhar em equipe e comunicar ideias de forma clara e concisa.",
                        cpf: "333.331.333-01", age: 35 , skills: ["JavaScript", "Java", "Spring", "Framework", "Angular"]),
                new Candidate(name: "Julho Martins", email: "martins@gmail.com", country: "Brasil", cep: "018169-723", state: "Rio de Janeiro",
                        description: "Sou um profissional apaixonado por transformar ideias em realidade. " +
                                "Minha experiência em diversas tecnologias e ferramentas me permite criar soluções digitais impressionantes.",
                        cpf: "333.331.333-01", age: 22 , skills: ["Python", "Java", "Spring", "Framework", "Angular"]),
                new Candidate(name: "Anderson da Silva", email: "silva@gmail.com", country: "Brasil", cep: "008169-736", state: "Ceará",
                        description: "Sou movido pela curiosidade e pela busca pelo conhecimento. " +
                                "Tenho uma mente analítica e adoro explorar novos conceitos e tecnologias. ",
                        cpf: "333.331.333-01", age: 42 , skills: ["Python", "Java", "Spring", "Framework", "Angular"])
        ]
        return Array
    }



}
