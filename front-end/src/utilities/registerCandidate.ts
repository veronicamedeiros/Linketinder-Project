import { Candidate } from "../entities/Candidate";
import { candidateList } from "./entitiesList/candidateList";

export let candidateName: any = (document.getElementById('candidateName')as HTMLElement);
export let candidateEmail: any = (document.getElementById('candidateEmail')as HTMLElement);
export let candidateCountry: any = (document.getElementById('candidateCountry')as HTMLElement);
export let candidateCEP: any = (document.getElementById('candidateCEP')as HTMLElement);
export let candidateState: any = (document.getElementById('candidateState')as HTMLElement);
export let candidateDescription: any = (document.getElementById('candidateDescription')as HTMLElement);
export let candidateAge: any = (document.getElementById('candidateAge')as HTMLElement);
export let candidateCpf: any = (document.getElementById('candidateCpf')as HTMLElement);
    

export function registerCandidate(){
    
    let skillsList: Array<string> = [];
    
    for(let pos = 0; pos <= 4; pos++){
        let newSkill:any = (document.getElementsByClassName('candidateSkills')[pos]as HTMLElement);
        skillsList.push(newSkill.value)
    }

        
    const newCandidate = new Candidate(
        candidateName.value,
        candidateEmail.value,
        candidateCountry.value,
        candidateCEP.value,
        candidateState.value,
        candidateDescription.value,
        candidateAge.value,
        candidateCpf.value,
        skillsList
    )
      
    candidateList.push(newCandidate);

    
    //mostra a array de candidatos com o novo item no console:
    console.log(); //para 'resolver' bug com a array

    candidateList.forEach((candidate) => console.log(candidate))
}