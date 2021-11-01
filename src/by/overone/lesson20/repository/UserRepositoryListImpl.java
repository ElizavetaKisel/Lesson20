package by.overone.lesson20.repository;

import by.overone.lesson20.DBList;
import by.overone.lesson20.entity.User;
import by.overone.lesson20.utils.UserWrapper;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryListImpl implements UserRepository {

    @Override
    public User[] getAllUsers() {
        List<User> users = new ArrayList<>();
        for (String strUser: DBList.users) {
            users.add(UserWrapper.stringToUser(strUser));
        }
        return users.toArray(new User[0]);
    }

    @Override
    public User getUserById(long id) {
        String idProp = "id: " + id +  ",";
        for (String strUser: DBList.users){
            if (strUser.startsWith(idProp)){
                return UserWrapper.stringToUser(strUser);
            }
        }
        return new User();
    }

    @Override
    public User getUserByFullName(String name, String surname) {
        String namesProp = "name: " + name +  ", surname: " + surname + ",";
        for (String strUser: DBList.users){
            if (strUser.contains(namesProp)){
                return UserWrapper.stringToUser(strUser);
            }
        }
        return null;
    }

    @Override
    public User removeUserId(long id) {
        String idProp = "id: " + id +  ",";
        for (String strUser: DBList.users){
            if (strUser.startsWith(idProp)){
                DBList.users.remove(strUser);
                return UserWrapper.stringToUser(strUser);
            }
        }
        return new User();
    }

    @Override
    public User addUser(User user) {
        DBList.users.add(UserWrapper.userToString(user));
        return UserWrapper.stringToUser(DBList.users.get(DBList.users.size()-1));
    }
}
