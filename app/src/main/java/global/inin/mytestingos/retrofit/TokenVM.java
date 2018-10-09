package global.inin.mytestingos.retrofit;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import lombok.Getter;

public class TokenVM extends ViewModel
{
    @Getter
    private MutableLiveData<String> token;

    public TokenVM()
    {
        token = new MutableLiveData<>();
    }

}
