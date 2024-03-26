import { personDescription, personName, personCpf, personEmail, personAge, personCountry, personState, personCEP } from "./registerCandidate";

const regexEmail = new RegExp('\\S+@\\w+\\.\\w{2,6}(\\.\\w{2})?');
const regexCpf = new RegExp('\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}');
const regexPhone = new RegExp('\\(?\\d{0,2}\\)?\\s?\\d{4,5}-\\d{4}');
const regexName = new RegExp('[a-zA-ZÀ-ú\\s\\-]{7,}');
const regexAge = new RegExp('1[6-9]|[2-9][0-9]');
const regexStateCountry = new RegExp('[a-zA-ZÀ-ú\\s\\-]{3,}');
const regexCep = new RegExp('\\d{5}-?\\d{3}');
const regexLinkedin = new RegExp('linkedin.com')


export function candidateFormValidation(){
    
    personDescription.onchange = function () {   //valida se foi inserido e-mail, telefone ou link do LinkeDIn na descrição

        if(personDescription.value.match(regexEmail)){
            window.alert("Não é permitido inserir e-mail na descrição.");
        }
    
        if(personDescription.value.match(regexPhone)){
            window.alert("Não é permitido inserir telefone na descrição.");
        }

        if(personDescription.value.match(regexLinkedin)){
            window.alert("Não é permitido inserir sua conta do LinKedin.");
        }
    }
    
    personName.onchange = function (){
    
        if(regexName.test(personName.value) == false){
            window.alert("Insira o nome completo, são aceitos apenas letras e hífen.");
        }
    }
    
    personCpf.onchange = function (){
    
        if(regexCpf.test(personCpf.value) == false){
            window.alert("São aceitos apenas números, pontos e hífen.");
        }
    }
    
    personEmail.onchange = function (){
    
        if(regexEmail.test(personEmail.value) == false){
            window.alert("Confira se o e-mail está completo.");
        }
    }
    
    personAge.onchange = function (){
    
        if(regexAge.test(personAge.value) == false){
            window.alert("São aceitos apenas números de 16 a 9.9");
        }
    }
    
    personCountry.onchange = function (){
        
        if(regexStateCountry.test(personCountry.value) == false){
            window.alert("São aceitos apenas letras e hífens.");
        }
    }
    
    personState.onchange = function (){
        
        if(regexStateCountry.test(personState.value) == false){
            window.alert("São aceitos apenas letras e hífens.");
        }
    }
    
    personCEP.onchange = function (){
        
        if(regexCep.test(personCEP.value) == false){
            window.alert("São aceitos apenas números e hífen. Caso necessário, inclua zero(s) no início do CEP.");
        }
    }
}

