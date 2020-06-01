package pppfreak.Experiment.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pppfreak.Experiment.DAO.EmployeeRepository;
import pppfreak.Experiment.Entity.Employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository  employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testGetEmployee() throws Exception {
//        Employee employee = new Employee();
//        employee.setPassword("lsdkfjsl");
//
//        when(employeeRepository.getEmployeeByEmail(anyString())).thenReturn(employee);
//        Employee employee1 = employeeService.getEmployee("pppfreak@gmail.com");
//        assertNotNull(employee1);
//        assertEquals("lsdkfjsl",employee1.getPassword());
//
//    }
//
//    @Test
//    void testException(){
//        when(employeeRepository.getEmployeeByEmail(anyString())).thenReturn(null);
//
//        assertThrows(NullPointerException.class,
//
//                     ()-> {
//            employeeService.getEmployee("pppfreak@gmail.com");
//                     }
//                     );
//
//    }

}