package pppfreak.Experiment.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pppfreak.Experiment.Entity.Employee;

import java.util.EnumMap;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    //Employee findByEmail(String email);
    @Query(value = "select * from employee e where e.email=:email",nativeQuery = true)
    Employee getEmployeeByEmail(@Param("email") String email);

    @Query(value = "select * from Employee e  where e.id=:id",nativeQuery = true)
    Employee getEmployeeById(Integer id);

    @Query(value = "select * from employee e  "
                   +"left join fetch e.jobCategory"
                   + "left join fetch e.applyForms"
                   + "left join fetch e.notification"
                   + "left join fetch e.subscribedCompanies",nativeQuery = true)
    List<Employee> getAllEmployee();
}
