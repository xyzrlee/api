package app.illl.api.controller;

import com.google.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class IPTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getRequestIp() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/ip"))
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.ip").value("127.0.0.1"))
        ;
    }

    @Test
    public void getRequestIpForwarded() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/ip")
                        .header(HttpHeaders.X_FORWARDED_FOR, "127.0.1.1", "127.0.1.2", "127.0.1.3")
        )
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.ip").value("127.0.1.1"))
        ;
    }

}