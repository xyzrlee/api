package app.illl.api.struct.io;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class ApiResponse {

    @JsonProperty("_p")
    private ApiResponseCommons commons;

    public ApiResponseCommons getCommons() {
        return commons;
    }

    public void setCommons(ApiResponseCommons commons) {
        this.commons = commons;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

}
