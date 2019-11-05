package mobile.fasam.edu.exemploretrofit2.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import mobile.fasam.edu.exemploretrofit2.R;
import mobile.fasam.edu.exemploretrofit2.adapter.PostAdapter;
import mobile.fasam.edu.exemploretrofit2.boostrap.BoostrapApi;
import mobile.fasam.edu.exemploretrofit2.representacao.Posts;
import mobile.fasam.edu.exemploretrofit2.resource.PostService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    EditText txtId;
    EditText txtUserId;
    EditText txtTitulo;
    EditText txtBoddy;
    ListView listView;


    // Criar referencia para consumir serviço
    PostService postService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    private void carregarDados(){

        // fazer injeção de dependencias da interface
        postService = BoostrapApi.getclient().create(PostService.class);

        Call<List<Posts>> get = postService.get();

        get.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                //Recuperar a lista de posts
                List<Posts> posts = response.body();

                //pegar referencia da listview
                listView = findViewById(R.id.listviewPost);

                PostAdapter adapter =
                        new PostAdapter(getApplicationContext(), posts);

                //Fazer "bind" com a listView;
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
        
    }
    public void adicionar(View view) {
        carregarDados();
    }
}
