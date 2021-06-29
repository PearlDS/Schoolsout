import entities.Person;
import entities.User;
import repositories.EMFactory;
import repositories.UserRepository;
import services.UserService;

public class Mainclass {
    public static void main(String[] args) {
        //UserService userService = new UserService();
        UserRepository userRepository = new UserRepository();
        Person person = new Person();
        User user = new User("rerger", "lolcats", true, person);
        userRepository.createUser(user);
        System.out.println("check");
    }
}
