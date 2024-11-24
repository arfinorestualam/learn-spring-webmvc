package pzn.belajarspringwebmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pzn.belajarspringwebmvc.model.CreateAddressRequest;
import pzn.belajarspringwebmvc.model.CreatePersonRequest;
import pzn.belajarspringwebmvc.model.CreateSocialMediaRequest;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setFirstName("Test");
        request.setMiddleName("Test");
        request.setLastName("Test");
        request.setEmail("test@test.com");
        request.setPhoneNumber("1234567890");
        request.setAddress(new CreateAddressRequest());
        request.getAddress().setCity("Test");
        request.getAddress().setCountry("Test");
        request.getAddress().setPostalCode("Test");
        request.getAddress().setStreet("Test");
        request.setHobbies(List.of("code", "read"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("Facebook", "fb.me/"));
        request.getSocialMedias().add(new CreateSocialMediaRequest("Instagram", "instagram.me/"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isOk(),
                //for check if the json same
                content().json(jsonRequest)
        );
    }

    //Test for request body is not valid
    @Test
    void createPersonValidationError() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setMiddleName("Test");
        request.setLastName("Test");

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest(),
                //testing error handler
                content().string(Matchers.containsString("Validation Error"))
        );
    }
}