import model.Account;
import model.Role;
import model.User;
import service.AccountService;
import service.RoleService;
import service.UserService;

import java.util.List;

public class Test {


    public static void main(String[] args) {
        RoleService roleService = new RoleService();
        AccountService accountService = new AccountService();
        UserService userService = new UserService();
        List<User> userList = userService.findAll();
        for (User u :
                userList) {
            System.out.println(u);
        }
        for (Role r :
                roleService.findAll()) {
            System.out.println(r);
        }
        for (Account a :
                accountService.findAll()) {
            System.out.println(a);
        }
    }
}
