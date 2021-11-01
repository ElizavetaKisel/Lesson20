package by.overone.lesson20.service;

import by.overone.lesson20.entity.User;

public interface UserService {

    User[] getAllUsers();

    User getUserById(long id);

    User getUserByFullName(String fullName);

    User removeUserId(long id);

    User addUser(User user);
}
