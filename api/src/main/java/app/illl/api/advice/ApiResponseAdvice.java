package app.illl.api.advice;

import app.illl.api.struct.io.ApiResponse;
import app.illl.api.struct.io.Response;
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

@ControllerAdvice
public class ApiResponseAdvice implements ResponseBodyAdvice<ApiResponse> {

    @Override
    public boolean supports(@NotNull MethodParameter methodParameter, @NotNull Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getGenericParameterType() instanceof Class<?>) {
            Class<?> responseClass = (Class<?>) methodParameter.getGenericParameterType();
            return ApiResponse.class.isAssignableFrom(responseClass);
        }
        return false;
    }

    @Override
    public ApiResponse beforeBodyWrite(ApiResponse apiResponse, @NotNull MethodParameter methodParameter, @NotNull MediaType mediaType, @NotNull Class<? extends HttpMessageConverter<?>> aClass, @NotNull ServerHttpRequest serverHttpRequest, @NotNull ServerHttpResponse serverHttpResponse) {
        if (apiResponse instanceof Response) {
            return setResponseVariables((Response) apiResponse);
        }
        @SuppressWarnings("unchecked")
        Response<ApiResponse> response = setResponseVariables(new Response<>());
        response.setData(apiResponse);
        return response;
    }

    private Response setResponseVariables(Response response) {
        response.setStatus(HttpStatus.OK);
        response.setTimestamp(ZonedDateTime.now(ZoneId.of("UTC")));
        return response;
    }

}
