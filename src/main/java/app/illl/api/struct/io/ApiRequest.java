package app.illl.api.struct.io;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiRequest {

    private ApiRequestCommons commons;

    public ApiRequestCommons getCommons() {
        return commons;
    }

    public void setCommons(ApiRequestCommons commons) {
        this.commons = commons;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

}
