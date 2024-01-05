package api.restful.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Response<T> {
    private boolean success;
    private String message;
    private T data;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
