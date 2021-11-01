package by.overone.lesson20.repository;


import by.overone.lesson20.entity.User;

public interface UserRepository {

    User[] getAllUsers();

    User getUserById(long id);

    User getUserByFullName(String name, String surname);

    User removeUserId(long id);

    User addUser(User user);
}