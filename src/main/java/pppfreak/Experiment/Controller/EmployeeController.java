package pppfreak.Experiment.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pppfreak.Experiment.DAO.ApplyFormRepository;
import pppfreak.Experiment.DAO.EmployeeRepository;
import pppfreak.Experiment.DAO.JobCategoryRepository;
import pppfreak.Experiment.DAO.JobRepository;
import pppfreak.Experiment.Entity.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final JobCategoryRepository jobCategoryRepository;

    private final EmployeeServiceImpl employeeService;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository , JobCategoryRepository jobCategoryRepository ,
                              EmployeeServiceImpl employeeService) {
        this.employeeRepository    = employeeRepository;
        this.jobCategoryRepository = jobCategoryRepository;

        this.employeeService     = employeeService;
    }


    @PostMapping("/api")
    public Employee addEmployee(@RequestBody RequestForm requestForm) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(requestForm,Employee.class);

        JobCategory jobCategory = jobCategoryRepository.findByCategory(requestForm.getJobCategory().getCategory());
        employee.setJobCategory(jobCategory);
        //jobCategory.setEmployees(employee);
        employeeRepository.save(employee);

        return employee;
    }

    @GetMapping("findEmployee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) throws Exception {

              return employeeService.getEmployeeById(id);
    }


    @GetMapping("findByEmail/{email}")
    public Employee  getEmployeeByEmail(@PathVariable String email)  {
        return employeeService.getEmployee(email);

    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployee(){
        return employeeService.findAllEmployee();
    }

}
