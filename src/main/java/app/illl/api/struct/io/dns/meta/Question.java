package app.illl.api.struct.io.dns.meta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
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

    public void setType(RRType type) {
        this.type = type;
    }
}
