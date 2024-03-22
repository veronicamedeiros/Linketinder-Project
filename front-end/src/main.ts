
//criar classe Vaga, lista de vagas com algumas vagas cadastradas

import Person from './entities/Person'
import { Candidate } from './entities/Candidate' 
import { Company } from './entities/Company' 
import {states} from './utilities/states'
import {companyList} from './utilities/companyList'
import { candidateList } from './utilities/candidateList'
import listPerson from "./utilities/listPerson"
import {registerCandidate} from "./utilities/registerCandidate"
import { Vacancy } from './entities/Vacancy'
import { vacanciesList } from './utilities/vacanciesList'
import listVacancies from './utilities/listVacancies'

let submitForm: any = document.getElementById("submitForm");
let listCandidatesInformations: any = document.getElementById("listCandidatesInformations");
let candidatesInformations: any = document.getElementById("candidatesInformations");


if(listCandidatesInformations){ //listar candidatos

    listCandidatesInformations.onclick = function(){
        
        candidatesInformations.innerHTML = listPerson(candidateList)

        candidatesInformations.style.display = "block" //exibe espaço para informação do candidato
    }
} 


if(submitForm){ //chama função para cadastrar candidatos
    
    submitForm.onclick = function(){

        registerCandidate()
    }
}


//listar vagas
let listJobOpportunity:any = document.getElementById("listJobOpportunity");
let jobOpportunity:any = document.getElementById("jobOpportunity")

if(listJobOpportunity){ 

    listJobOpportunity.onclick = function(){

        jobOpportunity.innerHTML = listVacancies(vacanciesList) //chama função de listagem de vagas

    }
}


