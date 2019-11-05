package mobile.fasam.edu.exemploretrofit2.resource;

import java.util.List;

import mobile.fasam.edu.exemploretrofit2.representacao.Posts;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostService {


    //Envia um post para o servidor
    @POST("posts")
    Call<Posts> post(@Body Posts posts);


    //Recupera um post baseado em in id
    @GET("posts/{id}")
    Call<Posts> get(@Path("id") Integer id);


    //Tras a lista de posts
    @GET("posts")
    Call<List<Posts>> get();


    @PUT("posts/{id}")
    Call<Posts> put(@Path("id") Integer id, @Body Posts posts);

    @PATCH("posts/{id}")
    Call<Posts> patch(@Path("id") Integer id, @Body Posts posts);

    //deleta o post baseado no id
    @DELETE("posts/{id}")
    Call<Void> delete(@Path("id") Integer id);

}
