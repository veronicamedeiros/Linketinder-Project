import { Candidate } from "../entities/Candidate";

export let candidateList: Array<Candidate> = [

    new Candidate("Ana Júlia da Silva", "ana.silva@gmail.com", "Brasil", "098169-726", "São Paulo",
        "Formada em Análise e Desenvolvimento de Sistemas. Sou uma profissional que acredita no poder da colaboração para impulsionar o sucesso. ", ["Python", "Java", "Spring", "Framework", "Angular"], 39, "323.331.333-01"),

    new Candidate("Pedro dos Santos", "pedro@gmail.com", "Brasil", "078169-726", "Bahia",
        "Cursando Banco de Dados. Sou um profissional que acredita no poder da colaboração para impulsionar o sucesso. Tenho habilidades sólidas em minha área de atuação e uma forte ética de trabalho.", ["Python", "Java", "Spring", "Framework", "Angular"], 57, "333.331.333-01"),

    new Candidate("Maria Pereira", "pereira@gmail.com", "Brasil",  "058169-721", "Goiás",
        "Cursando segundo semestre do curso de Gestão da Tecnologia da Informação Formada em Análise e Desenvolvimento de Sistemas. Acredito firmemente no poder da colaboração e da comunicação eficaz. Possuo habilidade em trabalhar em equipe e comunicar ideias de forma clara e concisa.", ["JavaScript", "Java", "Spring", "Framework", "Angular"], 35 , "333.331.333-01"),

    new Candidate("Julho Martins", "martins@gmail.com", "Brasil", "018169-723", "Rio de Janeiro",
        "Estou no terceiro semestre de Banco de Dados. Sou um profissional apaixonado por transformar ideias em realidade.Minha experiência em diversas tecnologias e ferramentas me permite criar soluções digitais impressionantes.", ["Python", "Java", "Spring", "Angular", "Framework"], 22 , "333.331.333-01"),

    new Candidate("Anderson da Silva", "silva@gmail.com", "Brasil", "008169-736", "Ceará",
        "Cursando Engenharia de Software. Sou movido pela curiosidade e pela busca pelo conhecimento." +
        "Tenho uma mente analítica e adoro explorar novos conceitos e tecnologias.", ["Python", "Java", "Spring", "Framework", "Angular"], 42, "333.331.333-01")
]



