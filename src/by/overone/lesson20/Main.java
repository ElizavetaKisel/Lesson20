package by.overone.lesson20;

import by.overone.lesson20.entity.User;
import by.overone.lesson20.service.UserService;
import by.overone.lesson20.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        boolean flag = true;
        do {
            if (flag == false){
                break;
            }
            System.out.println("1.Show all users\n2.Add user\n3.Remove user\n4.Search user by id\n5.Search user by full name\n6.End");
            Scanner scan = new Scanner(System.in);
            int n = InputData.inputN();

            if (n < 7){
                switch (n) {
                    case 1:
                        System.out.println("BD:");
                        User[] users = userService.getAllUsers();

                        for (User user : users) {
                            System.out.println(user);
                        }
                        break;
                    case 2:
                        System.out.println("ADD: ");

                        User user = new User();
                        InputData.inputInfAboutUser(user);
                        User newUser = userService.addUser(user);
                        if (newUser.getId() > 0) {
                            System.out.println("ADDED: " + newUser);
                        } else {
                            System.out.println("User already exists");
                        }
                        break;
                    case 3:
                        System.out.println("REMOVE: ");
                        System.out.print("Enter id:");
                        n = InputData.inputN();
                        User removedUser = userService.removeUserId(n);
                        if (removedUser.getId() > 0) {
                            System.out.println("REMOVED: " + removedUser);
                        } else {
                            System.out.println("User not found");
                        }
                        break;
                    case 4:
                        System.out.println("SEARCH BY ID:");
                        System.out.print("Enter id:");
                        n = InputData.inputN();
                        User user1 = userService.getUserById(n);
                        if (user1.getId() > 0) {
                            System.out.println("FOUNDED: " + user1);
                        } else {
                            System.out.println("User not found");
                        }
                        break;
                    case 5:
                        System.out.println("SEARCH BY FULLNAME:");
                        System.out.print("Enter full name:");
                        String str = scan.nextLine();
                        User user2 = userService.getUserByFullName(str);
                        if (user2.getId() > 0) {
                            System.out.println("FOUNDED: " + user2);
                        } else {
                            System.out.println("User not found");
                        }
                        break;
                    case 6:
                        flag = false;
                        break;

                }
            }else System.out.println("Error! Please, repeat the input");

        } while (true);
    }
}
