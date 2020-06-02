package pppfreak.Experiment.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "jobRole")
public class JobRole {

    @Id
    @GeneratedValue
    private Integer id;
    private String role;

    @OneToMany(mappedBy = "jobRole")
    private Set<CseEmployee> cseEmployees;

    public JobRole() {
    }

    public JobRole(Integer id,String role ) {
        this.id   = id;
       this.role = role;
    }
    @JsonBackReference
    public Set<CseEmployee> getCseEmployees() {
        return cseEmployees;
    }

    public void setCseEmployees(Set<CseEmployee> cseEmployees) {
        this.cseEmployees = cseEmployees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
