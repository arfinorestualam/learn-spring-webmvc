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
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success John Doe 2 email: john.doe@gmail.com phone: 123" +
                        " address jln g buk ak 456"))
        );

    }

}