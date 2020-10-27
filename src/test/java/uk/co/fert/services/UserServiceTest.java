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
import uk.co.fert.dao.User;
import uk.co.fert.repository.UserRepository;

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    User user;
    @Autowired
    private UserService subject;
   @MockBean
    private UserRepository userRepository;

    @Test
    public void createCaseTest() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        subject.save(user);
        Mockito.verify(userRepository).save(user);
    }

    @Test
    public void findCase() {
        User user = new User();
        user.setId(1l);
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));
        User result = subject.find(1);
        Mockito.verify(userRepository).findById(1);
        Assert.assertEquals(result.getId().intValue(), 1);
    }

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserDetailsServiceImpl();
        }
    }
}