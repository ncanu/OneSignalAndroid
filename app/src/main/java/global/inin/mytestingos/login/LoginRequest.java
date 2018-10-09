package global.inin.mytestingos.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginRequest {

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    @JsonProperty
    private String playerId;

    @JsonProperty
    private Long appId;
}
