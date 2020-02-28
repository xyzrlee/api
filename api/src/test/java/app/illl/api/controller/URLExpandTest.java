/*
 * MIT License
 *
 * Copyright (c) 2020 Ricky Li
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

    @Test
    public void urlExpandUnknownHost() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/url/expand")
                        .param("url", "asoinbe.bnoew")
        )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andDo(MockMvcResultHandlers.print())
        ;
    }

    @Test
    public void urlExpandConnectError() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/url/expand")
                        .param("url", "172.16.0.1")
        )
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
        ;
    }

    @Test
    public void urlExpandUrlUnset() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/url/expand")
        )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
        ;
    }

    @Test
    public void urlExpandIllegalUrl() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/url/expand")
                        .param("url", "tcp://172.16.10.3")
        )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
        ;
    }

}