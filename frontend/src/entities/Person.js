"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Person = /** @class */ (function () {
    function Person(_name, _email, _country, _cep, _state, _description) {
        this._name = _name;
        this._email = _email;
        this._country = _country;
        this._cep = _cep;
        this._state = _state;
        this._description = _description;
    }
    Object.defineProperty(Person.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (value) {
            this._name = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "email", {
        get: function () {
            return this._email;
        },
        set: function (value) {
            this._email = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "country", {
        get: function () {
            return this._country;
        },
        set: function (value) {
            this._country = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "cep", {
        get: function () {
            return this._cep;
        },
        set: function (value) {
            this._cep = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "state", {
        get: function () {
            return this._state;
        },
        set: function (value) {
            this._state = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "description", {
        get: function () {
            return this._description;
        },
        set: function (value) {
            this._description = value;
        },
        enumerable: false,
        configurable: true
    });
    return Person;
}());
exports.default = Person;
