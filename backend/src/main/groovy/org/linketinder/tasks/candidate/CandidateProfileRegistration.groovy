package org.linketinder.tasks.candidate

import org.linketinder.entities.Candidate
import org.linketinder.menus.CandidateRegistrationMenu
import org.linketinder.DBDAO.CandidateDAO

class CandidateProfileRegistration {

    void registerCandidate(){

        try {
            CandidateRegistrationMenu newRegistration = new CandidateRegistrationMenu()
            Candidate newCandidate = newRegistration.registerCandidateInformations()

            CandidateDAO dbRegistration = new CandidateDAO(newCandidate)
            dbRegistration.register()
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }
}
