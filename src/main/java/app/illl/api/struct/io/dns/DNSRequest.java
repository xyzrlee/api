package app.illl.api.struct.io.dns;

import app.illl.api.struct.io.ApiRequest;
import app.illl.api.struct.io.dns.meta.RRType;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

public class DNSRequest extends ApiRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("Type")
    private RRType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RRType getType() {
        return type;
    }

    public void setType(String name) {
        if (StringUtils.isNumeric(name)) {
            Integer value = Integer.parseInt(name);
            RRType rrType = RRType.queryByValue(value);
            if (null != rrType) {
                this.type = rrType;
                return;
            }
        }
        this.type = RRType.queryByName(name);
    }

}
