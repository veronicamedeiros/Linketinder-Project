import { candidateList } from './utilities/candidateList'
import listPerson from "./utilities/listPerson"
import {registerCandidate} from "./utilities/registerCandidate"
import { vacanciesList } from './utilities/vacanciesList'
import listVacancies from './utilities/listVacancies'
import { registerCompany } from './utilities/registerCompany'

let submitForm: any = document.getElementById("submitForm");
let submitFormTwo: any = document.getElementById("submitForm2");

let listCandidatesInformations: any = document.getElementById("listCandidatesInformations");
let candidatesInformations: any = document.getElementById("candidatesInformations");

let listJobOpportunity:any = document.getElementById("listJobOpportunity");
let jobOpportunity:any = document.getElementById("jobOpportunity")


if(listCandidatesInformations){ //listar candidatos

    listCandidatesInformations.onclick = function(){
        
        candidatesInformations.innerHTML = listPerson(candidateList)

        candidatesInformations.style.display = "block" //exibe espaço para informação do candidato
    }
}


if(listJobOpportunity){ //listar vagas

    listJobOpportunity.onclick = function(){

        jobOpportunity.innerHTML = listVacancies(vacanciesList); //chama função de listagem de vagas

        jobOpportunity.style.display = "block";
    }
}


if(submitForm){ //cadastrar candidatos
    
    submitForm.onclick = function(){

        registerCandidate()
    }
}


if(submitFormTwo){ //cadastrar empresas
    
    submitFormTwo.onclick = function(){

        registerCompany()
    }
}
