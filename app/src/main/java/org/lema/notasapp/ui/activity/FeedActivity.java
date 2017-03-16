package org.lema.notasapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import org.lema.notasapp.R;
import org.lema.notasapp.adapter.FeedAdapter;
import org.lema.notasapp.domain.model.Autor;
import org.lema.notasapp.domain.model.Post;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewFeed;
    private Toolbar mToolbar;
    private List<Post> mPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        preencheReferencias();

        preencheLista();

        preparaToolbar();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feed, menu);

        return true;
    }

    private void preencheReferencias() {
        mRecyclerViewFeed = (RecyclerView) findViewById(R.id.rv_feed);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_feed);
    }

    public void preencheLista()    {

        mPosts = new ArrayList<>();

        Post p1 = new Post();
        p1.setTexto("Prof. Alessandro Karppel Jordão contemplado no edital PAq1/2016, mais de trinta professores selecionados.");
        p1.setAutor(new Autor("Maxmiller Alves"));
        mPosts.add(p1);

        Post p2 = new Post();
        p2.setTexto("Prof. Alessandro Karppel Jordão contemplado no edital PAq1/2016, mais de trinta professores selecionados.");
        p2.setAutor(new Autor("Igor Ramos"));
        p2.setLinkParaFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRX7DtVZ8C3dRzQI7ZNj-_sGbyixlloKDUBDNpaal2YZxjFEGSjIA");
        mPosts.add(p2);

        mPosts.add(p1);
        mPosts.add(p2);


        mRecyclerViewFeed.setAdapter(new FeedAdapter(this, mPosts));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewFeed.setLayoutManager(layoutManager);
    }


    private void preparaToolbar(){
        mToolbar.setTitle("Notícias");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
