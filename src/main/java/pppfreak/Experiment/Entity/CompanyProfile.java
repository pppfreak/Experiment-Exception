package pppfreak.Experiment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "companyProfile")
public class CompanyProfile implements Subscribe {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "companyProfile")
    private List<Job> jobs;

    @JsonIgnore
    @ManyToMany(mappedBy = "subscribedCompanies")
    private List<Employee> subscriberList;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "unsubscribe_list",joinColumns = @JoinColumn(name = "companyProfileId")
                                        ,inverseJoinColumns = @JoinColumn(name = "employeeId"))
    private List<Employee> unsubscribeList;

    @Override
    public void registerObserver(Employee employee) {
        subscriberList.add(employee);

    }

    @Override
    public void removedObserver(Employee employee) {
        if (subscriberList != null && subscriberList.contains(employee)) {
            subscriberList.remove(employee);
        }
    }

    @Override
    public void notifyObserver(CompanyProfile companyProfile) {
        for (Employee  employee:  subscriberList) {

            if(!unsubscribeList.contains(employee)){
                employee.update(this);
            }
        }
    }

    public List<Employee> getUnsubscribeList() {
        return unsubscribeList;
    }

    public void setUnsubscribeList(List<Employee> unsubscribeList) {
        this.unsubscribeList = unsubscribeList;
    }

    public List<Employee> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(List<Employee> subscriberList) {
        this.subscriberList = subscriberList;
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

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}
