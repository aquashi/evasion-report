package uk.co.fert.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uk.co.fert.dao.Incident;

import java.util.List;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
    @Query("select i from Incident i where i.stationId= ?1")
    List<Incident> findAllIncidentsByStationId(int id);
}