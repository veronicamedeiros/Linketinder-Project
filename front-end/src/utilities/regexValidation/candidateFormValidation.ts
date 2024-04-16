import { candidateDescription, candidateName, candidateCpf, candidateEmail, candidateAge, candidateCountry, candidateState, candidateCEP } from "../registerCandidate";
import { showFieldValidationError } from "./showValidationError";
import { regexPhone, regexEmail, regexLinkedin, regexName, regexCpf, regexAge, regexStateCountry, regexCep} from "./regexCodes";


export function candidateFormValidation(){


    candidateDescription.onchange = function () {   //valida se foi inserido e-mail, telefone ou link do LinkeDIn na descrição
    
        if(candidateDescription.value.match(regexPhone)){
            showFieldValidationError(candidateDescription, "Não é permitido inserir telefone na descrição.");
        }
        else if(candidateDescription.value.match(regexEmail)){
            showFieldValidationError(candidateDescription, "Não é permitido inserir e-mail na descrição.");
        }
        else if(candidateDescription.value.match(regexLinkedin)){
            showFieldValidationError(candidateDescription, "Não é permitido inserir sua conta do LinKedin.");
        }
        else{
            showFieldValidationError(candidateDescription)
        }
    }
    
    candidateName.onchange = function (){
    
        if(regexName.test(candidateName.value) == false){
            showFieldValidationError(candidateName, "Insira o nome completo, são aceitos apenas letras e hífen.");
        }
        else{
            showFieldValidationError(candidateName)
        }
    }
    
    candidateCpf.onchange = function (){
    
        if(regexCpf.test(candidateCpf.value) == false){
            showFieldValidationError(candidateCpf, "Verifique se o CPF está completo. São aceitos apenas números, pontos e hífen.");
        }
        else{
            showFieldValidationError(candidateCpf)
        }
    }
    
    candidateEmail.onchange = function (){
    
        if(regexEmail.test(candidateEmail.value) == false){
            showFieldValidationError(candidateEmail, "Confira se o e-mail está completo.");
        }
        else{
            showFieldValidationError(candidateEmail)
        }
    }
    
    candidateAge.onchange = function (){
    
        if(regexAge.test(candidateAge.value) == false){
            showFieldValidationError(candidateAge, "A idade aceita apenas números de 16 a 99");
        }
        else{
            showFieldValidationError(candidateAge)
        }
    }
    
    candidateCountry.onchange = function (){
        
        if(regexStateCountry.test(candidateCountry.value) == false){
            showFieldValidationError(candidateCountry, "São aceitos apenas letras e hífens.");
        }
        else{
            showFieldValidationError(candidateCountry)
        }
    }
    
    candidateState.onchange = function (){
        
        if(regexStateCountry.test(candidateState.value) == false){
            
            showFieldValidationError(candidateState, "São aceitos apenas letras e hífens.");
        }
        else{
            showFieldValidationError(candidateState)
        }
    }
    
    candidateCEP.onchange = function (){
        
        if(regexCep.test(candidateCEP.value) == false){
            showFieldValidationError(candidateCEP, "São aceitos apenas números e hífen. Caso necessário, inclua zero(s) no início do CEP.");
        }
        else{
            showFieldValidationError(candidateCEP)
        }
    }
}

