package pzn.belajarspringwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

//learn request header
@Controller
public class HeaderController {

    @GetMapping(path = "/header/token")
    @ResponseBody
    // add request header as simple than servlet header
    public String headerToken(@RequestHeader(name = "X-TOKEN") String token) {
        if (token.equals("fin")) {
            return "OK";
        } else {
            return "ERROR";
        }
    }
}
