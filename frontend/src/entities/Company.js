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
exports.Company = void 0;
var Person_1 = require("./Person");
var Company = /** @class */ (function (_super) {
    __extends(Company, _super);
    function Company(_name, _email, _country, _cep, _state, _description, _cnpj, _desiredSkills) {
        var _this = _super.call(this, _name, _email, _country, _cep, _state, _description) || this;
        _this._name = _name;
        _this._email = _email;
        _this._country = _country;
        _this._cep = _cep;
        _this._state = _state;
        _this._description = _description;
        _this._cnpj = _cnpj;
        _this._desiredSkills = _desiredSkills;
        return _this;
    }
    Object.defineProperty(Company.prototype, "cnpj", {
        get: function () {
            return this._cnpj;
        },
        set: function (value) {
            this._cnpj = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Company.prototype, "desiredSkills", {
        get: function () {
            return this._desiredSkills;
        },
        set: function (value) {
            this._desiredSkills = value;
        },
        enumerable: false,
        configurable: true
    });
    return Company;
}(Person_1.default));
exports.Company = Company;
