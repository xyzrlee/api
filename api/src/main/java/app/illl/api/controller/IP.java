/*
 * MIT License
 *
 * Copyright (c) 2018 Ricky Li
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

import app.illl.api.struct.io.ApiResponse;
import com.google.common.net.HttpHeaders;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class IP {

    private static final String IP_UNKNOWN = "unknown";

    @GetMapping(path = "/ip")
    public IPResponse getRequestIp(HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getHeader(HttpHeaders.X_FORWARDED_FOR);
        log.debug("{}: {}", HttpHeaders.X_FORWARDED_FOR, ip);
        if (null != ip) {
            String[] ips = StringUtils.split(ip, ',');
            ip = ips[0].trim();
        }
        if (!isValidIP(ip)) {
            ip = httpServletRequest.getRemoteAddr().trim();
        }
        IPResponse ipResponse = new IPResponse();
        ipResponse.setIp(ip);
        return ipResponse;
    }

    private boolean isValidIP(String ip) {
        return ip != null && !StringUtils.isBlank(ip) && !StringUtils.equals(IP_UNKNOWN, ip);
    }

    private static class IPResponse implements ApiResponse {
        @Getter
        @Setter
        private String ip;
    }

}
