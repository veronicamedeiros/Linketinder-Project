package org.linketinder.DBDAO.DAOinterfaces

interface Iskills {

    void updateSkills(Integer candidateId, Integer oldSkill, Integer newSkill)

    void deleteSkills(Integer candidateId, Integer oldSkill)
}