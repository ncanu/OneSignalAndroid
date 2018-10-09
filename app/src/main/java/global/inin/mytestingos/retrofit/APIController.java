package global.inin.mytestingos.retrofit;

import global.inin.mytestingos.login.LoginRequest;
import global.inin.mytestingos.login.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIController {

    @POST("user/login/4")
    Call<LoginResponse> postLogin(@Body LoginRequest request);

//    @GET("cybersource/public/key")
//    Call<String> getPublicKey();

//    @POST("cybersource/creditcard")
//    Call<String> sendEncryptedMessage(@Body String encryptedMessage);


}
