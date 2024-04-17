import { candidatesList } from "./entitiesList/candidateList";


export class CandidatesDisplay{

    
    static listCandidates():string{

        let allCandidates: string | undefined | number = "";
        
        for(let candidate in candidatesList){
    
            allCandidates += `\n<p><strong>Candidato</strong> ${parseInt(candidate) + 1}</p> 
                \n<p><u>Descrição</u>:  ${candidatesList[candidate].description}</p>
                \n<p><u>Habilidades</u>: ${candidatesList[candidate].skills}</p> <br>`
        }
               
        return allCandidates
    } 

}


