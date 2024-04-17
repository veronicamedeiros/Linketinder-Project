import { vacanciesList } from "./entitiesList/vacanciesList";


export class VacanciesDisplay{

    
    static listVacancies():string | undefined{

        try{
            let allVacancies: string | undefined | number = "";
            
            
            for(let vacancy in vacanciesList){
        
                allVacancies += 
                    `\n<p><strong>Vaga</strong> ${parseInt(vacancy) + 1}</p><br>
                    \n<p><u>Cargo</u>:  ${vacanciesList[vacancy].position}</p>
                    \n<p><u>Nível</u>: ${vacanciesList[vacancy].level}</p> 
                    \n<p><u>Modelo de trabalho</u>: ${vacanciesList[vacancy].model}</p>
                    \n<p><u>Período</u>: ${vacanciesList[vacancy].shift}</p>
                    \n<p><u>Descrição do Cargo</u>: ${vacanciesList[vacancy].jobDescription}</p>
                    \n<p><u>Habilidades desejadas</u>: ${vacanciesList[vacancy].desiredSKills}</p>
                    \n<p><u>Descrição da Empresa</u>: ${vacanciesList[vacancy].companyDescription}</p><br><br>`
            }
                
            return allVacancies
        }
        catch(e){
            console.error(e)
        }    
    } 
}
