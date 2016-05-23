package wendll.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HelloControllerTest {
    final String BASE_URL = "http://localhost:8080/";
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testSayHelloWorld() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/").accept(MediaType.parseMediaType("text/html; charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html; charset=UTF-8"))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertThat(content, containsString("Spring"));

    }
}