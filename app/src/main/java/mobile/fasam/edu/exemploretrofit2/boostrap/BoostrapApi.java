package mobile.fasam.edu.exemploretrofit2.boostrap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BoostrapApi {
    final static String ENDPOINT = "https://jsonplaceholder.typicode.com/";

    static Retrofit retrofit;

    public static Retrofit getclient(){

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit;
    }
}
