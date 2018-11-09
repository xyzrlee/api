package app.illl.api.struct.io;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiResponse {

    private ApiResponseHeader header;

    public ApiResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ApiResponseHeader header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

}
