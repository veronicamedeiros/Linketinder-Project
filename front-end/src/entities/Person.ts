export default class Person{
    
    constructor(
        protected _name: string, 
        protected _email: string, 
        protected _country: string, 
        protected _cep: string, 
        protected _state: string, 
        protected _description: string
        ) {
        }
    
    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }
    
    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }
    
    get country(): string {
        return this._country;
    }

    set country(value: string) {
        this._country = value;
    }

    get cep(): string {
        return this._cep;
    }

    set cep(value: string) {
        this._cep = value;
    }
    get state(): string {
        return this._state;
    }

    set state(value: string) {
        this._state = value;
    }
    
    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }
}
