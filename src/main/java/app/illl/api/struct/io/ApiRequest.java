package app.illl.api.struct.io;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiRequest {

    private ApiRequestHeader header;

    public ApiRequestHeader getHeader() {
        return header;
    }

    public void setHeader(ApiRequestHeader header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

}
