package uk.co.fert.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uk.co.fert.dao.Incident;
import uk.co.fert.repository.IncidentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private UserService userService;

    @Override
    public void save(Incident incident) {
        this.incidentRepository.save(incident);
    }

    @Override
    public Incident findIncident(int id) {
        return incidentRepository.findById(id).orElse(new Incident());
    }

    @Override
    public List<Incident> findAllIncidentsByStationId(int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            int stationId = userService.findUserByUsername(authentication.getName()).getStationId();

            if (authentication.getAuthorities().contains("ROLE_ADMIN") || stationId == id) {
                return incidentRepository.findAllIncidentsByStationId(id);
            }
        }
        return new ArrayList<Incident>();
    }

}