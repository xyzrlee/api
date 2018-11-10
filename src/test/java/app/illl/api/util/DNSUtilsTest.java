package app.illl.api.util;

import app.illl.api.struct.io.dns.meta.RRType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Record;

import java.util.List;

public class DNSUtilsTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testResolve() {
        List<Record> recordList = DNSUtils.resolve("apple.com", RRType.A.getValue());
        logger.info("recordList:{}", recordList);
    }

}
