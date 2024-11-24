package pzn.belajarspringwebmvc.controller;

//learn response entity as change response body etc

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pzn.belajarspringwebmvc.model.User;

@Controller
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            //add Http servlet response because we using servlet for cookie
            HttpServletResponse servletResponse,
            //add http servlet request to handle session
            HttpServletRequest servletRequest
    ) {
        if("fin".equals(username) && "123".equals(password)) {
            //this is how to add session
            //fun fact session is necessary because it store in 1 application
            //if we run more than 1, it cant be store for other.
            HttpSession session = servletRequest.getSession(true);
            session.setAttribute("user", new User(username));
            //add cookie using servlet
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            servletResponse.addCookie(cookie);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ERROR", HttpStatus.UNAUTHORIZED);
        }
    }

    //how to get cookie or read cookie
    //using anotation @CookieValue to read cookie
    @GetMapping("/auth/user")
    public ResponseEntity<String> getUser(@CookieValue("username") String username) {
        return new ResponseEntity<>("Hello " + username, HttpStatus.OK);
    }
}
