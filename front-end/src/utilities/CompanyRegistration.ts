import { companyList } from "./entitiesList/companyList";
import { Company } from "../entities/Company";

export let companyName: any = (document.getElementById('companyName')as HTMLElement);
export let companyEmail: any = (document.getElementById('companyEmail')as HTMLElement);
export let companyCountry: any = (document.getElementById('companyCountry')as HTMLElement);
export let companyCep: any = (document.getElementById('companyCep')as HTMLElement);
export let companyState: any = (document.getElementById('companyState')as HTMLElement);
export let companyDescription: any = (document.getElementById('companyDescription')as HTMLElement);
export let companyCnpj: any = (document.getElementById('companyCnpj')as HTMLElement);

export class CompanyRegistration{

    
    static registerCompany(){

        try{
            
            const newCompany = new Company(
                companyName.value,
                companyEmail.value,
                companyCountry.value,
                companyCep.value,
                companyState.value,
                companyDescription.value,
                companyCnpj.value
            )

            companyList.push(newCompany);


            //mostra a array de empresas com o novo item no console:
            console.log() //para 'resolver' bug com a array

            companyList.forEach((company) => console.log(company))
        }
        catch(e){
            console.error(e)
        }
    }   
}