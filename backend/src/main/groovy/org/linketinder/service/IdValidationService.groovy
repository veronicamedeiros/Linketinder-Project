package org.linketinder.service

import groovy.sql.Sql
import org.linketinder.DBDAO.IdValidationDAO
import org.linketinder.model.connection.ConnectionFactory
import org.linketinder.model.connection.DBconnection
import org.linketinder.model.connection.Db
import org.linketinder.service.serviceInterfaces.IidValidationService


class IdValidationService implements IidValidationService{

    IdValidationService(){}

    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase() as Sql


    boolean validate(Integer id, String tableName){

        try {
            IdValidationDAO validation = new IdValidationDAO(id, tableName, dbConnection)
            boolean validationId = validation.idExists()

            return validationId
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }
}