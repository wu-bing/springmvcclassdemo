package cn.smbms.controller;

import cn.smbms.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {

    List<User> list = null;

    public UserController(){
        list = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("admin");
        user1.setAddress("兰州安宁区教育");

        User user2 = new User();
        user2.setId(2);
        user2.setUserName("admin2");
        user2.setAddress("兰州安宁区教育2");

        list.add(user1);
        list.add(user2);
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /*@RequestMapping("/login")
    public String login(User user){
        if(user.getUserName().equals("admin") && user.getUserPassword().equals("123")){
            return "index";
        }
        return "login";
    }
*/
    @RequestMapping("/login")
    public String login(@RequestParam(value="userName",required = false) String userName,
                        @RequestParam(value="userPassword",required = false) String userPassword,
                        Model model){
        if(userName.equals("admin") && userPassword.equals("123")){
            model.addAttribute("list",list);
            return "index";
        }
        return "login";
    }

}
