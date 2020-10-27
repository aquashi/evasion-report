package uk.co.fert.controllers;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.fert.dao.User;
import uk.co.fert.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;
    @MockBean
    private UserService userService;

    @Test
    public void createUser() {
        User user = new User();
        user.setId(1l);
        userController.create(user);
        Mockito.verify(userService).save(user);
    }

    @Test
    public void findUser() {
        User user = new User();
        user.setId(1l);
        Mockito.when(userService.find(1)).thenReturn(user);
        User result = userController.find((1));
        Mockito.verify(userService).find(1);
        Assert.assertEquals(result.getId().intValue(), 1);
    }

    @TestConfiguration
    static class userControllerTestContextConfiguration {
        @Bean
        public UserController userController() {
            return new UserController();
        }
    }
}
