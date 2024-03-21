
import Person from './entities/Person'
import { Candidate } from './entities/Candidate' 
import { Company } from './entities/Company' 
import {states} from './utilities/states'
import {companyList} from './utilities/companyList'
import { candidateList } from './utilities/candidateList'
import listPerson from "./utilities/listPerson"

let submitForm: HTMLElement | null = document.getElementById("submitForm");

let listCandidatesInformations: any = document.getElementById("listCandidatesInformations");

let candidatesInformations: any = document.getElementById("candidatesInformations")


if(listCandidatesInformations){ //listar candidatos

    listCandidatesInformations.onclick = function(){
        
        candidatesInformations.innerHTML = listPerson(candidateList)

        candidatesInformations.style.display = "block" //exibe espaço para informação do candidato
    }
} 


let personName: string | null | undefined | HTMLElement = document.getElementById('personName');
let personEmail: string | null | undefined | HTMLElement = document.getElementById('personEmail');
let personCountry: string | null | undefined | HTMLElement = document.getElementById('personCountry');
let personCEP: string | null | undefined | HTMLElement = document.getElementById('personCEP');
let personState: string | null | undefined | HTMLElement = document.getElementById('personState');
let personDescription: string | null | undefined | HTMLElement = document.getElementById('personDescription');
let personAge: number | null | undefined | HTMLElement = document.getElementById('personAge');
let personCpf: string | null | undefined | HTMLElement = document.getElementById('personCpf');
let skills: Array<Candidate>;




/**if(submitForm){
    submitForm.onclick = function(){

        const infoCandidate = new Candidate(
            String(personName.innerHTML),
            personEmail.?innerHTML,
            personCountry.innerHTML,
            personCEP.innerHTML,
            personState.innerHTML,
            personDescription.innerHTML,
            personAge.innerHTML,
            personCpf.tex,
            skills
            
    
        )
    }
}*/

/** //Inserir novo candidato
 $('#submitForm').on('click', () => { 

    const infoCandidate = new Candidate(
        String($('#personName').val()), 
        String($('#personEmail').val()), 
        String($('#personCountry').val()),
        String($('#personCEP').val()),
        String($('#personState').val()),
        String($('#personDescription').val()),
        Number($('#personAge').val()),
        String($('#personCpf').val()),
        []
    )

    candidateList.push(infoCandidate)

    candidateList.forEach((element) => console.log("FOR EACHH: " + element.name))

}) 
**/



/*
//listar empresas

let listJobOpportunity: HTMLElement | null = document.getElementById("listJobOpportunity");

if(listJobOpportunity){ 
    listJobOpportunity.onclick = function(){
        let jobOpportunity: any | HTMLElement | null | string = document.getElementById("jobOpportunity")

        jobOpportunity.innerHTML = listPerson(companyList)
         
    }
}*/