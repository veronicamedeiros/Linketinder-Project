import { Candidate } from "../entities/Candidate";
import { candidateList } from "./candidateList";

export let personName: any = (document.getElementById('personName')as HTMLElement);
export let personEmail: any = (document.getElementById('personEmail')as HTMLElement);
export let personCountry: any = (document.getElementById('personCountry')as HTMLElement);
export let personCEP: any = (document.getElementById('personCEP')as HTMLElement);
export let personState: any = (document.getElementById('personState')as HTMLElement);
export let personDescription: any = (document.getElementById('personDescription')as HTMLElement);
export let personAge: any = (document.getElementById('personAge')as HTMLElement);
export let personCpf: any = (document.getElementById('personCpf')as HTMLElement);
    

export function registerCandidate(){
    
    let skillsList: Array<string> = [];
    let aux: Array<string> = [];
    
    for(let pos = 0; pos <= 4; pos++){
        let novoItem:any = (document.getElementsByClassName('skillsPerson')[pos]as HTMLElement);
        aux.push(novoItem.value)
    }

    for(let pos = 0; pos <= 4; pos++){
        skillsList.push(aux[pos]); 
    }
        
    let infoCandidate = new Candidate(
        personName.value,
        personEmail.value,
        personCountry.value,
        personCEP.value,
        personState.value,
        personDescription.value,
        skillsList,
        personAge.value,
        personCpf.value,
    )
      
    candidateList.push(infoCandidate);

    
    //mostra a array de candidatos com o novo item no console:
    console.log(); //para 'resolver' bug com a array

    for(let pos = 0; pos <= candidateList.length; pos++){
        console.log(candidateList[pos]); 
        }
}