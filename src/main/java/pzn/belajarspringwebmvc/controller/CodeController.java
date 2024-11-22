package pzn.belajarspringwebmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//make response status

@Controller
public class CodeController {

    @DeleteMapping(path = "products/{id}")
    @ResponseBody
    //gunakan anotation response status untuk membuat response status yang kita inginkan
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Integer id) {
        //delete database
    }
}
