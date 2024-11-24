package pzn.belajarspringwebmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pzn.belajarspringwebmvc.model.Partner;
//for testing Argument Resolver

@Controller
public class PartnerController {

    @GetMapping(path = "/partner/current")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    //we dont need add anything in param (like @RequestParam), cause mvc will be trace to resolver
    //which is the PartnerArgumentResolver
    public String getPartner(Partner partner) {
        return partner.getId() + " : " + partner.getName();
    }
}
