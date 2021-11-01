package by.overone.lesson20.service;

import by.overone.lesson20.entity.User;
import by.overone.lesson20.repository.UserRepository;
import by.overone.lesson20.repository.UserRepositoryListImpl;
import by.overone.lesson20.utils.UserWrapper;

public class UserServiceImpl implements UserService {

    private static long counter = 11;

    private final UserRepository userRepository = new UserRepositoryListImpl();

    @Override
    public User[] getAllUsers() {
        return userRepository.getAllUsers();

    }

    @Override
    public User getUserById(long id) {
        User [] users = getAllUsers();
        for (User user: users) {
            if(user.getId() == id){
                return userRepository.getUserById(id);
            }
        }
        return new User();
    }

    @Override
    public User getUserByFullName(String fullName) {
        User [] users = getAllUsers();
        String [] names = UserWrapper.fullNameToNames(fullName);
        for (User user: users) {
            if(user.getName().equals(names[0]) && user.getSurname().equals(names[1])){
                return userRepository.getUserByFullName(names[0], names[1]);
            }
        }
        return new User();
    }

    @Override
    public User removeUserId(long id) {
        User [] users = getAllUsers();
        for (User user: users) {
            if(user.getId() == id){
                return userRepository.removeUserId(id);
            }
        }
        return new User();
    }

    @Override
    public User addUser(User user) {

        User [] users = getAllUsers();
        for (User us: users) {
            if(us.equals(user)){
                return new User();
            }
        }
        user.setId(counter);
        counter++;
        return userRepository.addUser(user);
    }
}


