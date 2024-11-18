package pzn.belajarspringwebmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Objects;

@Controller
public class HelloController {
    //menambahkan request mapping (controller handler?)
//    @RequestMapping(path= "/hello")
//    public void helloWorld(HttpServletResponse response) throws IOException {
//        response.getWriter().println("Hello World");
//    }
    //bisa membuat banyak controller handler, tidak cuma 1

    //membuat baru yang diatas, menambahkan servlet request
    @RequestMapping(path= "/hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        if (Objects.isNull(name)) {
            name = "Guest";
        }
        response.getWriter().println("Hello " + name + "!");
    }
}
