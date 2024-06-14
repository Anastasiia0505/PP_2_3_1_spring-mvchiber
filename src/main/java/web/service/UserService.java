package web.service;


import web.model.User;

import java.util.List;

public interface UserService {

    List<User> allUsers();
    User getUserId(int id);
    void addUser(User user);
    void updateUser(int id,User user);
    void deleteUser(int id);
}
