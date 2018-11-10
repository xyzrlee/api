package app.illl.api.controller;

import app.illl.api.struct.io.dns.DNSRequest;
import app.illl.api.struct.io.dns.DNSResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class DNS {

    private static final String URL_CLOUDFLARE = "https://cloudflare-dns.com/dns-query";

    @GetMapping(path = "/dns/cloudflare")
    public DNSResponse cloudflare(DNSRequest dnsRequest, HttpServletResponse response) {

        DNSResponse dnsResponse = new DNSResponse();
        return dnsResponse;
    }

}
