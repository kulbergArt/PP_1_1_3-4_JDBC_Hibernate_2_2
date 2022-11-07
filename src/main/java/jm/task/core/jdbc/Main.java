package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String name1 = "Ivan";
        String lastName1 = "Ivanov";
        byte age1 = 30;
        String name2 = "Aleksey";
        String lastName2 = "Alekseyev";
        byte age2 = 25;
        String name3 = "Vova";
        String lastName3 = "Vovanov";
        byte age3 = 18;
        String name4 = "Elena";
        String lastName4 = "Elenova";
        byte age4 = 40;

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser(name1, lastName1, age1);
        userService.saveUser(name2, lastName2, age2);
        userService.saveUser(name3, lastName3, age3);
        userService.saveUser(name4, lastName4, age4);
        List<User> list = userService.getAllUsers();
        list.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
