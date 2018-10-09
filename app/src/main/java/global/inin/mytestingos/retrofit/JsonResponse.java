package global.inin.mytestingos.retrofit;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JsonResponse<T>
{
    @JsonProperty
    private boolean success;

    @JsonProperty
    private String message;

    @JsonProperty
    private T data;
}