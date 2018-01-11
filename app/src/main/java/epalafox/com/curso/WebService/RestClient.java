package epalafox.com.curso.WebService;

import java.util.List;

import epalafox.com.curso.Models.PostModel;
import epalafox.com.curso.Models.SessionModel;
import epalafox.com.curso.Models.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by epalafox on 12/08/2017.
 */

public interface RestClient {
    @GET("Users")
    Call<UserModel> getUser(@Header("Authorization") String webToken, @Query("id") int id);
    @POST("Users")
    Call<Void> postUser(@Body UserModel user);
    @GET("Authorization")
    Call<SessionModel> login(@Query("UserName") String username, @Query("Password") String password);
    @GET("Post")
    Call<List<PostModel>> getPosts(@Header("Authorization") String webToken);
}