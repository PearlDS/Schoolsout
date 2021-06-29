package services;

import entities.User;
import repositories.UserRepository;

import java.util.List;
import java.util.Scanner;

public class UserService {

    private UserRepository userRepository;
    private Scanner scanner = new Scanner(System.in);

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void getUserByLogin(){
        System.out.println("What is your login?");
        String login = scanner.next();
        User user = userRepository.findUserByLogin(login);
        System.out.println(user);
    }

    public void getAllUsers(){
        List<User> users = userRepository.getAllUsers();
        for (User user: users){
            System.out.println(user);
        }
    }
}
