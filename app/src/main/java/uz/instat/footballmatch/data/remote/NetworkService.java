package uz.instat.footballmatch.data.remote;

import com.chuckerteam.chucker.api.ChuckerCollector;
import com.chuckerteam.chucker.api.ChuckerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uz.instat.footballmatch.App;

import static java.util.Collections.emptySet;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "https://api.instat.tv/";
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okhttpclient())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public ApiService getApiService() {
        return mRetrofit.create(ApiService.class);
    }

    private static OkHttpClient okhttpclient() {
        return new OkHttpClient.Builder()
                .addInterceptor(
                        new ChuckerInterceptor.Builder(App.context)
                                .collector(new ChuckerCollector(App.context))
                                .maxContentLength(250000L)
                                .redactHeaders(emptySet())
                                .alwaysReadResponseBody(false)
                                .build()
                )
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}
