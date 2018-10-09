package global.inin.mytestingos.retrofit;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class JsonResponseConverter<T> implements Converter<ResponseBody, T>
{

    final Converter<ResponseBody, JsonResponse<T>> delegate;

    public JsonResponseConverter(Converter<ResponseBody, JsonResponse<T>> delegate)
    {
        this.delegate = delegate;
    }

    @Override
    public T convert(ResponseBody value) throws IOException
    {
        JsonResponse<T> envelope = delegate.convert(value);
        return envelope.getData();
    }
}
