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
public class Genre extends Item{
    private String genreId;
    private String movieId;
    private String nome;
    
    public Genre(String movieId, String nome){
        this.movieId = movieId;
        this.nome = nome;
    }
    public Genre(){
    }

    /**
     * @return the genreId
     */
    public String getGenreId() {
        return genreId;
    }

    /**
     * @param genreId the genreId to set
     */
    public void setGenreId(String genreId) {
        this.genreId = genreId;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String[] getAtributos() {
        String[] atributos = {"genreid","movieid","name"};
        return atributos;
    }
    
    
}
