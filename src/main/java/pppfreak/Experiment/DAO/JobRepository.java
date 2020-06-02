package pppfreak.Experiment.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pppfreak.Experiment.Entity.Job;

@Repository
public interface JobRepository extends CrudRepository<Job,Integer> {
    Job findByJobTitle(String title);
}
