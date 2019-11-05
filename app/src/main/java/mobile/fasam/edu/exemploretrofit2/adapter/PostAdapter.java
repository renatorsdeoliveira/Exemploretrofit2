package mobile.fasam.edu.exemploretrofit2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mobile.fasam.edu.exemploretrofit2.R;
import mobile.fasam.edu.exemploretrofit2.representacao.Posts;

public class PostAdapter extends BaseAdapter {

    Context context;
    List<Posts> colecao;
    LayoutInflater inflter;

    public PostAdapter(final Context applicationContext,
                         final List<Posts> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;
    }

    @Override
    public int getCount() {
        return this.colecao!=null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.colecao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        // inflate the layout for each list row
        //'Infla' o layout(pega a referencia) para ser trabalhada
        //no método
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_post,
                            parent, false);
        }

        //pega  o objeto corrente da lista
        Posts posts = (Posts)getItem(position);

        // Declarar campos para preencher o layout item
        TextView userId, title;

        //Pegando referencia do layout
        userId = view.findViewById(R.id.txtUserId);
        title = view.findViewById(R.id.txtTitle);

        userId.setText(String.valueOf(posts.getUserId()));
        title.setText(posts.getTitle());

        return view;
    }
}
