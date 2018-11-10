package app.illl.api.util;

import app.illl.api.exception.InternalServerErrorException;
import org.xbill.DNS.*;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class DNSUtils {

    private DNSUtils() {
    }

    public static List<Record> resolve(String name, Integer type) {
        try {
            Lookup lookup = new Lookup(name, type);
            Resolver resolver = new ExtendedResolver(ResolverConfig.getCurrentConfig().servers());
            resolver.setTimeout(1);
            lookup.setResolver(resolver);
            Record[] records = lookup.run();
            if (null == records) throw new InternalServerErrorException();
            return Arrays.asList(records);
        } catch (TextParseException | UnknownHostException e) {
            throw new InternalServerErrorException(e);
        }
    }

}
