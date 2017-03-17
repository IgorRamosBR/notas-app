package org.lema.notasapp.infra.app;

import android.app.Application;

import org.lema.notasapp.domain.model.Post;
import org.lema.notasapp.infra.dagger.component.BoletimComponent;
import org.lema.notasapp.infra.dagger.component.DaggerBoletimComponent;
import org.lema.notasapp.infra.dagger.component.DaggerPostComponent;
import org.lema.notasapp.infra.dagger.component.PostComponent;
import org.lema.notasapp.infra.dagger.module.BoletimModule;
import org.lema.notasapp.infra.dagger.module.PostModule;

/**
 * Created by leonardocordeiro on 15/11/16.
 */

public class NotasAppAplication extends Application {

    private BoletimComponent boletimComponent;
    private PostComponent postComponent;

    // Multidex support
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }

    @Override
    public void onCreate() {
        super.onCreate();

        boletimComponent = DaggerBoletimComponent.builder()
                                     .boletimModule(new BoletimModule(this)).build();

        postComponent = DaggerPostComponent.builder()
                                    .postModule(new PostModule((this))).build();
    }

    public BoletimComponent getBoletimComponent() {
        return boletimComponent;
    }

    public PostComponent getPostComponent() {return postComponent;}
}
