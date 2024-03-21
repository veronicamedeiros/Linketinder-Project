import Person from "./Person";

export class Company extends Person{
    
    constructor(
        protected _name: string, 
        protected _email: string, 
        protected _country: string, 
        protected _cep: string, 
        protected _state: string, 
        protected _description: string,
        protected _skills: Array<string>,
        protected _cnpj: string
        )
        {
            super(_name, _email, _country, _cep, _state, _description, _skills)
        }

    get cnpj(): string {
        return this._cnpj;
    }

    set cnpj(value: string) {
        this._cnpj = value;
    }

}