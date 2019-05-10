package app.illl.api.advice;

import app.illl.api.constant.AdviceOrder;
import app.illl.api.struct.io.ApiResponse;
import app.illl.api.struct.io.PackedResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
@ControllerAdvice
@Order(AdviceOrder.API_RESPONSE_ADIVCE)
public class ApiResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@NotNull MethodParameter methodParameter, @NotNull Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getGenericParameterType() instanceof Class<?>) {
            Class<?> responseClass = (Class<?>) methodParameter.getGenericParameterType();
            return ApiResponse.class.isAssignableFrom(responseClass);
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object object, @NotNull MethodParameter methodParameter, @NotNull MediaType mediaType, @NotNull Class<? extends HttpMessageConverter<?>> aClass, @NotNull ServerHttpRequest serverHttpRequest, @NotNull ServerHttpResponse serverHttpResponse) {
        PackedResponse<Object> packedResponse = new PackedResponse<>();
        packedResponse.setStatus(HttpStatus.OK);
        packedResponse.setTimestamp(ZonedDateTime.now(ZoneId.of("UTC")));
        packedResponse.setData(object);
        return packedResponse;
    }

}
