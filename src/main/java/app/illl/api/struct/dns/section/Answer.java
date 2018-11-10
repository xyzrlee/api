package app.illl.api.struct.dns.section;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("TTL")
    private int ttl;
    @JsonProperty("data")
    private String data;

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

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
