package pppfreak.Experiment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "applyForm")
public class ApplyForm {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer  expectedSalary;

    @JsonIgnore
    @ManyToMany(mappedBy = "applyForms")
    private List<Employee> employees;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "jobId")
    private Job job;

    public ApplyForm() {
    }

    public ApplyForm(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Integer expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
