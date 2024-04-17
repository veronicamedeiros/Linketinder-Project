package org.linketinder.DBDAO

import org.linketinder.entities.Candidate
import org.linketinder.menus.CandidateRegistrationMenu
import org.linketinder.menus.MenuOptionsSelection
import org.linketinder.menus.SkillsSelection
import org.linketinder.utilities.IdValidation


class CandidateDAO {

    static Object sql = DAO.connectDataBase()

    static String[] candidateTableHeader = ['candidate_name', 'candidate_surname', 'candidate_birth', 'candidate_email', 'candidate_country',
                                            'candidate_cep', 'candidate_state', 'candidate_description', 'candidate_age', 'candidate_cpf', 'candidate_password']
    static List<String> candidateMenuOptions = ["Nome", "Sobrenome", "Data de Nascimento", "Email", "País", "CEP", "Estado", "Descrição", "Idade", "CPF", "Senha", "Habilidades"]


    static listAllCandidates(){

        String previousCandidateId

        try {

            sql.eachRow("""
                        SELECT candidate_description, skills.skill, candidates.id
                        FROM candidates, candidate_skills, skills
                        WHERE candidate_skills.id_candidate = candidates.id AND candidate_skills.id_skill = skills.id
                        ORDER BY candidates;
                        """) { resultSet ->

                while (resultSet.next()) {

                    String description = resultSet.getString(1)
                    String candidateId = resultSet.getString(3)

                    if (previousCandidateId != candidateId){
                        println('\n----\n')
                        println("DESCRIÇÃO:\n$description")
                        println('\nHABIDADES:')
                    }

                    String skills = resultSet.getString(2)

                    println(skills)

                    previousCandidateId = candidateId
                }
            }
            println()
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    static registerCandidates(){

        try {

            Candidate newCandidate = CandidateRegistrationMenu.register()

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

            println('Operação realizada com sucesso.')
        }
        catch (Exception e){

            e.printStackTrace()
        }
        finally {

            sql.close()
        }
    }


    static candidateExists(Integer candidateId){

        try {
            sql.rows("""
                        SELECT id FROM candidates 
                        WHERE id = $candidateId;
                        """.toString()){ resultSet ->}
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    static updateCandidatesInformations(){

        try {
            Integer candidateId = (Integer) IdValidation.validateId("candidate")

            Integer chosenOption = MenuOptionsSelection.selecMenuOption(candidateMenuOptions, "Atualizar Dados")


            if (chosenOption < 12) {

                String stringChosenOption = (String) candidateTableHeader[chosenOption - 1]
                String updatedInformation = (String) MenuOptionsSelection.addUpdatedInformation()

                sql.execute("""
                            UPDATE candidates 
                            SET $stringChosenOption = '$updatedInformation' 
                            WHERE id = $candidateId;
                            """.toString())

                println('\nOperação realizada com sucesso.')
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
    }
}

