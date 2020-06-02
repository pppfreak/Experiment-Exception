package pppfreak.Experiment.Entity;

import javax.persistence.*;

//@Entity(name = "university")
public class University {

    @Id
    @GeneratedValue
    private Integer id;

    private String universityName;

    @OneToOne(mappedBy = "university",cascade = CascadeType.MERGE)
    private Employee employee;

    public University() {
    }

    public University(Integer id , String universityName) {
        this.id             = id;
        this.universityName = universityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
