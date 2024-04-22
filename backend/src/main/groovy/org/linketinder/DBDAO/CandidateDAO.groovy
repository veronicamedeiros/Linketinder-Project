package org.linketinder.DBDAO

import org.linketinder.entities.Candidate
import org.linketinder.interfaces.Ientities


class CandidateDAO implements Ientities{

    Integer candidateId
    Integer chosenOption
    Integer oldSkill
    Integer newSkill
    String updatedInformation
    Candidate newCandidate


    CandidateDAO(newCandidate){
        this.newCandidate = newCandidate
    }

    CandidateDAO(candidateId, chosenOption){
        this.candidateId = candidateId
        this.chosenOption = chosenOption
    }

    CandidateDAO(candidateId, chosenOption, updatedInformation){
        this.candidateId = candidateId
        this.chosenOption = chosenOption
        this.updatedInformation = updatedInformation
    }

    CandidateDAO(candidateId, chosenOption, oldSkill, newSkill){
        this.candidateId = candidateId
        this.chosenOption = chosenOption
        this.oldSkill = oldSkill
        this.newSkill = newSkill
    }


    static Object sql = DAO.connectDataBase()

    static String[] candidateTableHeader = ['candidate_name', 'candidate_surname', 'candidate_birth', 'candidate_email', 'candidate_country',
                                            'candidate_cep', 'candidate_state', 'candidate_description', 'candidate_age', 'candidate_cpf', 'candidate_password']


    List<Map> list(){

        List<Map> allCandidates = []

        try {
            ArrayList<Integer> ids = []

            sql.eachRow("""
                            SELECT candidate_skills.id_candidate
                            FROM candidate_skills
                            Group BY id_candidate
                            ORDER BY id_candidate
                            """){ row ->

                ids.add(row.getInt(1))
            }

            for(identification in ids) {

                ArrayList candidateSkills = []
                String description

                sql.eachRow("""
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

            List<List<Object>> result = sql.executeInsert("""
                                            INSERT INTO candidates (candidate_name, candidate_surname, candidate_birth, candidate_email, candidate_country,
                                                                    candidate_cep, candidate_state, candidate_description, candidate_age, candidate_cpf, candidate_password)
                                            VALUES ($newCandidate.name, $newCandidate.surname, TO_DATE($newCandidate.birth, 'YYYY-MM-DD'), $newCandidate.email, $newCandidate.country,
                                                    $newCandidate.cep, $newCandidate.state, $newCandidate.description, $newCandidate.age, $newCandidate.cpf, $newCandidate.password)
                                            RETURNING id""")
            Integer generatedId = result[0][0] as Integer

            for (newSkill in newCandidate.skills){

                sql.execute("""
                            INSERT INTO candidate_skills (id_candidate, id_skill)
                            VALUES ($generatedId, $newSkill)
                            """)
            }
        }
        catch (Exception e){

            e.printStackTrace()
        }
        finally {

            sql.close()
        }
    }


    void update(){

        try {

            if (chosenOption < 12) {

                String stringChosenOption = (String) candidateTableHeader[chosenOption - 1]

                sql.execute("""
                            UPDATE candidates 
                            SET $stringChosenOption = '$updatedInformation' 
                            WHERE id = $candidateId;
                            """.toString())
            }

            if (chosenOption == 12){

                sql.execute("""
                            UPDATE candidate_skills SET id_skill = ${newSkill} 
                            WHERE id_skill = ${oldSkill} AND candidate_skills.id_candidate = ${candidateId};
                            """.toString())
            }
        }
        catch (Exception e){

            e.printStackTrace()
        }
        finally {

            sql.close()
        }
    }


    void delete(){

        try {

            if (chosenOption < 12) {

                String stringChosenOption = (String) candidateTableHeader[chosenOption - 1]

                sql.execute("""
                                UPDATE candidates 
                                SET $stringChosenOption = '' 
                                WHERE id = $candidateId;
                                """.toString())
            }

            if (chosenOption == 12){

                sql.execute("""
                                DELETE FROM candidate_skills 
                                WHERE id_skill = $oldSkill AND candidate_skills.id_candidate = ${candidateId}
                                """.toString())
            }
        }
        catch(Exception e){

            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }
}