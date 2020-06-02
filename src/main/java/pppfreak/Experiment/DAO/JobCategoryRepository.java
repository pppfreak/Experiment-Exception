package pppfreak.Experiment.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pppfreak.Experiment.Entity.JobCategory;
@Repository
public interface JobCategoryRepository extends CrudRepository<JobCategory,Integer> {
    JobCategory findByCategory(String category);
}
