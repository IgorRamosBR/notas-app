package org.lema.notasapp.domain.model;

import android.nfc.Tag;

import java.net.URI;
import java.util.Calendar;
import java.util.List;

/**
 * Created by igor on 08/03/17.
 */

public class Post {

    private String titulo;
    private String mensagem;
    private Calendar dataPostagem;
    private URI imagemLink;
    private Autor autor;
    private List<Like> likes;
    private List<TagPost> tag;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Calendar getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Calendar dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public URI getImagemLink() {
        return imagemLink;
    }

    public void setImagemLink(URI imagemLink) {
        this.imagemLink = imagemLink;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<TagPost> getTag() {
        return tag;
    }

    public void setTag(List<TagPost> tag) {
        this.tag = tag;
    }
}
