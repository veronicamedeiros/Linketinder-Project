package org.linketinder.interfaces

import groovy.sql.Sql
import org.linketinder.DBDAO.DAO

trait Idao {

    DAO database = new DAO(
        'jdbc:postgresql://localhost:5432/linketinder_banco',
        'postgres',
        'postgres',
        'org.postgresql.Driver'
    )
    Sql sql = connectDataBase()
}