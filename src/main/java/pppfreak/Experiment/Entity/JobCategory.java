package pppfreak.Experiment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "jobCategory")
public class JobCategory implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String category;

    @JsonIgnore
    @OneToMany(mappedBy = "jobCategory",
            cascade = {CascadeType.MERGE})
    private List<Employee> employees;

    public JobCategory() {
    }

    public JobCategory(Integer id , String category) {
        this.id        = id;
        this.category  = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employee) {
        employees.add(employee);
    }
}
