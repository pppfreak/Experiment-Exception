package pppfreak.Experiment.DAO;

import org.springframework.data.repository.CrudRepository;
import pppfreak.Experiment.Entity.JobRole;

public interface JobRoleRepository extends CrudRepository<JobRole,Integer> {
    JobRole findByRole(String role);
}
