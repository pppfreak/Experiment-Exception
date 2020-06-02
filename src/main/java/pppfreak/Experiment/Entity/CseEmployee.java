package pppfreak.Experiment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity(name = "cseEmployee")
public class CseEmployee implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "jobRoleId")
    private JobRole jobRole;

    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @ManyToMany
    @JoinTable(name = "cseEmployee_expertSkill",
               joinColumns = @JoinColumn(name = "cseEmployee_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "expertSkill_id", referencedColumnName = "id"))
    private Set<ExpertSkill> expertSkill;

    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @ManyToMany
    @JoinTable(name = "cseEmployee_secondarySkill",
            joinColumns = @JoinColumn(name = "cseEmployee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "secondarySkill_id", referencedColumnName = "id"))
    private Set<SecondarySkill> secondarySkill;


    public Set<SecondarySkill> getSecondarySkill() {
        return secondarySkill;
    }

    public Set<ExpertSkill> getExpertSkill() {
        return expertSkill;
    }

    public JobRole getJobRole() {
        return jobRole;
    }

    public void setSecondarySkill(Set<SecondarySkill> secondarySkill) {
        this.secondarySkill = secondarySkill;
    }


    public void setExpertSkill(Set<ExpertSkill> expertSkill) {
        this.expertSkill = expertSkill;
    }


    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
