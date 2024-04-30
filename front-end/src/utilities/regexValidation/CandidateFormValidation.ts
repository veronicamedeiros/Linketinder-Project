import { candidateDescription, candidateName, candidateCpf, candidateEmail, candidateAge, candidateCountry, candidateState, candidateCEP } from "../../registration/CandidateRegistration";
import { RegexCodes } from "./RegexCodes";


export class CandidateFormValidation{
    

    static execute(): void{
        

        candidateDescription.onchange = function () { 
        
            if(candidateDescription.value.match(RegexCodes.getInstance().regexPhone)){

                RegexCodes.getInstance().showValidationError(candidateDescription, "Não é permitido inserir telefone na descrição.");
            }
            else if(candidateDescription.value.match(RegexCodes.getInstance().regexEmail)){

                RegexCodes.getInstance().showValidationError(candidateDescription, "Não é permitido inserir e-mail na descrição.");
            }
            else if(candidateDescription.value.match(RegexCodes.getInstance().regexLinkedin)){

                RegexCodes.getInstance().showValidationError(candidateDescription, "Não é permitido inserir sua conta do LinKedin.");
            }
            else{
                RegexCodes.getInstance().showValidationError(candidateDescription)
            }
        }
        

        candidateName.onchange = function (){
        
            if(RegexCodes.getInstance().regexName.test(candidateName.value) == false){

                RegexCodes.getInstance().showValidationError(candidateName, "Insira o nome completo, são aceitos apenas letras e hífen.");
            }
            else{
                RegexCodes.getInstance().showValidationError(candidateName)
            }
        }
        

        candidateCpf.onchange = function (){
        
            if(RegexCodes.getInstance().regexCpf.test(candidateCpf.value) == false){

                RegexCodes.getInstance().showValidationError(candidateCpf, "Verifique se o CPF está completo. São aceitos apenas números, pontos e hífen.");
            }
            else{
                RegexCodes.getInstance().showValidationError(candidateCpf)
            }
        }
        

        candidateEmail.onchange = function (){
        
            if(RegexCodes.getInstance().regexEmail.test(candidateEmail.value) == false){

                RegexCodes.getInstance().showValidationError(candidateEmail, "Confira se o e-mail está completo.");
            }
            else{
                RegexCodes.getInstance().showValidationError(candidateEmail)
            }
        }

        
        candidateAge.onchange = function (){

            if(RegexCodes.getInstance().regexAge.test(candidateAge.value) == false){

                RegexCodes.getInstance().showValidationError(candidateAge, "A idade aceita apenas números de 16 a 99");
            }
            else{
                RegexCodes.getInstance().showValidationError(candidateAge)
            }
        }

        
        candidateCountry.onchange = function (){

            if(RegexCodes.getInstance().regexStateCountry.test(candidateCountry.value) == false){

                RegexCodes.getInstance().showValidationError(candidateCountry, "São aceitos apenas letras e hífens.");
            }
            else{
                RegexCodes.getInstance().showValidationError(candidateCountry)
            }
        }

        
        candidateState.onchange = function (){
       
            if(RegexCodes.getInstance().regexStateCountry.test(candidateState.value) == false){
                
                RegexCodes.getInstance().showValidationError(candidateState, "São aceitos apenas letras e hífens.");
            }
            else{
                RegexCodes.getInstance().showValidationError(candidateState)
            }
        }

        
        candidateCEP.onchange = function (){
                        
            if(RegexCodes.getInstance().regexCep.test(candidateCEP.value) == false){

                RegexCodes.getInstance().showValidationError(candidateCEP, "São aceitos apenas números e hífen. Caso necessário, inclua zero(s) no início do CEP.");
            }
            else{
                RegexCodes.getInstance().showValidationError(candidateCEP)
            }
        }
    }

}

