package uk.co.fert.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.fert.dao.Incident;
import uk.co.fert.repository.IncidentRepository;

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IncidentServiceTest {
    @Mock
    Incident incident;
    @Autowired
    private IncidentService subject;
    @MockBean
    private IncidentRepository incidentRepository;

    @Test
    public void createIncidentTest() {
        when(incidentRepository.save(any(Incident.class))).thenReturn(incident);
        subject.save(incident);
        Mockito.verify(incidentRepository).save(incident);
    }

    @Test
    public void findIncident() {
        Incident incident = new Incident();
        incident.setId(1);
        Mockito.when(incidentRepository.findById(1)).thenReturn(Optional.of(incident));
        Incident result = subject.findIncident(1);
        Mockito.verify(incidentRepository).findById(1);
        Assert.assertEquals(result.getId().intValue(), 1);
    }

    @TestConfiguration
    static class IncidentServiceTestContextConfiguration {
        @Bean
        public IncidentService incidentService() {
            return new IncidentServiceImpl();
        }
    }
}