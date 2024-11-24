package pzn.belajarspringwebmvc.controller;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "John")
                        .param("middleName", "Doe")
                        .param("lastName", "2")
                        .param("email", "john.doe@gmail.com")
                        .param("phoneNumber", "123")
                //adding param for address, cause it's nested, we can call it with . example: address.city
                        .param("address.street", "jln g")
                        .param("address.city", "buk")
                        .param("address.country", "ak")
                        .param("address.postalCode", "456")
                //adding param for regular list (the variable and then index):
                        .param("hobbies[0]", "code")
                        .param("hobbies[1]", "read")
                //adding param for model list (the model, then index, and then the variable):
                        .param("socialMedias[0].name", "facebook")
                        .param("socialMedias[0].location", "fb/me.com")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success John Doe 2 email: john.doe@gmail.com phone: 123" +
                        " address jln g buk ak 456"))
        );

    }

    //make validation error test
    @Test
    void createPersonValidationError() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("middleName", "Doe")
                        .param("lastName", "2")
                        //adding param for address, cause it's nested, we can call it with . example: address.city
                        .param("address.street", "jln g")
                        .param("address.city", "buk")
                        .param("address.country", "ak")
                        .param("address.postalCode", "456")
                        //adding param for regular list (the variable and then index):
                        .param("hobbies[0]", "code")
                        .param("hobbies[1]", "read")
                        //adding param for model list (the model, then index, and then the variable):
                        .param("socialMedias[0].name", "facebook")
                        .param("socialMedias[0].location", "fb/me.com")
        ).andExpectAll(
                status().isBadRequest()
        );

    }

}