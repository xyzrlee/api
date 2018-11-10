package app.illl.api.struct.io.dns.meta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private RRType type;
    @JsonProperty("TTL")
    private Long ttl;
    @JsonProperty("data")
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RRType getType() {
        return type;
    }

    public void setType(RRType type) {
        this.type = type;
    }

    public Long getTTL() {
        return ttl;
    }

    public void setTTL(Long ttl) {
        this.ttl = ttl;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
