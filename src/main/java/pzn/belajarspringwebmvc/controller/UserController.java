package pzn.belajarspringwebmvc.controller;

//using this controller if session is store or not

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import pzn.belajarspringwebmvc.model.User;

@Controller
public class UserController {

    @GetMapping(path = "/user/current")
    @ResponseBody
    //using annotation @SessionAttribute to check data that stored
    //the name on annotation must be same with data we store when we register it on auth
    public String getUser(@SessionAttribute(name = "user") User user) {
        return "Hello " + user.getUsername();
    }
}
