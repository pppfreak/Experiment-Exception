package pppfreak.Experiment.Entity;

import javax.persistence.*;
import java.util.List;

public class Unsubscribe {
//
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//    @OneToMany
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
