package pppfreak.Experiment.Entity;

import java.util.Set;

public class CseRequestForm {

    private String name;
    private JobRole jobRole;
    private Set<ExpertSkill> expertSkill;
    private Set<SecondarySkill> secondarySkill;

    public Set<SecondarySkill> getSecondarySkill() {
        return secondarySkill;
    }

    public void setSecondarySkill(Set<SecondarySkill> secondarySkill) {
        this.secondarySkill = secondarySkill;
    }

    public JobRole getJobRole() {
        return jobRole;
    }

    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ExpertSkill> getExpertSkill() {
        return expertSkill;
    }

    public void setExpertSkill(Set<ExpertSkill> expertSkill) {
        this.expertSkill = expertSkill;
    }
}
