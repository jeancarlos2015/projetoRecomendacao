/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Genre;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jean
 */
public class DaoGenre implements Dao{
    Persistencia persistencia = new Persistencia();
    @Override
    public boolean salvar(Object objeto) {
        if(objeto==null){return false;}
        Genre genre = (Genre) objeto;
        return persistencia.executar("insert into genre(movieid, name) values("+genre.getMovieId()+",'"+genre.getNome()+"')");
    }

    @Override
    public boolean delete(Object objeto) {
        Genre genre = (Genre) objeto;
        return persistencia.executar("delete from genre where genreid="+genre.getGenreId());
    }

    @Override
    public boolean existe(Object objeto) {
        Genre genre = (Genre) objeto;
        String comando="select genreid from genre where genreid="+genre.getGenreId();
        String[] result = persistencia.executarSelecao(comando).split(";");
        for(String info:result){
            if(info.equals(genre.getGenreId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> buscar(String id) {
        String[] result = persistencia.executarSelecaoA("select name from genre where movieid="+id, "name").split(";");
        return Arrays.asList(result);
    }

   
    
}
