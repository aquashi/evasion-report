package uk.co.fert.services;

import uk.co.fert.dao.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User find(int id);

    User findUserByUsername(String userName);

    List<User> getAllUsers();
}
