package org.linketinder.service

import groovy.sql.Sql
import org.linketinder.DBDAO.SkillsDAO
import org.linketinder.model.connection.ConnectionFactory
import org.linketinder.model.connection.DBconnection
import org.linketinder.model.connection.Db
import org.linketinder.service.serviceInterfaces.IskillsService


class SkillsService implements IskillsService{

    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase()
    SkillsDAO skillsDao = new SkillsDAO(dbConnection)

    SkillsService() {}


     List<Map> getSkillsCatalog() {

        List<Map> allSkills = skillsDao.getAllSkills()
        return allSkills
    }

    List<Map> getCandidateSkills(Integer id){

        List<Map> candidateSkills = skillsDao.getCandidateSkills(id)
        return  candidateSkills
    }

    List<Map> getVacancySkills(Integer id){

        List<Map> vacancySkills = skillsDao.getVacancySkills(id)
        return  vacancySkills
    }
}