package epalafox.com.curso.WebService;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by epalafox on 12/08/2017.
 */

public class WebServiceClient {
    private static RestClient api;
    public static RestClient getApi()
    {
        if(api == null)
        {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(350, TimeUnit.SECONDS)
                    .writeTimeout(350,TimeUnit.SECONDS)
                    .readTimeout(350,TimeUnit.SECONDS).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://dropthemic.azurewebsites.net/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            api = retrofit.create(RestClient.class);
        }
        return api;
    }
}
