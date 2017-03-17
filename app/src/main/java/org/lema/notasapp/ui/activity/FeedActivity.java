package org.lema.notasapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import org.greenrobot.eventbus.Subscribe;
import org.lema.notasapp.R;
import org.lema.notasapp.adapter.FeedAdapter;
import org.lema.notasapp.domain.model.Autor;
import org.lema.notasapp.domain.model.Post;
import org.lema.notasapp.domain.service.PostService;
import org.lema.notasapp.infra.app.NotasAppAplication;
import org.lema.notasapp.infra.dagger.component.PostComponent;
import org.lema.notasapp.infra.event.APIErrorEvent;
import org.lema.notasapp.infra.event.PostEvent;
import org.lema.notasapp.infra.event.ThrowableEvent;
import org.lema.notasapp.infra.listener.OnRetryListener;
import org.lema.notasapp.infra.oauth2.model.AccessToken;
import org.lema.notasapp.infra.retrofit.callback.FeedCallback;
import org.lema.notasapp.ui.utils.DialogMessage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FeedActivity extends OAuthActivity {

    private RecyclerView mRecyclerViewFeed;
    private Toolbar mToolbar;
    private List<Post> mPosts;

    @Inject
    PostService postService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        preencheReferencias();


        prepararInjecao();

        preparaToolbar();

        buscaNoticias();
    }

    private void prepararInjecao() {
        NotasAppAplication app = (NotasAppAplication) getApplication();
        PostComponent component = app.getPostComponent();
        component.inject(this);
    }

    @Subscribe
    public void handle(APIErrorEvent event) {
        Log.i("erro", event.error.toString());
        dialogUtils.show(new DialogMessage(event.error.getMessage(), new OnRetryListener() {
            @Override
            public void onRetry() {
                finish();
            }
        }));
    }

    @Subscribe
    public void onReceiveAccessToken(AccessToken accessToken) {
        buscaNoticias();
    }

    @Subscribe
    public void handle(ThrowableEvent event) {
        Log.i("erro", event.exception.toString());
        dialogUtils.show(new DialogMessage(event.exception.getMessage(), new OnRetryListener() {
            @Override
            public void onRetry() {
                buscaNoticias();
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feed, menu);

        return true;
    }

    private void buscaNoticias() {
        Log.i("erro", "buscando posts");
        postService.getPosts().enqueue(new FeedCallback());
    }

    private void preencheReferencias() {
        mRecyclerViewFeed = (RecyclerView) findViewById(R.id.rv_feed);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_feed);
    }

    @Subscribe
    public void preencheLista(PostEvent event)    {

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

        mPosts = event.post;

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
