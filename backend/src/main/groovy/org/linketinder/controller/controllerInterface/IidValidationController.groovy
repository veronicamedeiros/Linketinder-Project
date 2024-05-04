package org.linketinder.controller.controllerInterface

import org.linketinder.service.IdValidationService


interface IidValidationController {

    boolean validate(Integer id, String tableName)
}