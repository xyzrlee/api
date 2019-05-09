package app.illl.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class URLExpandTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void urlExpandWithoutRedirect() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/url/expand")
                        .param("url", "www.gstatic.com/generate_204")
        )
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.url").value("http://www.gstatic.com/generate_204"));
    }

    @Test
    public void urlExpandWithRedirect() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/url/expand")
                        .param("url", "apple.com")
        )
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.url").value("https://www.apple.com/"));
    }

}