package pppfreak.Experiment.Entity;


public class RequestForm {

    private String email;

    private String password;

    private JobCategory jobCategory;

    private ApplyForm applyForm;

    public ApplyForm getApplyForm() {
        return applyForm;
    }

    public void setApplyForm(ApplyForm applyForm) {
        this.applyForm = applyForm;
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

}
