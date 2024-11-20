package pzn.belajarspringwebmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FormControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getForm() throws Exception {
        mockMvc.perform(
                post("/form/hello")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "fin")
        ).andExpectAll(
                status().isOk(),
                //menambahkan header untuk mengetahui bener ngga si responsenya sesuai dengan yang kita inginkan
                header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                content().string(Matchers.containsString("Hello fin"))
        );
    }

    @Test
    void postForm() throws Exception {
        mockMvc.perform(
                post("/form/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "fin")
                        .param("birthDate", "2024-11-11")
                        .param("address", "jalan kesuksesan")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create Person with name : fin, birthDate : 2024-11-11, address : jalan kesuksesan"))
        );
    }

}