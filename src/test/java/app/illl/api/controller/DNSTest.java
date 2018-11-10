package app.illl.api.controller;

import app.illl.api.struct.io.dns.meta.RRType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DNSTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MockMvc mvc;

    @Test
    public void queryTestA() throws Exception {
        MvcResult mvcResult = this.mvc.perform(
                MockMvcRequestBuilders.get("/dns")
                        .param("name", "apple.com")
                        .param("type", RRType.A.getValue().toString()))
                .andReturn();
        Assert.assertEquals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
    }

    @Test
    public void queryTestAAAA() throws Exception {
        MvcResult mvcResult = this.mvc.perform(
                MockMvcRequestBuilders.get("/dns")
                        .param("name", "apple.com")
                        .param("type", RRType.AAAA.getValue().toString()))
                .andReturn();
        Assert.assertEquals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
    }

    @Test
    public void queryTestNXDOMAIN() throws Exception {
        MvcResult mvcResult = this.mvc.perform(
                MockMvcRequestBuilders.get("/dns")
                        .param("name", "aoiuwhbnoiwenoeirhbn")
                        .param("type", RRType.A.getValue().toString()))
                .andReturn();
        Assert.assertEquals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
    }

}
