
import { companyCep, companyCnpj, companyCountry, companyDescription, companyEmail, companyName, companyState } from "../CompanyRegistration";
import { RegexCodes } from "./RegexCodes";



export class CompanyFormValidation{


    static execute():void{

        companyDescription.onchange = function () {

            if(companyDescription.value.match(RegexCodes.getInstance().regexEmail)){

                RegexCodes.getInstance().showValidationError(companyDescription, "Não é permitido inserir e-mail na descrição.");
            }
            else if(companyDescription.value.match(RegexCodes.getInstance().regexPhone)){

                RegexCodes.getInstance().showValidationError(companyDescription, "Não é permitido inserir telefone na descrição.");
            }
            else{
                RegexCodes.getInstance().showValidationError(companyDescription)
            }
        }


        companyName.onchange = function (){

            if(RegexCodes.getInstance().regexName.test(companyName.value) == false){

                RegexCodes.getInstance().showValidationError(companyName, "Insira o nome completo, são aceitos apenas letras e hífen.");
            }
            else{
                RegexCodes.getInstance().showValidationError(companyName)
            }
        }


        companyCnpj.onchange = function (){

            if(RegexCodes.getInstance().regexCnpj.test(companyCnpj.value) == false){

                RegexCodes.getInstance().showValidationError(companyCnpj, "Verifique se o CNPJ está completo. São aceitos apenas números, pontos, hífen e barra.");
            }
            else{
                RegexCodes.getInstance().showValidationError(companyCnpj)
            }
        }


        companyEmail.onchange = function (){

            if(RegexCodes.getInstance().regexEmail.test(companyEmail.value) == false){

                RegexCodes.getInstance().showValidationError(companyEmail, "Confira se o e-mail está completo.");
            }
            else{
                RegexCodes.getInstance().showValidationError(companyEmail)
            }
        }


        companyCountry.onchange = function (){
            
            if(RegexCodes.getInstance().regexStateCountry.test(companyCountry.value) == false){

                RegexCodes.getInstance().showValidationError(companyCountry, "São aceitos apenas letras e hífens.");
            }
            else{
                RegexCodes.getInstance().showValidationError(companyCountry)
            }
        }


        companyState.onchange = function (){
            
            if(RegexCodes.getInstance().regexStateCountry.test(companyState.value) == false){

                RegexCodes.getInstance().showValidationError(companyState, "São aceitos apenas letras e hífens.");
            }
            else{
                RegexCodes.getInstance().showValidationError(companyState)
            }
        }


        companyCep.onchange = function (){
            
            if(RegexCodes.getInstance().regexCep.test(companyCep.value) == false){

                RegexCodes.getInstance().showValidationError(companyCep, "São aceitos apenas números e hífen. Caso necessário, inclua zero(s) no início do CEP.");
            }
            else{
                RegexCodes.getInstance().showValidationError(companyCep)
            }
        }
    }
}
