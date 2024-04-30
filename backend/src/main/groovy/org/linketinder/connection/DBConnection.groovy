package org.linketinder.connection

import groovy.sql.Sql
import org.linketinder.utilities.enums.Db

abstract class DBConnection {

    protected DAO dao = new DAOFactory().connectDataBase(Db.POSTGRESQL)
    protected Sql database = dao.connect() as Sql
}
