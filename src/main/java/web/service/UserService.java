package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(Long id, User updatedUser);

    void deleteUser(Long id);

    User getUser(Long id);

}
