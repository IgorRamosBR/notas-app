package org.lema.notasapp.delegate;

/**
 * Created by leonardocordeiro on 22/07/15.
 */
public interface MostrarNotasDelegate {

    public void lidaComRetorno(String json);

    public void lidaComErro(Exception e);
}