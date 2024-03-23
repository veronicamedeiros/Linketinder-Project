import { companyList } from "./companyList";
import { Company } from "../entities/Company";


export function registerCompany(){
        
    let companyName: any = (document.getElementById('companyName')as HTMLElement);
    let companyEmail: any = (document.getElementById('companyEmail')as HTMLElement);
    let companyCountry: any = (document.getElementById('companyCountry')as HTMLElement);
    let companyCep: any = (document.getElementById('companyCep')as HTMLElement);
    let companyState: any = (document.getElementById('companyState')as HTMLElement);
    let companyDescription: any = (document.getElementById('companyDescription')as HTMLElement);
    let companyCnpj: any = (document.getElementById('companyCnpj')as HTMLElement);
    let skillsList: Array<string> = [];
    
    let aux: Array<string> = [];
    
    for(let pos = 0; pos <= 4; pos++){
        let novoItem:any = (document.getElementsByClassName('desiredSkills')[pos]as HTMLElement)
        aux.push(novoItem.value)
    }

    for(let pos = 0; pos <= 4; pos++){
        skillsList.push(aux[pos]) 
    }
        
    let infoCompany = new Company(
        companyName.value,
        companyEmail.value,
        companyCountry.value,
        companyCep.value,
        companyState.value,
        companyDescription.value,
        skillsList,
        companyCnpj.value
    )

    companyList.push(infoCompany)


    //mostra a array de empresas com o novo item no console:
    console.log() //para 'resolver' bug com a array

    for(let pos = 0; pos <= companyList.length; pos++){
        console.log(companyList[pos]) 
    }
}    