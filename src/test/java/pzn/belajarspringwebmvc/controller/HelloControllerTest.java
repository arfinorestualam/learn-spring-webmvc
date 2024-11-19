package pzn.belajarspringwebmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

//membuat mock mvc, unit test yang tidak perlu lagi kita mengetes di browser
//testing semua controller yang ada menggunakan mock mvc
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //menggunakan mockMvc untuk get request helloGuest() dan helloName()

    @Test
    void helloGuest() throws Exception {
        mockMvc.perform(get("/hello")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Guest!"))
        );
    }

    @Test
    void helloName() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name", "fin")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello fin!"))
        );
    }

    @Test
    void testPostMethod() throws Exception {
        mockMvc.perform(
                post("/hello").queryParam("name", "fin")
        ).andExpectAll(
                status().isMethodNotAllowed()
        );
    }
}
