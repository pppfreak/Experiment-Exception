package pppfreak.Experiment.Entity;

public interface Subscribe {
    void registerObserver(Employee observer);
    void removedObserver(Employee observer);
    void notifyObserver(CompanyProfile companyProfile);
}
