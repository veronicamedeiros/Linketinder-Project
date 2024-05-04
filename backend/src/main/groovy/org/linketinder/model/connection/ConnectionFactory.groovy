package org.linketinder.model.connection

class ConnectionFactory{

    DBconnection instance


     DBconnection instantiateDB(Db typeConnection){

        try {
            switch (typeConnection){
                case Db.POSTGRESQL:

                    if(!instance){
                        this.instance = new PostgreSQLconnection()
                    }
                    return this.instance
                    break
            }
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }
}

