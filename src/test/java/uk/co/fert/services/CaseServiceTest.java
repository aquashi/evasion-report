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
import uk.co.fert.dao.Case;
import uk.co.fert.repository.CaseRepository;

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CaseServiceTest {

    @Mock
    Case c;
    @Autowired
    private CaseServiceImpl subject;

    @MockBean
    private CaseRepository caseRepository;

    @Test
    public void createCaseTest() {
        when(caseRepository.save(any(Case.class))).thenReturn(c);
        subject.save(c);
        Mockito.verify(caseRepository).save(c);
    }

    @Test
    public void findCase() {
        Case c = new Case();
        c.setId(1);
        Mockito.when(caseRepository.findById(1)).thenReturn(Optional.of(c));
        Case result = subject.find(1);
        Mockito.verify(caseRepository).findById(1);
        Assert.assertEquals(result.getId().intValue(), 1);
    }

    @Test
    public void editCase() {
        Case c = new Case();
        c.setId(1);
        Mockito.when(caseRepository.findById(1)).thenReturn(Optional.of(c));
        Case result = subject.find(1);
        Mockito.verify(caseRepository).findById(1);
        Assert.assertEquals(result.getId().intValue(), 1);
    }

    @TestConfiguration
    static class CaseServiceImplTestContextConfiguration {
        @Bean
        public CaseService caseService() {
            return new CaseServiceImpl();
        }
    }
}