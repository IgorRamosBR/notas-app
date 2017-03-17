package org.lema.notasapp.infra.retrofit.callback;

import org.greenrobot.eventbus.EventBus;
import org.lema.notasapp.domain.model.Post;
import org.lema.notasapp.infra.event.PostEvent;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by igor on 16/03/17.
 */

public class FeedCallback extends OAuthCallback<Post> {
    @Override
    public void handle(Call<Post> call, Response<Post> response) {
        EventBus.getDefault().post(new PostEvent(response.body()));
    }

}
