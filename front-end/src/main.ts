import {CandidatesDisplay} from "./display/CandidatesDisplay"
import {CandidateRegistration} from "./registration/CandidateRegistration"
import {VacanciesDisplay} from './display/VacanciesDisplay'
import {CompanyFormValidation} from './utilities/regexValidation/CompanyFormValidation'
import { CandidateFormValidation } from './utilities/regexValidation/CandidateFormValidation'
import { CompanyRegistration } from './registration/CompanyRegistration'


try{
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

            const registration: CandidateRegistration = new CandidateRegistration()
            
            registration.registerCandidate();
        }
    }


    if(companyFormSubmitButton){

        CompanyFormValidation.execute();

        companyFormSubmitButton.onclick = function(){

            const registration: CompanyRegistration = new CompanyRegistration()
            
            registration.registerCompany();

        }
    }
}
catch(e){
    console.error(e)
}    
