package uk.co.fert.services;

import uk.co.fert.dao.Incident;

import java.util.List;

public interface IncidentService {

    void save(Incident incident);

    Incident findIncident(int id);

    List<Incident> findAllIncidentsByStationId(int id);
}
