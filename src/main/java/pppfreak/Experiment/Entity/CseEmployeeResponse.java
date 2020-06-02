package pppfreak.Experiment.Entity;

import java.util.Set;

public class CseEmployeeResponse {

    private String name;
    private Set<ExpertSkill> expertSkills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<ExpertSkill> getExpertSkills() {
        return expertSkills;
    }

    public void setExpertSkills(Set<ExpertSkill> expertSkills) {
        this.expertSkills = expertSkills;
    }
}
