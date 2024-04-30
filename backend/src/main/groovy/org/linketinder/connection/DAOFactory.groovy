package org.linketinder.connection

import org.linketinder.utilities.enums.Db


class DAOFactory {


    static DAO connectDataBase(Db conection){

        try {
            switch (conection){
                case Db.POSTGRESQL:
                    return new PostgreSQL()
            }
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }
}

