/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Ligacao;

/**
 *
 * @author jean
 */
public class DaoLigacao implements Dao{
    private final Persistencia persistencia = new Persistencia();
    @Override
    public boolean salvar(Object objeto) {
        Ligacao ligacao = (Ligacao) objeto;
        return persistencia.executar("insert into ligacao(filmeId, imdbId, tmdbId) values('"+ligacao.getFilmeId()+"', '"+ligacao.getImdbId()+"', '"+ligacao.getTmdbId()+"')");
    }

    @Override
    public boolean delete(Object objeto) {
        Ligacao ligacao = (Ligacao) objeto;
        return persistencia.executar("delete from ligacao where tmdbid='"+ligacao.getTmdbId()+"'");
    }
    
}
