package basics.full_stack_project.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import basics.full_stack_project.com.entity.UserInfoEntity;
import basics.full_stack_project.com.services.UserService;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";  // This maps the root URL to index.html
    }

    @GetMapping("/sample-html")
    public String firstHtmlSample() {
        return "index";  // This maps /sample-html to index.html
    }

    @GetMapping("/users")
    public String listAllUsers(Model model) {
        List<UserInfoEntity> listUsers = userService.listAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "users";  // This maps /users to users.html
    }
}
