package org.linketinder.controller

import org.linketinder.controller.controllerInterface.IidValidationController
import org.linketinder.service.IdValidationService


class IdValidationController  implements IidValidationController{


    IdValidationService idValidationService = new IdValidationService()

    IdValidationController(){}


    boolean validate(Integer id, String tableName){

        try {
            boolean validationId = idValidationService.validate(id, tableName)

            return validationId
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }
}