package org.linketinder.entities

class Vacancy {

    private String position
    private String level
    private String shift
    private String model
    private String city
    private String state
    private String jobDescription
    private List<Integer> desiredSkills
    private int idCompany

    Vacancy (String position, String level, String shift, String model, String city, String state, String jobDescription, List<Integer> desiredSkills, Integer idCompany){
        setPosition(position)
        setLevel(level)
        setShift(shift)
        setModel(model)
        setCity(city)
        setState(state)
        setJobDescription(jobDescription)
        setDesiredSkills(desiredSkills)
        setIdCompany(idCompany)
    }


    String getPosition() {
        return position
    }

    void setPosition(String position) {
        this.position = position
    }

    String getLevel() {
        return level
    }

    void setLevel(String level) {
        this.level = level
    }

    String getShift() {
        return shift
    }

    void setShift(String shift) {
        this.shift = shift
    }

    String getModel() {
        return model
    }

    void setModel(String model) {
        this.model = model
    }

    String getCity() {
        return city
    }

    void setCity(String city) {
        this.city = city
    }

    String getState() {
        return state
    }

    void setState(String state) {
        this.state = state
    }

    String getJobDescription() {
        return jobDescription
    }

    void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription
    }

    List<Integer> getDesiredSkills() {
        return desiredSkills
    }

    void setDesiredSkills(List<Integer> desiredSkills) {
        this.desiredSkills = desiredSkills
    }

    Integer getIdCompany() {
        return idCompany
    }

    void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany
    }
}
