package pzn.belajarspringwebmvc.controller;

//binding class, without using request param
//because request param is pain if you add more than 2 param

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pzn.belajarspringwebmvc.model.CreatePersonRequest;

import java.util.List;

@Controller
public class PersonController {

//    @PostMapping(path = "/person",
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
//    )
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    //using annotation @ModelAttribute for many param.
//    //you should make model so it can be attach with the annotation
//    //same for @ModelAttribute, we just need add @Valid after the annotation, then add @NotBlank to model
//    public String createPerson(@ModelAttribute @Valid CreatePersonRequest request) {
//        //because the model become huge, we can sout the request:
//        System.out.println(request);
//
//        //with nested model, we dont need add the nested, the annotation deal with it
//        //so we can go to use like this:
//        return "Success " +
//                request.getFirstName() + " " +
//                request.getMiddleName() + " " +
//                request.getLastName() +
//                " email: " + request.getEmail() +
//                " phone: " + request.getPhoneNumber() +
//                " address " + request.getAddress().getStreet() +
//                " " + request.getAddress().getCity() +
//                " " + request.getAddress().getCountry() +
//                " " + request.getAddress().getPostalCode();
//        //example how to get reguler list and model list from modelattribut :
////                //to get regular list
////                request.getHobbies().get(0) +
////                //to get list with model
////                request.getSocialMedias().get(0).getName();
//    }

        //make new for binding result

        @PostMapping(path = "/person",
                consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
        )
        //using annotation @ModelAttribute for many param.
        //you should make model so it can be attach with the annotation
        //same for @ModelAttribute, we just need add @Valid after the annotation, then add @NotBlank to model
        public ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest request,
                                   //add binding result so we can run the controller and the error from validation is
                                   //in binding result
                                   BindingResult bindingResult) {

            // if invalid, the error will catch in here :
            List<FieldError> errors = bindingResult.getFieldErrors();
            if (!errors.isEmpty()) {

                errors.forEach(error -> System.out.println(error.getField() + " : " + error.getDefaultMessage()));

                return ResponseEntity.badRequest().body("You Send Invalid Data");
            }

            System.out.println(request);


            String response = "Success " +
                    request.getFirstName() + " " +
                    request.getMiddleName() + " " +
                    request.getLastName() +
                    " email: " + request.getEmail() +
                    " phone: " + request.getPhoneNumber() +
                    " address " + request.getAddress().getStreet() +
                    " " + request.getAddress().getCity() +
                    " " + request.getAddress().getCountry() +
                    " " + request.getAddress().getPostalCode();

            return ResponseEntity.ok(response);
        }
}
