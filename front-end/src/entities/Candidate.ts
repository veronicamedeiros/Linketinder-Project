import Person from "./Person";

export class Candidate extends Person{
    
    constructor(
        protected _name: string, 
        protected _email: string, 
        protected _country: string, 
        protected _cep: string, 
        protected _state: string, 
        protected _description: string,
        protected _age: number,
        protected _cpf: string,
        protected _skills: Array<string>,
        ){ 
            super(_name, _email, _country, _cep, _state, _description)
        }    

    get age(): number {
        return this._age;
    }

    set age(value: number) {
        this._age = value;
    }

    get cpf(): string {
        return this._cpf;
    }

    set cpf(value: string) {
        this._cpf = value;
    }
    
    get skills(): Array<string> {
        return this._skills;
    }

    set skills(value: Array<string>) {
        this._skills = value;
    }
}
 