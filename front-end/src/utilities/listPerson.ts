import Person from "../entities/Person";

//função para mostrar a descrição e habilidades dos candidatos

 export default function listPerson(personList: Array<Person>):string{

    let personText: string | undefined | number = "";
    
    for(let person in personList){

        personText += `\n<p><strong>Candidato</strong> ${parseInt(person) + 1}</p> 
            \n<p>Descrição:  ${personList[person].description}</p>
            \n<p>Habilidades: ${personList[person].skills}</p> <br>`
    }
           
    return personText
} 