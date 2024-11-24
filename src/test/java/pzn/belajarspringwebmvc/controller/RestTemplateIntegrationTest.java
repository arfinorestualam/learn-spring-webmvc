package pzn.belajarspringwebmvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private RestTemplate restTemplate;


    //test rest template
    @Test
    void addTodoRestTemplate() {
        String url = "http://localhost:" + port + "/todos";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("todo", "Belajar Spring");

        //make request entity
        RequestEntity<MultiValueMap<String, Object>> request = new RequestEntity<>(form, headers, HttpMethod.POST, URI.create(url));

        //and then exchange to get what response
        ResponseEntity<List<String>> response = restTemplate.exchange(request, new ParameterizedTypeReference<>() {});

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(Objects.requireNonNull(response.getBody()).contains("Belajar Spring"));

    }

    @Test
    void getTodoRestTemplate() {
        String url = "http://localhost:" + port + "/todos";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        //make request entity
        RequestEntity<MultiValueMap<String, Object>> request = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));

        //and then exchange to get what response
        ResponseEntity<List<String>> response = restTemplate.exchange(request, new ParameterizedTypeReference<>() {});

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(Objects.requireNonNull(response.getBody()).contains("Belajar Spring"));

    }
}
