import Person from "../entities/Person";
import { Vacancy } from "../entities/Vacancy";

//função para mostrar a descrição e habilidades dos candidatos

 export default function listVacancies(vacanciesList: Array<Vacancy>):string{

    let personText: string | undefined | number = "";
    
    for(let person in vacanciesList){

        personText += `\n<p><strong>Vaga</strong> ${parseInt(person) + 1}</p><br>
            \n<p><u>Cargo</u>:  ${vacanciesList[person].position}</p>
            \n<p><u>Nível</u>: ${vacanciesList[person].level}</p> 
            \n<p><u>Modelo de trabalho</u>: ${vacanciesList[person].model}</p>
            \n<p><u>Período</u>: ${vacanciesList[person].shift}</p>
            \n<p><u>Descrição do Cargo</u>: ${vacanciesList[person].jobDescription}</p>
            \n<p><u>Habilidades desejadas</u>: ${vacanciesList[person].desiredSKills}</p>
            \n<p><u>Descrição da Empresa</u>: ${vacanciesList[person].companyDescription}</p><br><br>`
    }
           
    return personText
} 