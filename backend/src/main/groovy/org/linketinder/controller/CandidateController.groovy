package org.linketinder.controller

import org.linketinder.controller.controllerInterface.IcandidateController
import org.linketinder.service.CandidateService

class CandidateController implements IcandidateController{

    CandidateController(){}

    CandidateService candidateService = new CandidateService()


    void registerCandidate(List candidateInfo){

        candidateService.registerCandidate(candidateInfo)
    }


    void updateCandidate(Integer id, Integer chosenOption, String updatedInformation){

        candidateService.updateCandidate(id, chosenOption, updatedInformation)
    }


    void updateCandidateSkills(Integer id, Integer oldSkill, Integer newSkill){

        candidateService.updateCandidateSkills(id, oldSkill, newSkill)
    }


    void deleteCandidateInfo(Integer id, Integer chosenOption){

        candidateService.deleteCandidateInfo(id, chosenOption)
    }


    void deleteCandidateSkills(Integer id, Integer oldSkill){

        candidateService.deleteCandidateSkills(id, oldSkill)
    }


    List<Map> getCandidates(){

        List<Map> candidates = candidateService.getCandidates()
        return candidates
    }
}