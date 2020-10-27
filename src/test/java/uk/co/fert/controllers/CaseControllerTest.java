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
import uk.co.fert.dao.Case;
import uk.co.fert.services.CaseService;

@RunWith(SpringRunner.class)
public class CaseControllerTest {

    @MockBean
    CaseService service;
    @Autowired
    private CaseController caseController;

    @Test
    public void createCase() {
        Case c = new Case();
        c.setId(1);
        caseController.create(c);
        Mockito.verify(service).save(c);
    }

    @Test
    public void findCase() {
        Case c = new Case();
        c.setId(1);
        Mockito.when(service.find(1)).thenReturn(c);
        Case result = caseController.find(1);
        Mockito.verify(service).find(1);
        Assert.assertEquals(result.getId().intValue(), 1);
    }

    @TestConfiguration
    static class IncidentServiceTestContextConfiguration {
        @Bean
        public CaseController caseController() {
            return new CaseController();
        }
    }
}
