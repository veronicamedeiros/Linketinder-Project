import { $ } from './libraries/jquery.d.js'
import Person from './entities/Person'
import { Candidate } from './entities/Candidate' 
import { Company } from './entities/Company' 
import {states} from './utilities/states'
import {companyList} from './utilities/companyList'
import { candidateList } from './utilities/candidateList'

$('body').append("testando")
console.log('------*-----')


//testando botão

$('#submitForm').on('click', () => { 

    console.log("testando")
    $('body').append("testando")
}) 



console.log('*********')



//função para mostrar a descrição e habilidades de ambos usuários

function showEach<T>(personList: Array<Person>, msg: string = 'Habilidades'){

    personList.forEach((element) => 
        console.log("Descrição: " + element.description + `\n ${msg}: ` + element.skills)
    ) 
}

$('listJobOpportunity').on('click', () => {
    let jobOpportunity = $("jobOpportunity");
    jobOpportunity.append(showEach(companyList, "Habilidades desejadas para um candidato"))
    console.log("teste")
    
});

$('listCandidatesInformations').on('click', () => {
    let candidatesInformations = $('#candidatesInformations')
    candidatesInformations.append(showEach(candidateList))
    
});



/** //Inserir novo candidato
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
**/



/*let mensagemDoEvento: string;

const botao: null | HTMLElement = document.getElementById('submitForm')

if (botao){
    botao.addEventListener('click', () => {
        mensagemDoEvento = 'Oláá mundo!';
        console.log(mensagemDoEvento); 
    });
} 

} */