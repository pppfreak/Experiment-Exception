package pppfreak.Experiment.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pppfreak.Experiment.Entity.ApplyForm;
@Repository
public interface ApplyFormRepository  extends CrudRepository<ApplyForm,Integer> {
}
