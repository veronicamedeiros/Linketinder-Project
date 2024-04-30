package org.linketinder.DBDAO

import groovy.sql.Sql
import org.linketinder.connection.DBconnection
import org.linketinder.connection.ConnectionFactory
import org.linketinder.entities.Candidate
import org.linketinder.interfaces.Ientities
import org.linketinder.utilities.enums.Db


class CandidateDAO implements Ientities {

    private Integer candidateId
    private Integer chosenOption
    private Integer oldSkill
    private Integer newSkill
    private String updatedInformation
    private Candidate newCandidate


    /*CandidateDAO(DBconnection dbConnection){

        this.dbConnection = dbConnection
    } implantar posterirormente*/


    CandidateDAO(){}

    CandidateDAO(Candidate newCandidate){
        this.newCandidate = newCandidate
    }

    CandidateDAO(Integer candidateId, Integer chosenOption){
        this.candidateId = candidateId
        this.chosenOption = chosenOption
    }

    CandidateDAO(Integer candidateId, Integer chosenOption, String updatedInformation){
        this.candidateId = candidateId
        this.chosenOption = chosenOption
        this.updatedInformation = updatedInformation
    }

    CandidateDAO(Integer candidateId, Integer chosenOption, Integer oldSkill, Integer newSkill){
        this.candidateId = candidateId
        this.chosenOption = chosenOption
        this.oldSkill = oldSkill
        this.newSkill = newSkill
    }

    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase()



    static String[] candidateTableHeader = ['candidate_name', 'candidate_surname', 'candidate_birth', 'candidate_email', 'candidate_country',
                                            'candidate_cep', 'candidate_state', 'candidate_description', 'candidate_age', 'candidate_cpf', 'candidate_password']


    List<Map> list(){

        List<Map> allCandidates = []

        try {
            ArrayList<Integer> ids = []

            dbConnection.eachRow("""
                            SELECT id FROM candidates
                            """){ row ->

                ids.add(row.getInt(1))
            }

            for(identification in ids) {

                ArrayList candidateSkills = []
                String description

                dbConnection.eachRow("""
                        SELECT candidate_skills.id_candidate, skills.skill, candidate_description
                        FROM candidates, candidate_skills, skills
                        WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = CAST (${identification} AS INT)
                        ORDER BY candidate_skills.id_candidate
                        """)
                        { row ->
                            candidateSkills.add(row.getString(2))

                            if (!description){
                                description = row.getString(3)
                            }
                        }
                allCandidates.add([description: description, skills:candidateSkills])
            }
            return allCandidates
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    void register(){

        try {

            List<List<Object>> result = dbConnection.executeInsert("""
                                            INSERT INTO candidates (candidate_name, candidate_surname, candidate_birth, candidate_email, candidate_country,
                                                                    candidate_cep, candidate_state, candidate_description, candidate_age, candidate_cpf, candidate_password)
                                            VALUES ($newCandidate.name, $newCandidate.surname, TO_DATE($newCandidate.birth, 'YYYY-MM-DD'), $newCandidate.email, $newCandidate.country,
                                                    $newCandidate.cep, $newCandidate.state, $newCandidate.description, $newCandidate.age, $newCandidate.cpf, $newCandidate.password)
                                            RETURNING id""")
            Integer generatedId = result[0][0] as Integer

            for (newSkill in newCandidate.skills){

                dbConnection.execute("""
                            INSERT INTO candidate_skills (id_candidate, id_skill)
                            VALUES ($generatedId, $newSkill)
                            """)
            }
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }


    void update(){

        try {

            if (chosenOption < 12) {

                String stringChosenOption = (String) candidateTableHeader[chosenOption - 1]

                dbConnection.execute("""
                            UPDATE candidates 
                            SET $stringChosenOption = '$updatedInformation' 
                            WHERE id = $candidateId;
                            """.toString())
            }

            if (chosenOption == 12){

                dbConnection.execute("""
                            UPDATE candidate_skills SET id_skill = ${newSkill} 
                            WHERE id_skill = ${oldSkill} AND candidate_skills.id_candidate = ${candidateId};
                            """.toString())
            }
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    void delete(){

        try {
            if (chosenOption < 12) {

                String stringChosenOption = (String) candidateTableHeader[chosenOption - 1]

                dbConnection.execute("""
                                UPDATE candidates 
                                SET $stringChosenOption = '' 
                                WHERE id = $candidateId;
                                """.toString())
            }

            if (chosenOption == 12){

                dbConnection.execute("""
                                DELETE FROM candidate_skills 
                                WHERE id_skill = $oldSkill AND candidate_skills.id_candidate = ${candidateId};
                                """.toString())
            }
        }
        catch(Exception e){

            e.printStackTrace()
        }
    }


}