package pzn.belajarspringwebmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pzn.belajarspringwebmvc.model.HelloRequest;
import pzn.belajarspringwebmvc.model.HelloResponse;

@Controller
public class BodyController {

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(
            path = "/body/hello",
            //meminta json, dan mengembalikan json
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    //menggunakan anotation @RequestBody sebagai request
    public String hello(@RequestBody String body) throws JsonProcessingException {
        HelloRequest request = objectMapper.readValue(body, HelloRequest.class);
        HelloResponse response = new HelloResponse();
        response.setHello("Hello " + request.getName());
        return objectMapper.writeValueAsString(response);
    }
}
