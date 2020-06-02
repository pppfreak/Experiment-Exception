package pppfreak.Experiment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity(name = "job")
public class Job {
    @Id
    @GeneratedValue
    private Integer id;

    private String jobTitle;

    private SimpleDateFormat simpleDateFormat;

    @JsonIgnore
    @OneToOne(mappedBy = "job",cascade = CascadeType.ALL,orphanRemoval = true)
    private ApplyForm applyForm;

    @ManyToOne
    @JoinColumn(name = "companyProfileId")
    private CompanyProfile companyProfile;

    public CompanyProfile getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
    }

    public Job() {
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public Job(Integer id , String jobTitle) {
        this.id       = id;
        this.jobTitle = jobTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ApplyForm getApplyForm() {
        return applyForm;
    }

    public void setApplyForm(ApplyForm applyForm) {
        this.applyForm = applyForm;
    }
}
