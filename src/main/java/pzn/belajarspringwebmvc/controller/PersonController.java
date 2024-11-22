package pzn.belajarspringwebmvc.controller;

//binding class, without using request param
//because request param is pain if you add more than 2 param

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pzn.belajarspringwebmvc.model.CreatePersonRequest;

@Controller
public class PersonController {

    @PostMapping(path = "/person",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    //using annotation @ModelAttribute for many param.
    //you should make model so it can be attach with the annotation
    public String createPerson(@ModelAttribute CreatePersonRequest request) {
        return "Success " +
                request.getFirstName() + " " +
                request.getMiddleName() + " " +
                request.getLastName() +
                " email: " + request.getEmail() +
                " phone: " + request.getPhoneNumber();
    }
}
