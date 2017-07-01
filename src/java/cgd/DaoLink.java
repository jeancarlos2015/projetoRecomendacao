/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Link;

/**
 *
 * @author jean
 */
public class DaoLink implements Dao{
    private final Persistencia persistencia = new Persistencia();
    @Override
    public boolean salvar(Object objeto) {
        if(objeto==null){return false;}
        Link ligacao = (Link) objeto;
        return persistencia.executar("insert into link(movieId, imdbld, tmdbld) values("+ligacao.getMovieId()+", "+ligacao.getImdbId()+", "+ligacao.getTmdbId()+")");
    }

    @Override
    public boolean delete(Object objeto) {
        Link ligacao = (Link) objeto;
        return persistencia.executar("delete from link where tmdbld="+ligacao.getTmdbId()+"");
    }

    @Override
    public boolean existe(Object objeto) {
        Link link = (Link) objeto;
        String comando="select movieid from link where movieid="+link.getMovieId();
        String[] result = persistencia.executarSelecao(comando).split(";");
        for(String info:result){
            if(info.equals(link.getMovieId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
