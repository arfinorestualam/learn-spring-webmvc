package pzn.belajarspringwebmvc.controller;


import jakarta.servlet.http.Cookie;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginSuccess() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "fin")
                        .param("password", "123")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK")),
                //checking for cookie
                cookie().value("username", Matchers.is("fin"))
        );
    }

    @Test
    void loginFailed() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "bro")
                        .param("password", "123")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string(Matchers.containsString("ERROR"))
        );
    }

    @Test
    void getCookieUser() throws Exception {
        mockMvc.perform(
           get("/auth/user")
                   .cookie(new Cookie("username", "fin"))

        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello fin"))
        );
    }

}