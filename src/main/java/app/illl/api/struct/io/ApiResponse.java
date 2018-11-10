package app.illl.api.struct.io;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiResponse {

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
