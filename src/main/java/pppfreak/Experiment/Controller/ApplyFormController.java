package pppfreak.Experiment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pppfreak.Experiment.DAO.ApplyFormRepository;
import pppfreak.Experiment.DAO.CompanyProfileRepository;
import pppfreak.Experiment.DAO.EmployeeRepository;
import pppfreak.Experiment.DAO.JobRepository;
import pppfreak.Experiment.Entity.ApplyForm;
import pppfreak.Experiment.Entity.CompanyProfile;
import pppfreak.Experiment.Entity.Employee;
import pppfreak.Experiment.Entity.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ApplyFormController {

    private final JobRepository jobRepository;
    private final ApplyFormRepository applyFormRepository;
    private final EmployeeRepository employeeRepository;
   private  final CompanyProfileRepository  companyProfileRepository;
   @Autowired
    public ApplyFormController(JobRepository jobRepository , ApplyFormRepository applyFormRepository ,
                               EmployeeRepository employeeRepository ,
                               CompanyProfileRepository companyProfileRepository) {
        this.jobRepository       = jobRepository;
        this.applyFormRepository = applyFormRepository;
        this.employeeRepository  = employeeRepository;
        this.companyProfileRepository = companyProfileRepository;
    }

    @PostMapping("job/{jobId}/employee/{employeeId}")
    public void addApplyForm(@RequestBody ApplyForm form , @PathVariable Integer jobId ,
                             @PathVariable Integer employeeId) {
        Optional<Job> job = jobRepository.findById(jobId);
        Job temp = job.get();
        form.setJob(temp);

        Optional<Employee> emp = employeeRepository.findById(employeeId);
        Employee employee = emp.get();
        List<ApplyForm> applyForms = new ArrayList<>();
        applyForms.add(form);
        employee.setApplyForms(applyForms);
        applyFormRepository.save(form);
    }

    @PostMapping("company/{companyId}/job")
    public void createJob(@RequestBody Job job,@PathVariable Integer companyId){
        Optional<CompanyProfile> companyById = companyProfileRepository.findById(companyId);
        CompanyProfile companyProfile = companyById.get();
        job.setCompanyProfile(companyProfile);

        companyProfile.notifyObserver(companyProfile);

        jobRepository.save(job);
    }

    @PostMapping("subscribe/{companyId}/employee/{id}")
    public void subscribeCompany(@PathVariable Integer id,@PathVariable Integer
            companyId){
        Optional<Employee> emp = employeeRepository.findById(id);
        Employee employee = emp.get();

        Optional<CompanyProfile> tempCompany = companyProfileRepository.findById(companyId);
        CompanyProfile company =  tempCompany.get();
        company.registerObserver(employee);    // company get employee subscriber

        // employee get company subscription
        List<CompanyProfile> companies = new ArrayList<>();
        companies.add(company);
        employee.setSubscribedCompanies(companies);
        employeeRepository.save(employee);
    }

    @PostMapping("unsubscribe/{companyId}/{employeeId}")
    public void unsubscribeCompany(@PathVariable Integer companyId,@PathVariable Integer employeeId){
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        Employee employee = emp.get();

        Optional<CompanyProfile> tempCompany = companyProfileRepository.findById(companyId);
        CompanyProfile company =  tempCompany.get();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        company.setUnsubscribeList(employees);
        companyProfileRepository.save(company);
    }


}
