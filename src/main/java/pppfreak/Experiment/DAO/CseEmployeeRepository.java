package pppfreak.Experiment.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pppfreak.Experiment.Entity.CseEmployee;
@Repository
public interface CseEmployeeRepository extends CrudRepository<CseEmployee,Integer> {
}
