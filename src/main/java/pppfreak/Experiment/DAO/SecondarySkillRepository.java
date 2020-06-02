package pppfreak.Experiment.DAO;

import org.springframework.data.repository.CrudRepository;
import pppfreak.Experiment.Entity.SecondarySkill;

public interface SecondarySkillRepository extends CrudRepository<SecondarySkill,Integer> {
    SecondarySkill findBySkill(String skill);
}
