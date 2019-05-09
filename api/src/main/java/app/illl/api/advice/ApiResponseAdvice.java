package app.illl.api.advice;

import app.illl.api.struct.io.ApiResponse;
import app.illl.api.struct.io.PackedResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
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
public class ApiResponseAdvice implements ResponseBodyAdvice<ApiResponse> {

    @Override
    public boolean supports(@NotNull MethodParameter methodParameter, @NotNull Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getGenericParameterType() instanceof Class<?>) {
            Class<?> responseClass = (Class<?>) methodParameter.getGenericParameterType();
            return ApiResponse.class.isAssignableFrom(responseClass) && !PackedResponse.class.isAssignableFrom(responseClass);
        }
        return false;
    }

    @Override
    public ApiResponse beforeBodyWrite(ApiResponse apiResponse, @NotNull MethodParameter methodParameter, @NotNull MediaType mediaType, @NotNull Class<? extends HttpMessageConverter<?>> aClass, @NotNull ServerHttpRequest serverHttpRequest, @NotNull ServerHttpResponse serverHttpResponse) {
        PackedResponse<ApiResponse> packedResponse = new PackedResponse<>();
        packedResponse.setStatus(HttpStatus.OK);
        packedResponse.setTimestamp(ZonedDateTime.now(ZoneId.of("UTC")));
        packedResponse.setData(apiResponse);
        return packedResponse;
    }

}
