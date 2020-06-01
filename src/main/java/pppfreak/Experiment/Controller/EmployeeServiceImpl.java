package pppfreak.Experiment.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import pppfreak.Experiment.DAO.EmployeeRepository;
import pppfreak.Experiment.Entity.Employee;

import java.util.List;

@Service
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository ) {
        this.employeeRepository = employeeRepository;
    }


   public Employee getEmployee(String gmail){
       Employee employee= employeeRepository.getEmployeeByEmail(gmail);

//       if(employee==null){
//           throw new NullPointerException(gmail);
//       }

         return employee;
   }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.getEmployeeById(id);

    }

    public List<Employee> findAllEmployee() {

        return employeeRepository.getAllEmployee();

    }
}
