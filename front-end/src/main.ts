import {CandidatesDisplay} from "./utilities/CandidatesDisplay"
import {CandidateRegistration} from "./utilities/CandidateRegistration"
import {VacanciesDisplay} from './utilities/VacanciesDisplay'
import {CompanyFormValidation} from './utilities/regexValidation/CompanyFormValidation'
import { CandidateFormValidation } from './utilities/regexValidation/CandidateFormValidation'
import { CompanyRegistration } from './utilities/CompanyRegistration'


let candidateFormSubmitButton: any = document.getElementById("submitForm");
let companyFormSubmitButton: any = document.getElementById("submitForm2");

let candidatesListDisplayButton: any = document.getElementById("listCandidatesInformations");
let candidatesDisplayField: any = document.getElementById("candidatesInformations");

let jobOpportunityListDisplayButton:any = document.getElementById("listJobOpportunity");
let jobOpportunitiesDisplayField:any = document.getElementById("jobOpportunity");


if(candidatesListDisplayButton){

    candidatesListDisplayButton.onclick = function(){
        
        candidatesDisplayField.innerHTML = CandidatesDisplay.listCandidates();

        candidatesDisplayField.style.display = "block";
    }
}


if(jobOpportunityListDisplayButton){

    jobOpportunityListDisplayButton.onclick = function(){

        jobOpportunitiesDisplayField.innerHTML = VacanciesDisplay.listVacancies();

        jobOpportunitiesDisplayField.style.display = "block";
    }
}


if(candidateFormSubmitButton){ 

    CandidateFormValidation.execute();

    candidateFormSubmitButton.onclick = function(){
        
        CandidateRegistration.registerCandidate();
    }
}


if(companyFormSubmitButton){

    CompanyFormValidation.execute();

    companyFormSubmitButton.onclick = function(){

        CompanyRegistration.registerCompany();
    }
}
