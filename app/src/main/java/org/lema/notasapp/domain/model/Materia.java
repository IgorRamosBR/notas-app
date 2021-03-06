package org.lema.notasapp.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by leonardocordeiro on 09/01/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Materia {
    private String nome;
    private String ano;
    private String codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
