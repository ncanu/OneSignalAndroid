package global.inin.mytestingos.retrofit;


import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * Created by Dev1 on 12/6/2017.
 */

public class RetrofitClient
{
    private static String BASE_URL = "https://obelius.inin.global/api/";
    private static Retrofit RETROFIT;

    public static Retrofit getClient()
    {
        if(RETROFIT == null)
        {
            TokenVM tokenVM = new TokenVM();
//            tokenVM.getToken().observeForever(
//                    token ->
//            {
//                if(token!= null) { RETROFIT = create(token); }
//            }
//
//            );

            tokenVM.getToken().observeForever(new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    if(s!= null) { RETROFIT = create(s); }
                }
            });

            RETROFIT = create(tokenVM.getToken().getValue());
        }
        return RETROFIT;
    }

    private static Retrofit create(String token)
    {
        final String myToken = token;
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        httpBuilder.connectTimeout(120, TimeUnit.SECONDS);
        httpBuilder.readTimeout(120, TimeUnit.SECONDS);

        if( token!= null)
        {
//            httpBuilder.addInterceptor(chain -> {
//                Request request =  chain.request().newBuilder().header("Authorization", "Bearer" + token ).build();
//                return chain.proceed(request);
//            });

            httpBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request =  chain.request().newBuilder().header("Authorization", "Bearer" + myToken ).build();
                    return chain.proceed(request);
                }
            });
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,  false);

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpBuilder.build())
                .addConverterFactory(new JsonReponseConverterFactory())
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
    }


}
