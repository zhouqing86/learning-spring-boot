package wendll.controllers;

import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;


public class IntegrationTest {

    RestTemplate template = new TestRestTemplate();

    @Test
    public void testIndex() throws Exception {
        String body = template.getForEntity("http://localhost:8080/", String.class).getBody();
        assertThat(body, containsString("Spring"));
    }

}