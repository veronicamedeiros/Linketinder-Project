import { Company } from "./Company";

export class Vacancy{

    constructor(
        protected _position: string,
        protected _level: string, //estágio, júnior, pleno, sênior
        protected _shift: string, //manhã, tarde, noite
        protected _model: string, //remoto, híbrido, presencial
        protected _jobDescription: string,
        public _companyDescription?: string,
        public _desiredSkills?: Array<string>
    ){}


    get position(): string {
        return this._position;
    }

    set position(value: string) {
        this._position = value;
    }

    get level(): string {
        return this._level;
    }

    set level(value: string) {
        this._level = value;
    }

    get shift(): string {
        return this._shift;
    }

    set shift(value: string) {
        this._shift = value;
    }

    get model(): string {
        return this._model;
    }

    set model(value: string) {
        this._model = value;
    }

    set jobDescription(value: string) {
        this._jobDescription = value;
    }

    get jobDescription(): string {
        return this._jobDescription;
    }

    
}