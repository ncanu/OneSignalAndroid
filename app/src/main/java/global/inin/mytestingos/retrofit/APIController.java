package global.inin.mytestingos.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIController {

    @GET("cybersource/public/key")
    Call<String> getPublicKey();

    @POST("cybersource/creditcard")
    Call<String> sendEncryptedMessage(@Body String encryptedMessage);


}
