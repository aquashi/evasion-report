package uk.co.fert.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import uk.co.fert.dao.User;
import uk.co.fert.model.security.MyUserDetails;
import uk.co.fert.repository.UserRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User find(int id) {
        return userRepository.findById(id).orElse(new User());
    }


    public User findUserByUsername(String userName) {
        return userRepository.getUserByUsername(userName);
    }

    @Override
    @ModelAttribute("users")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}