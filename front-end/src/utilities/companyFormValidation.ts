import { companyCep, companyCnpj, companyCountry, companyDescription, companyEmail, companyName, companyState } from "./registerCompany";


export function companyFormValidation(){

    const regexEmail = new RegExp('\\S+@\\w+\\.\\w{2,6}(\\.\\w{2})?');
    const regexPhone = new RegExp('\\(?\\d{0,2}\\)?\\s?\\d{4,5}-\\d{4}');
    const regexName = new RegExp('[a-zA-ZÀ-ú\\s\\-]{7,}');
    const regexStateCountry = new RegExp('[a-zA-ZÀ-ú\\s\\-]{3,}');
    const regexCep = new RegExp('\\d{5}-?\\d{3}');
    const regexCnpj = new RegExp('\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?0001-?\\d{2}');


    companyDescription.onchange = function () {  //valida se foi inserido e-mail ou telefone na descrição

        if(companyDescription.value.match(regexEmail)){
            window.alert("Não é permitido inserir e-mail na descrição.");
        }

        if(companyDescription.value.match(regexPhone)){
            window.alert("Não é permitido inserir telefone na descrição.");
        } 
    }

    companyName.onchange = function (){

        if(regexName.test(companyName.value) == false){
            window.alert("Insira o nome completo, são aceitos apenas letras e hífen.");
        }
    }

    companyCnpj.onchange = function (){

        if(regexCnpj.test(companyCnpj.value) == false){
            window.alert("São aceitos apenas números, pontos, hífen e barra.");
        }
    }

    companyEmail.onchange = function (){

        if(regexEmail.test(companyEmail.value) == false){
            window.alert("confira se o e-mail está completo.");
        }
    }

    companyCountry.onchange = function (){
        
        if(regexStateCountry.test(companyCountry.value) == false){
            window.alert("São aceitos apenas letras e hífens.");
        }
    }

    companyState.onchange = function (){
        
        if(regexStateCountry.test(companyState.value) == false){
            window.alert("São aceitos apenas letras e hífens.");
        }
    }

    companyCep.onchange = function (){
        
        if(regexCep.test(companyCep.value) == false){
            window.alert("São aceitos apenas números e hífen. Caso necessário, inclua zero(s) no início do CEP.");
        }
    }
}
