package org.linketinder.DBDAO

import org.linketinder.entities.Candidate
import org.linketinder.utilities.IdValidation
import org.linketinder.menus.MenuOptionsSelection



class CandidateDAO {

    Candidate newCandidate
    Integer idCandidate
    Integer chosenOption

    
    CandidateDAO(newCandidate){
        this.newCandidate = newCandidate
    }

    CandidateDAO(idCandidate, chosenOption){
        this.idCandidate = idCandidate
        this.chosenOption = chosenOption
    }

    static Object sql = DAO.connectDataBase()

    static String[] candidateTableHeader = ['candidate_name', 'candidate_surname', 'candidate_birth', 'candidate_email', 'candidate_country',
                                            'candidate_cep', 'candidate_state', 'candidate_description', 'candidate_age', 'candidate_cpf', 'candidate_password']


    static list(){

        ArrayList<Map> allCandidates = []

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



     update(){

        try {

            if (chosenOption < 12) {

                String stringChosenOption = (String) candidateTableHeader[chosenOption - 1]
                //String updatedInformation = (String) MenuOptionsSelection.addUpdatedInformation()

                sql.execute("""
                            UPDATE candidates 
                            SET $stringChosenOption = '$updatedInformation' 
                            WHERE id = $candidateId;
                            """.toString())
            }

            if (chosenOption == 12){

                sql.query("""
                            SELECT skills.id, skills.skill 
                            FROM candidates, candidate_skills, skills 
                            WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = ${candidateId};
                            """.toString()) { resultSet ->

                    while (resultSet.next()) {

                        String candidateNumber = resultSet.getString(1)
                        String candidateSkill = resultSet.getString(2)
                        println(candidateNumber + " - " + candidateSkill)
                    }
                }

                Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()
                Integer newSkill = (Integer) SkillsSelection.chooseNewSkill()


                sql.execute("""
                            UPDATE candidate_skills SET id_skill = ${newSkill} 
                            WHERE id_skill = ${oldSkill} AND candidate_skills.id_candidate = ${candidateId};
                            """.toString())

                println('\nOperação realizada com sucesso.')
            }
        }
        catch (Exception e){

            e.printStackTrace()
        }
        finally {

            sql.close()
        }
    }
/*
    static deleteCandidatesInformations(){

        try {

            Integer candidateId = (Integer) IdValidation.validateId("candidate")

            Integer chosenOption = MenuOptionsSelection.selecMenuOption(candidateMenuOptions, "Deletar dados")

            if (chosenOption < 12) {

                String textChosenOption = (String) candidateTableHeader[chosenOption - 1]

                sql.execute("""
                            UPDATE candidates 
                            SET $textChosenOption = '' 
                            WHERE id = $candidateId;
                            """.toString())

                println("\nInformação excluída com sucesso.")
            }

            if (chosenOption == 12){

                sql.query("""
                        SELECT skills.id, skills.skill FROM candidates, candidate_skills, skills 
                        WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id AND id_candidate = ${candidateId};
                        """.toString()) { resultSet ->

                    while (resultSet.next()) {

                        String candidateNumber = resultSet.getString(1)
                        String candidateSkill = resultSet.getString(2)
                        println(candidateNumber + " - " + candidateSkill)
                    }
                }

                Integer oldSkill = (Integer) SkillsSelection.chooseOldSKill()

                sql.execute("""
                            DELETE FROM candidate_skills 
                            WHERE id_skill = $oldSkill AND candidate_skills.id_candidate = ${candidateId}
                            """.toString())

                println("\nInformação excluída com sucesso")
            }
        }
        catch(Exception e){

            e.printStackTrace()
        }
        finally {
            sql.close()
        }
    }*/
}

