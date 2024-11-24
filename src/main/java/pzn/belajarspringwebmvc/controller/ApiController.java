package pzn.belajarspringwebmvc.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pzn.belajarspringwebmvc.model.CreatePersonRequest;

@Controller
public class ApiController {

    @PostMapping(
            path = "/api/person",
            //cause we set up the consumes and produces using json value
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    //then in here, we dont need String as Response, we can just set it to the model
    //adding on request body annotation @Valid for automatic check is @NotBlank is true or not
    public CreatePersonRequest createPerson(@RequestBody @Valid CreatePersonRequest request) {
        return request;
    }
}
