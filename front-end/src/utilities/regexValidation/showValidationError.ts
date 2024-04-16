export function showFieldValidationError(field: HTMLElement, msg?: string): void{

    let formError: any = (document.getElementById('formError')as HTMLElement);

    let errorMsg: Array<String> = []

    const x:string = field.id

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

