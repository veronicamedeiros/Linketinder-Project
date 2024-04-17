export class RegexCodes{

    constructor(){}
    

    static instance: RegexCodes = new RegexCodes
    
    static getInstance(): RegexCodes{
        return RegexCodes.instance
    }


    get regexEmail(){
        return new RegExp('\\S+@\\w+\\.\\w{2,6}(\\.\\w{2})?')
    }

    get regexCpf(): RegExp{
        return new RegExp('\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}')
    }

    get regexPhone(): RegExp{
        return new RegExp('\\(?\\d{0,2}\\)?\\s?\\d{4,5}-\\d{4}')
    }

    get regexName(): RegExp{
        return new RegExp('[a-zA-ZÀ-ú\\s\\-]{7,}')
    }

    get regexAge(): RegExp{
        return new RegExp('1[6-9]|[2-9][0-9]')
    }

    get regexStateCountry(): RegExp{
        return new RegExp('[a-zA-ZÀ-ú\\s\\-]{3,}')
    }

    get regexCep(): RegExp{
        return new RegExp('\\d{5}-?\\d{3}')
    }

    get regexLinkedin(): RegExp{
        return new RegExp('linkedin.com')
    }
    
    get regexCnpj(): RegExp{
        return new RegExp('\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?0001-?\\d{2}')
    }
    

    showValidationError(field: HTMLElement, msg?: string): void{

        
        try{

            let formError: any = (document.getElementById('formError')as HTMLElement);
        
            let errorMsg: Array<String> = []
        
        
            if (msg && !errorMsg.includes(msg)){
        
                errorMsg.push(msg)
        
                formError.innerHTML = `<p>${msg}</p>`
                formError.style.color = "red"
                field.style.borderColor= "red"
                field.style.borderWidth= "3px"
            }
            else{
                
                formError.innerHTML = ""
                field.style.borderColor= "black"
                field.style.borderWidth= "1px" 
            }
        }
        catch(e){
            console.error(e)
        }    
    }
}

