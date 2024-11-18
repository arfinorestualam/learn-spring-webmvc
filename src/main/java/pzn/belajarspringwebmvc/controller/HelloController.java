package pzn.belajarspringwebmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HelloController {
    //menambahkan request mapping (controller handler?)
    @RequestMapping(path= "/hello")
    public void helloWorld(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello World");
    }
    //bisa membuat banyak controller handler, tidak cuma 1
}
