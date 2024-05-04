package org.linketinder.service.serviceInterfaces


interface IcandidateService {

    void registerCandidate(List candidateInfo)

    void updateCandidate(Integer id, Integer chosenOption, String updatedInformation)

    void updateCandidateSkills(Integer id, Integer oldSkill, Integer newSkill)

    void deleteCandidateInfo(Integer id, Integer chosenOption)

    void deleteCandidateSkills(Integer id, Integer oldSkill)

    List<Map> getCandidates()
}
