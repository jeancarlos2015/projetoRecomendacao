/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Genre;
import cdp.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class DaoMovie implements Dao{
    Persistencia persistencia = new Persistencia();
    @Override
    public boolean salvar(Object objeto) {
        if(objeto==null){return false;}
        Movie filme = (Movie) objeto;
        boolean result=persistencia.executar("insert into movie(movieId, title, year) values('"+filme.getMovieId()+"','"+filme.getTitle()+"','"+filme.getYear()+"')");
        if(result){
            Dao dao = new DaoGenre();
            for(Genre genre:filme.getGenres()){
                if(!dao.salvar(genre)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Object objeto) {
        Movie filme = (Movie) objeto;
        return  persistencia.executar("delete from movie where movieId = '"+filme.getMovieId()+"'");
    }

    @Override
    public boolean existe(Object objeto) {
        try{
            Movie movie = (Movie) objeto;
        String comando="select movieid from movie where movieid="+movie.getMovieId();
        String[] result = persistencia.executarSelecaoA(comando,"movieid").split(";");
        for(String info:result){
            if(info.equals(movie.getMovieId())){
                return true;
            }
        }
        return false;
        }catch(NullPointerException ex){
            return false;
        }
        
    }

    @Override
    public Object buscar(String id) {
        String[] result = persistencia.executarSelecaoA("select *from movie where movieid="+id, "movieid,title,year").split(";");
        for(String str:result){
            String[] dado = str.split(",");
            if(dado.length==3){
                Movie movie = new Movie();
                movie.setMovieId(dado[0]);
                movie.setTitle(dado[1]);
                movie.setYear(dado[2]);
                return movie;
            }
        }
        return null;
    }
    
  
    
}
