package org.linketinder.DBDAO

import org.linketinder.entities.Candidate
import org.linketinder.interfaces.Ientities


class CandidateDAO implements Ientities{

    private Integer candidateId
    private Integer chosenOption
    private Integer oldSkill
    private Integer newSkill
    private String updatedInformation
    private Candidate newCandidate

    CandidateDAO(){}

    CandidateDAO(newCandidate){
        setNewCandidate(newCandidate)
    }

    CandidateDAO(candidateId, chosenOption){
        setCandidateId( candidateId)
        setChosenOption(chosenOption)
    }

    CandidateDAO(candidateId, chosenOption, updatedInformation){
        setCandidateId( candidateId)
        setChosenOption(chosenOption)
        setUpdatedInformation(updatedInformation)
    }

    CandidateDAO(candidateId, chosenOption, oldSkill, newSkill){
        setCandidateId( candidateId)
        setChosenOption(chosenOption)
        setOldSkill(oldSkill)
        setNewSkill(newSkill)
    }


    static Object sql = DAO.connectDataBase()

    static String[] candidateTableHeader = ['candidate_name', 'candidate_surname', 'candidate_birth', 'candidate_email', 'candidate_country',
                                            'candidate_cep', 'candidate_state', 'candidate_description', 'candidate_age', 'candidate_cpf', 'candidate_password']


    List<Map> list(){

        List<Map> allCandidates = []

        try {
            ArrayList<Integer> ids = []

            sql.eachRow("""
                            SELECT id FROM candidates
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
                                WHERE id_skill = $oldSkill AND candidate_skills.id_candidate = ${candidateId};
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

    Integer getCandidateId() {
        return candidateId
    }

    void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId
    }

    Integer getChosenOption() {
        return chosenOption
    }

    void setChosenOption(Integer chosenOption) {
        this.chosenOption = chosenOption
    }

    Integer getOldSkill() {
        return oldSkill
    }

    void setOldSkill(Integer oldSkill) {
        this.oldSkill = oldSkill
    }

    Integer getNewSkill() {
        return newSkill
    }

    void setNewSkill(Integer newSkill) {
        this.newSkill = newSkill
    }

    String getUpdatedInformation() {
        return updatedInformation
    }

    void setUpdatedInformation(String updatedInformation) {
        this.updatedInformation = updatedInformation
    }

    Candidate getNewCandidate() {
        return newCandidate
    }

    void setNewCandidate(Candidate newCandidate) {
        this.newCandidate = newCandidate
    }
}