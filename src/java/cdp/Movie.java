/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

import java.util.ArrayList;
import java.util.List;
import util.Ferramenta;

/**
 *
 * @author jean
 */
public class Movie extends Item{
    private String movieId;
    private String title;
    private List<Genre> genres = new ArrayList<>();
    private String year="";
    
    public Movie(){}
    
    public Movie(String info){
        expr1(info);
    }
    public void expr1(String sentenca){
        String[] dado = sentenca.split(",");
        if(dado.length>2){
            String id = dado[0];
            String generos = dado[dado.length-1];
            String info="";
            for(int index=1;index<dado.length-1;index++){
                info+=dado[index].replace("\"", "").replace("'", "");
            }
            movieId = id;
            title = info;
            genres = toListasgeneros(generos);
            year = Ferramenta.exprAno(info, "\\d{4,4}");
        }else{
            movieId = dado[0];
            String info="";
            for(int index=1;index<dado.length;index++){
                info+=dado[index].replace("\"", "").replace("'", "");
            }
            title = info;
            year="0000";
        }
        
    }
    public void expr(String info){
        info = info.replace("\"", "");
        info = info.replace("\'", "");
        
        String[] dado = info.split(",");
        movieId = Ferramenta.exprAno(info, "\\d+");
        title = Ferramenta.exprAno(info, "[A-Z].+\\s");
        String result = Ferramenta.exprAno(info,"\\d{4,4}");
        String result2 = Ferramenta.exprAno(dado[1], "\\d{4,4}");
        if(!result.equals(result2)){
            year = Ferramenta.exprAno(info,"\\d{4,4}");
        }
        
    }
    private List<Genre> toListasgeneros(String dado){
        List<Genre> listas = new ArrayList();
        if(dado.contains("|")){
            dado = dado.replace("|", ",");
            String[] Strgenres =  dado.split(",");
            for(String genre1:Strgenres){
                Genre gen = new Genre(movieId,genre1);
                listas.add(gen);
            }
        }else{
            listas.add(new Genre(movieId, dado));
        }
        return listas;
    }
    /**
     * @return the genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
    
    
    
    /**
     * @return the movieId
     */
    public String getMovieId() {
        return movieId.replace(",", "");
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title.replace(",", "");
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String[] getAtributos() {
        String[] atributos = {"movieid","title","year"};
        return atributos;
    }

    /**
     * @return the genre
     */
   
    
}
