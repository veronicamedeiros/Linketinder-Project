import { Candidate } from "../entities/Candidate";

//função para mostrar a descrição e habilidades dos candidatos

 export default function listCandidates(candidatesList: Array<Candidate>):string{

    let allCandidates: string | undefined | number = "";
    
    for(let candidate in candidatesList){

        allCandidates += `\n<p><strong>Candidato</strong> ${parseInt(candidate) + 1}</p> 
            \n<p><u>Descrição</u>:  ${candidatesList[candidate].description}</p>
            \n<p><u>Habilidades</u>: ${candidatesList[candidate].skills}</p> <br>`
    }
           
    return allCandidates
} 