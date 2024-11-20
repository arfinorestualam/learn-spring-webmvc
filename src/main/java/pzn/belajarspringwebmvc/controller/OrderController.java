package pzn.belajarspringwebmvc.controller;

//learn make path variable

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    //tambahkan variable pada string path
    @GetMapping(path = "/orders/{orderId}/products/{productId}")
    @ResponseBody
    public String order(
            //pakai annotation path variable untuk mengisi variable di url
            @PathVariable("orderId") String orderId,
            @PathVariable("productId") String productId
    ) {
       return "Order : " + orderId + ", Product : " + productId;
    }
}
