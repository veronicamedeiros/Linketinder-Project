import { companyCep, companyCnpj, companyCountry, companyDescription, companyEmail, companyName, companyState } from "../registerCompany";
import { showFieldValidationError } from "./showValidationError";
import { regexPhone, regexEmail, regexName, regexStateCountry, regexCep, regexCnpj} from "./regexCodes";


export function companyFormValidation(){


    companyDescription.onchange = function () {

        if(companyDescription.value.match(regexEmail)){
            showFieldValidationError(companyDescription, "Não é permitido inserir e-mail na descrição.");
        }
        else if(companyDescription.value.match(regexPhone)){
            showFieldValidationError(companyDescription, "Não é permitido inserir telefone na descrição.");
        }
        else{
            showFieldValidationError(companyDescription)
        }
    }

    companyName.onchange = function (){

        if(regexName.test(companyName.value) == false){
            showFieldValidationError(companyName, "Insira o nome completo, são aceitos apenas letras e hífen.");
        }
        else{
            showFieldValidationError(companyName)
        }
    }

    companyCnpj.onchange = function (){

        if(regexCnpj.test(companyCnpj.value) == false){
            showFieldValidationError(companyCnpj, "São aceitos apenas números, pontos, hífen e barra.");
        }
        else{
            showFieldValidationError(companyCnpj)
        }
    }

    companyEmail.onchange = function (){

        if(regexEmail.test(companyEmail.value) == false){
            showFieldValidationError(companyEmail, "confira se o e-mail está completo.");
        }
        else{
            showFieldValidationError(companyEmail)
        }
    }

    companyCountry.onchange = function (){
        
        if(regexStateCountry.test(companyCountry.value) == false){
            showFieldValidationError(companyCountry, "São aceitos apenas letras e hífens.");
        }
        else{
            showFieldValidationError(companyCountry)
        }
    }

    companyState.onchange = function (){
        
        if(regexStateCountry.test(companyState.value) == false){
            showFieldValidationError(companyState, "São aceitos apenas letras e hífens.");
        }
        else{
            showFieldValidationError(companyState)
        }
    }

    companyCep.onchange = function (){
        
        if(regexCep.test(companyCep.value) == false){
            showFieldValidationError(companyCep, "São aceitos apenas números e hífen. Caso necessário, inclua zero(s) no início do CEP.");
        }
        else{
            showFieldValidationError(companyCep)
        }
    }
}
