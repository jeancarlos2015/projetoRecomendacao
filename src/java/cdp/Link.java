/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

/**
 *
 * @author jean
 */
public class Link extends Item{
    private String movieId="0";
    private String imdbId="0";
    private String tmdbId="0";
    
    public Link(){}
    public Link(String info){
        expr(info);
    }
    public void expr(String info){
        String[] dado = info.split(",");
        if(dado.length==3){
            movieId = dado[0].trim();
            imdbId = dado[1].trim();
            tmdbId = dado[2].trim();
        }else if(dado.length==2){
            movieId = dado[0].trim();
            imdbId = dado[1].trim();
            tmdbId = "000";
        }else{
            movieId = dado[0].trim();
            imdbId = "000";
            tmdbId = "000";
        }
        
    }
    /**
     * @return the movieId
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     * @return the imdbId
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * @param imdbId the imdbId to set
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     * @return the tmdbId
     */
    public String getTmdbId() {
        return tmdbId;
    }

    /**
     * @param tmdbId the tmdbId to set
     */
    public void setTmdbId(String tmdbId) {
        this.tmdbId = tmdbId;
    }

    @Override
    public String[] getAtributos() {
        String[] atributos = {"linkid","imdbld","tmdbld","movieid"};
        return atributos;
    }
    
    
}
