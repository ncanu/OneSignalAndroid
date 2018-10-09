package global.inin.mytestingos.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class JsonReponseConverterFactory extends Converter.Factory
{
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(final Type type, Annotation[] annotations, Retrofit retrofit)
    {

        Type envelopeType = new ParameterizedType() {
            public Type getRawType() {
                return JsonResponse.class;
            }

            public Type getOwnerType() {
                return null;
            }

            public Type[] getActualTypeArguments() {
                return new Type[] { type };
            }
        };

        Converter<ResponseBody, JsonResponse> delegate = retrofit.nextResponseBodyConverter(this, envelopeType, annotations);
        return new JsonResponseConverter(delegate);
    }
}