package example.session3_crud_user.controllers;

import example.session3_crud_user.models.User;
import example.session3_crud_user.models.UserDAO;
import example.session3_crud_user.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    User _userBean;

    @GetMapping("/")
    public String addOrEdit(ModelMap model){
        User u = new User();
        model.addAttribute("USER", u);
        model.addAttribute("ACTION", "saveOrUpdate");
        return "register-user";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") User user) {
//        UserDAO dao = new UserDAO();
//        dao.save(user);
//        System.out.println("size: "+dao.getAll().size());
        userService.save(user);
        return "register-user";
    }

    @GetMapping("/list")
    public String list(ModelMap model, HttpSession session){
//        UserDAO dao = new UserDAO();
//        model.addAttribute("USERS", dao.getAll());
        if (session.getAttribute("USERNAME") == null){
            return "redirect:/login";
        }
        model.addAttribute("USERS", userService.findAll());
        return "view-user";
    }

    @RequestMapping("/edit/{username}")
    public String edit(ModelMap model, @PathVariable(name = "username") String username) {
//        UserDAO dao = new UserDAO();
//        User u = dao.findByUsername(username);
        Optional<User> u = userService.findById(username);
        if (u.isPresent()) {
            model.addAttribute("USER", u.get());
        } else {
            model.addAttribute("USER", new User());
        }

        model.addAttribute("ACTION", "/saveOrUpdate");
        return "register-user";
    }

    @RequestMapping("/delete/{username}")
    public String delete(ModelMap model, @PathVariable(name = "username") String username) {
//        UserDAO dao = new UserDAO();
//        dao.delete(username);
//        model.addAttribute("USERS", dao.getAll());
        userService.deleteById(username);
        model.addAttribute("USERS", userService.findAll());
        return "view-user";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/checklogin")
    public String checkLogin(@RequestParam("username")String username, @RequestParam("password")String password, ModelMap model, HttpSession session) {

//        if (_userBean.getUsername().equals(username) && _userBean.getPassword().equals(password)) {
//            System.out.println("Login successful");
//            return "view-user";
//        } else {
//            System.out.println("Login failed");
//        }

        if (userService.checkLogin(username, password)) {
            System.out.println("Login successful");
            session.setAttribute("USERNAME", username);
            model.addAttribute("USERS", userService.findAll());
            return "view-user";
        } else {
            System.out.println("Login failed");
            model.addAttribute("ERROR", "Username or password is incorrect");
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("USERNAME");
        return "redirect:/login";
    }
}
