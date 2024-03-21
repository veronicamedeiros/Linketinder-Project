import { $ } from './libraries/jquery.d.js'
import Person from './entities/Person'
import { Candidate } from './entities/Candidate' 
import { Company } from './entities/Company' 
import {states} from './utilities/states'
import {companyList} from './utilities/companyList'
import { candidateList } from './utilities/candidateList'

 //Lista de candidatos

console.log('------*-----')




$('#submitForm').on('click', () => { 

    const infoCandidate = new Candidate(
        String($('#personName').val()), 
        String($('#personEmail').val()), 
        String($('#personCountry').val()),
        String($('#personCEP').val()),
        String($('#personState').val()),
        String($('#personDescription').val()),
        Number($('#personAge').val()),
        String($('#personCpf').val()),
        []
    )

    candidateList.push(infoCandidate)

    candidateList.forEach((element) => console.log("FOR EACHH: " + element.name))

}) 






/**if ($('submitTeste')){
    $('submitTeste').on('click', () => {
        candidateList.forEach((element) => console.log("FOR EACHH: " + element.country)) 
    });
}

/*function showEach<T>(lista: Array<T>){
    
    lista.forEach((element) => console.log(element));
}*/

//showEach(states)*/




/*let mensagemForaDoEvento: string;

const botao: null | HTMLElement   = document.getElementById('submitForm')

if (botao){
    botao.addEventListener('click', () => {
        mensagemForaDoEvento = 'Oláá mundo!';
        //console.log(mensagemForaDoEvento); // 'Olá mundo!'
    });
    
} 

const botaoTeste: null | HTMLElement   = document.getElementById('submitTeste')

if (botaoTeste){
    botaoTeste.addEventListener('click', () => {
        // Modificando a variável global dentro do callback do evento de clique
        console.log(mensagemForaDoEvento);
        //console.log(mensagemForaDoEvento); // 'Olá mundo!'
    });
    
} */