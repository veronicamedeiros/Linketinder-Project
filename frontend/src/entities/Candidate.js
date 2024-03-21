"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.Candidate = void 0;
var Person_1 = require("./Person");
var Candidate = /** @class */ (function (_super) {
    __extends(Candidate, _super);
    function Candidate(_name, _email, _country, _cep, _state, _description, _age, _cpf, _skills) {
        var _this = _super.call(this, _name, _email, _country, _cep, _state, _description) || this;
        _this._name = _name;
        _this._email = _email;
        _this._country = _country;
        _this._cep = _cep;
        _this._state = _state;
        _this._description = _description;
        _this._age = _age;
        _this._cpf = _cpf;
        _this._skills = _skills;
        return _this;
    }
    Object.defineProperty(Candidate.prototype, "age", {
        get: function () {
            return this._age;
        },
        set: function (value) {
            this._age = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Candidate.prototype, "cpf", {
        get: function () {
            return this._cpf;
        },
        set: function (value) {
            this._cpf = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Candidate.prototype, "skills", {
        get: function () {
            return this._skills;
        },
        set: function (value) {
            this._skills = value;
        },
        enumerable: false,
        configurable: true
    });
    return Candidate;
}(Person_1.default));
exports.Candidate = Candidate;
