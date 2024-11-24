package pzn.belajarspringwebmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pzn.belajarspringwebmvc.service.HelloService;

import java.io.IOException;
import java.util.Map;

@Controller
public class HelloController {
    //menambahkan request mapping (controller handler?)
//    @RequestMapping(path= "/hello")
//    public void helloWorld(HttpServletResponse response) throws IOException {
//        response.getWriter().println("Hello World");
//    }
    //bisa membuat banyak controller handler, tidak cuma 1

    //membuat baru yang diatas, menambahkan servlet request
//    @RequestMapping(path= "/hello")
//    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        String name = request.getParameter("name");
//        if (Objects.isNull(name)) {
//            name = "Guest";
//        }
//        response.getWriter().println("Hello " + name + "!");
//    }

    //update dengan hello service
//    @Autowired
//    private HelloService helloService;
//
//    @RequestMapping(path= "/hello")
//    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        String name = request.getParameter("name");
//        String responseBody = helloService.hello(name);
//        response.getWriter().println(responseBody);
//    }

    //update request methodnya menjadi get
    //sehingga jika request methodnya nanti menggunakan post, put, akan terjadi eror 405
//    @Autowired
//    private HelloService helloService;
//
//    @RequestMapping(path= "/hello", method = RequestMethod.GET)
//    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        String name = request.getParameter("name");
//        String responseBody = helloService.hello(name);
//        response.getWriter().println(responseBody);
//    }
    //sebenernya bisa dirubah dengan anotattion @GetMapping untuk get agar lebih singkat
    //nanti berubah jadi : @GetMapping(path= "/hello")
    //dan ada method lain
    //@PostMapping untuk post, @PutMapping, @PatchMapping, @DeleteMapping

    //menggunakan request param
    @Autowired
    private HelloService helloService;

    @GetMapping(path= "/hello")
    //jika required nya true, maka wajib user mengirimkan param yang diminta
    //sedangkan "name" adalah default jika tidak mengirim param
    public void helloWorld(@RequestParam(name = "name", required = false) String name,
                           HttpServletResponse response) throws IOException {

        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }

    //implementing model view with mustache
    @GetMapping(path = "/web/hello")
    //it return with model and view, not model, or anything
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name) {
        return new ModelAndView("hello", Map.of(
                "title", "Belajar view",
                "name", name
        ));
    }
}
