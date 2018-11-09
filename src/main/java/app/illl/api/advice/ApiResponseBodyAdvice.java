package app.illl.api.advice;

import app.illl.api.struct.io.AbstractApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<AbstractApiResponse> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getGenericParameterType() instanceof Class<?>) {
            Class<?> responseClass = (Class<?>) methodParameter.getGenericParameterType();
            return AbstractApiResponse.class.isAssignableFrom(responseClass);
        }
        return false;
    }

    @Override
    public AbstractApiResponse beforeBodyWrite(AbstractApiResponse abstractApiResponse, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        abstractApiResponse.set_time(ZonedDateTime.now(ZoneId.of("UTC")));
        return abstractApiResponse;
    }

}
