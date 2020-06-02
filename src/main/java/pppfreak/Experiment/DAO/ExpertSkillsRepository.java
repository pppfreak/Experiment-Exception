package pppfreak.Experiment.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pppfreak.Experiment.Entity.ExpertSkill;

@Repository
public interface ExpertSkillsRepository extends CrudRepository<ExpertSkill,Integer> {
    ExpertSkill findBySkill(String language);
}
