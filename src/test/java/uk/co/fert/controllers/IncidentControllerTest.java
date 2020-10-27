package uk.co.fert.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.fert.controllers.UserController;
import uk.co.fert.dao.Incident;
import uk.co.fert.services.IncidentService;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class IncidentControllerTest {

    @Autowired
    private IncidentController incidentController;
    @MockBean
    private IncidentService incidentService;

    @Test
    public void createIncident() {
        Incident incident = new Incident();
        incident.setId(1);
        incidentController.create(incident);
        Mockito.verify(incidentService).save(incident);
    }

    @Test
    public void findIncident() {
        Incident incident = new Incident();
        incident.setId(1);
        Mockito.when(incidentService.findIncident(1)).thenReturn(incident);
        Incident result = incidentController.findIncident((1));
        Mockito.verify(incidentService).findIncident(1);
        Assert.assertEquals(result.getId().intValue(), 1);
    }

    @Test
    public void findAllIncidentByStationId() {
        Incident incident = new Incident();
        incident.setId(1);
        Mockito.when(incidentService.findAllIncidentsByStationId(1)).thenReturn(Arrays.asList(incident));
        List<Incident> result = incidentController.findAllIncidentsByStationId((1));
        Mockito.verify(incidentService).findAllIncidentsByStationId(1);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0), incident);
    }

    @TestConfiguration
    static class incidentControllerTestContextConfiguration {
        @Bean
        public UserController incidentController() {
            return new UserController();
        }
    }
}
