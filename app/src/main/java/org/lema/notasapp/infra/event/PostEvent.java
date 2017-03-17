package org.lema.notasapp.infra.event;

import org.lema.notasapp.domain.model.Post;

import java.util.List;

/**
 * Created by igor on 16/03/17.
 */

public class PostEvent {
    public List<Post> post;

    public PostEvent(List<Post> post) {
        this.post = post;
    }

    public PostEvent(Post post) {

    }
}
