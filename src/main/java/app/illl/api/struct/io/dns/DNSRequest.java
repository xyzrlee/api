package app.illl.api.struct.io.dns;

import app.illl.api.struct.io.ApiRequest;

public class DNSRequest extends ApiRequest {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
