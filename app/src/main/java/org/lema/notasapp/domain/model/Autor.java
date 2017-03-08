package org.lema.notasapp.domain.model;

import java.net.URI;

/**
 * Created by igor on 08/03/17.
 */
public class Autor {

    private String nome;
    private String descricao;
    private URI foto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public URI getFoto() {
        return foto;
    }

    public void setFoto(URI foto) {
        this.foto = foto;
    }
}
