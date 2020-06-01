package pppfreak.Experiment.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "employee")
public class  Employee implements Observer{

    @Id
    @GeneratedValue
    private Integer id;

    private String email;

    private String password;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "jobCategory_id")
    private JobCategory jobCategory;

    @ManyToMany
    @JoinTable(name = "employeeJobApply",joinColumns = @JoinColumn(name = "employeeId"),
               inverseJoinColumns = @JoinColumn(name = "applyFormId"))
    private List<ApplyForm> applyForms;

    @ManyToMany
    @JoinTable(name = "notifiedCompany",joinColumns = @JoinColumn(name = "employeeId"),
               inverseJoinColumns = @JoinColumn(name = "companyProfileId"))
    private List<CompanyProfile> notification;


    @ManyToMany
    @JoinTable(name = "subscribedCompanies",joinColumns = @JoinColumn(name = "employeeId"),
               inverseJoinColumns = @JoinColumn(name = "companyProfileId"))
    private List<CompanyProfile> subscribedCompanies;

    public List<CompanyProfile> getSubscribedCompanies() {
        return subscribedCompanies;
    }

    public void setSubscribedCompanies(List<CompanyProfile> subscribedCompanies) {
        this.subscribedCompanies = subscribedCompanies;
    }

    public List<CompanyProfile> getNotification() {
        return notification;
    }

    public void setNotification(List<CompanyProfile> notification) {
        this.notification = notification;
    }

    public List<ApplyForm> getApplyForms() {
        return applyForms;
    }

    public void setApplyForms(List<ApplyForm> applyForms) {
        this.applyForms = applyForms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }

    @Override
    public void update(CompanyProfile companyProfile) {
        if(notification ==null){
            notification = new ArrayList<>();
        }
        this.notification.add(companyProfile);
    }
}
