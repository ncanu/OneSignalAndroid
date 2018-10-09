package global.inin.mytestingos.retrofit;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CustomCallBack<T> implements Callback<T>
{

    @Override
    @SuppressWarnings("unchecked")
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response)
    {
        ResponseBody errorBody = response.errorBody();
        if (!response.isSuccessful() && errorBody != null)
        {
            try
            {
                ObjectMapper mapper = new ObjectMapper();
                JsonResponse<HashMap<String,String>> error = mapper.readValue(errorBody.bytes(), JsonResponse.class);
                if(error == null )
                {
                    onError(response.code(), null, null);
                }
                else
                {
                    onError(response.code(), error.getMessage(), error.getData());
                }
            }
            catch (IOException ignored){ }
        }
        else
        {
            onResponse(response.body());
        }
    }

    public abstract void onResponse(T response);

    public abstract void onError(int code, String error, HashMap<String,String> details);

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t)
    {
        onError(0,t.getLocalizedMessage(), null);
    }


}
