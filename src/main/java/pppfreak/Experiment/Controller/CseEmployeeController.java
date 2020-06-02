package pppfreak.Experiment.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pppfreak.Experiment.DAO.CseEmployeeRepository;
import pppfreak.Experiment.DAO.ExpertSkillsRepository;
import pppfreak.Experiment.DAO.JobRoleRepository;
import pppfreak.Experiment.DAO.SecondarySkillRepository;
import pppfreak.Experiment.Entity.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CseEmployeeController {

    private final CseEmployeeRepository cseEmployeeRepository;
    private final ExpertSkillsRepository expertSkillsRepository;
    private final JobRoleRepository jobRoleRepository;
    private final SecondarySkillRepository secondarySkillRepository;

    @Autowired
    public CseEmployeeController(CseEmployeeRepository cseEmployeeRepository ,
                                 ExpertSkillsRepository expertSkillsRepository , JobRoleRepository jobRoleRepository ,
                                 SecondarySkillRepository secondarySkillRepository) {
        this.cseEmployeeRepository = cseEmployeeRepository;

        this.expertSkillsRepository   = expertSkillsRepository;
        this.jobRoleRepository        = jobRoleRepository;
        this.secondarySkillRepository = secondarySkillRepository;
    }

    @GetMapping("com/{skill}")
    public ResponseEntity<Set<CseEmployee>> findCseEmployeeBySkill(@PathVariable String skill) {

        SecondarySkill expertSkill = secondarySkillRepository.findBySkill(skill);
        System.out.println(expertSkill.getCseEmployees());
        return ResponseEntity.ok(expertSkill.getCseEmployees());
    }

    @GetMapping("role/{jobRole}")
    public ResponseEntity<Set<CseEmployee>> findCseEmployeeByJobRole(@PathVariable String jobRole) {

      JobRole jobRole1 = jobRoleRepository.findByRole(jobRole);
        return ResponseEntity.ok(jobRole1.getCseEmployees());
    }

    @PostMapping(value = "/cse", produces = {MediaType.APPLICATION_JSON_VALUE},
                 consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addEmployee(@RequestBody CseRequestForm requestForm) {

        ModelMapper modelMapper = new ModelMapper();
        CseEmployee cseEmployee = modelMapper.map(requestForm , CseEmployee.class);

        JobRole jobRole = jobRoleRepository.findByRole(requestForm.getJobRole().getRole());
        cseEmployee.setJobRole(jobRole);

        Set<ExpertSkill> expertSkills = requestForm.getExpertSkill();
        Set<ExpertSkill> temp = new HashSet<>();

        for (ExpertSkill p : expertSkills) {
            p = expertSkillsRepository.findBySkill(p.getSkill());
            temp.add(new ExpertSkill(p.getId() , ""));

        }
        Set<SecondarySkill> secondarySkills = requestForm.getSecondarySkill();
        Set<SecondarySkill> secondSkill = new HashSet<>();

        for (SecondarySkill s : secondarySkills) {
            s = secondarySkillRepository.findBySkill(s.getSkill());
            secondSkill.add(new SecondarySkill(s.getId() , ""));
        }
        cseEmployee.setSecondarySkill(secondSkill);
        cseEmployee.setExpertSkill(temp);

        cseEmployeeRepository.save(cseEmployee);


    }

    @PutMapping("/cse/update/{id}")
    public CseEmployee updateEmployee(@RequestBody CseRequestForm requestForm , @PathVariable Integer id) {

        Optional<CseEmployee> cseEmployeeOptional = cseEmployeeRepository.findById(id);

        CseEmployee cseEmployee = cseEmployeeOptional.get();
        cseEmployee.setName(requestForm.getName());

        JobRole jobRole = jobRoleRepository.findByRole(requestForm.getJobRole().getRole());
        cseEmployee.setJobRole(jobRole);

        Set<ExpertSkill> expertSkills = requestForm.getExpertSkill();

        Set<ExpertSkill> temp = new HashSet<>();
        for (ExpertSkill p : expertSkills) {
            p = expertSkillsRepository.findBySkill(p.getSkill());
            temp.add(new ExpertSkill(p.getId() , ""));
        }
        Set<SecondarySkill> secondarySkills = requestForm.getSecondarySkill();
        Set<SecondarySkill> secondSkill = new HashSet<>();

        for (SecondarySkill s : secondarySkills) {
            s = secondarySkillRepository.findBySkill(s.getSkill());
            secondSkill.add(new SecondarySkill(s.getId() , ""));
        }
        cseEmployee.setSecondarySkill(secondSkill);
        cseEmployee.setExpertSkill(temp);

        cseEmployeeRepository.save(cseEmployee);

        return cseEmployee;
    }
}
