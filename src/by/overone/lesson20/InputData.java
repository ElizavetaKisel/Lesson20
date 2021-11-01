package by.overone.lesson20;

import by.overone.lesson20.entity.User;

import java.util.Scanner;

public class InputData {

    public static String check(){
        Scanner scan = new Scanner(System.in);
        String str;
        while (true) {
            str = scan.nextLine();
            if (!str.contains(" ") && !str.isBlank()){
                break;
            }
            System.out.println("Error! Please, repeat the input");
        }
        return str;
    }

    public static void inputInfAboutUser(User user) {

        System.out.println("Enter name:");
        user.setName(check());
        System.out.println("Enter surname:");
        user.setSurname(check());
        System.out.println("Enter age:");
        user.setAge(inputN());
        System.out.println("Enter phone number:");
        user.setPhoneNumber(check());
    }

    public static int inputN(){
        Scanner scan = new Scanner(System.in);
        int n;
        while (true) {
            String str = scan.nextLine();
            if (!str.matches("\\D+")) {
                n = Integer.parseInt(str);
                if (n > 0) {
                    break;
                }
            }
            System.out.println("Error! Please, repeat the input");
        }
        return n;
    }
}

