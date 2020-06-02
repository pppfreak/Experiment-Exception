package pppfreak.Experiment.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pppfreak.Experiment.Entity.CompanyProfile;

@Repository
public interface CompanyProfileRepository extends CrudRepository<CompanyProfile,Integer> {
    CompanyProfile findByName(String name);
}
