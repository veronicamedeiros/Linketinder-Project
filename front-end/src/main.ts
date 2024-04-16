import { candidateList } from './utilities/entitiesList/candidateList'
import listCandidates from "./utilities/listCandidates"
import {registerCandidate} from "./utilities/registerCandidate"
import { vacanciesList } from './utilities/entitiesList/vacanciesList'
import listVacancies from './utilities/listVacancies'
import { registerCompany } from './utilities/registerCompany'
import { companyFormValidation } from './utilities/regexValidation/companyFormValidation'
import { candidateFormValidation } from './utilities/regexValidation/candidateFormValidation' 


let candidateFormSubmitButton: any = document.getElementById("submitForm");
let companyFormSubmitButton: any = document.getElementById("submitForm2");

let candidatesListDisplayButton: any = document.getElementById("listCandidatesInformations");
let candidatesDisplayField: any = document.getElementById("candidatesInformations");

let jobOpportunityListDisplayButton:any = document.getElementById("listJobOpportunity");
let jobOpportunitiesDisplayField:any = document.getElementById("jobOpportunity");


if(candidatesListDisplayButton){ //listar candidatos

    candidatesListDisplayButton.onclick = function(){
        
        candidatesDisplayField.innerHTML = listCandidates(candidateList);

        candidatesDisplayField.style.display = "block"; //exibe espaço para informação do candidato
    }
}


if(jobOpportunityListDisplayButton){ //listar vagas

    jobOpportunityListDisplayButton.onclick = function(){

        jobOpportunitiesDisplayField.innerHTML = listVacancies(vacanciesList); //chama função de listagem de vagas

        jobOpportunitiesDisplayField.style.display = "block";
    }
}


if(candidateFormSubmitButton){ //cadastrar candidatos

    candidateFormValidation(); //validação formulário

    candidateFormSubmitButton.onclick = function(){
        registerCandidate();
    }
}


if(companyFormSubmitButton){ //cadastrar empresas

    companyFormValidation(); //validação formulário

    companyFormSubmitButton.onclick = function(){

        registerCompany();
    }
}
