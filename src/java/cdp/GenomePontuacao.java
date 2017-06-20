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
public class GenomePontuacao {
    private int movieId;
    private int tagId;
    private double relevance;
    
    public GenomePontuacao(String info){
        String[] dado = info.split(",");
        movieId = Integer.parseInt(dado[0]);
        tagId = Integer.parseInt(dado[1]);
        relevance = Integer.parseInt(dado[2]);
    }

    /**
     * @return the movieId
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * @return the tagId
     */
    public int getTagId() {
        return tagId;
    }

    /**
     * @param tagId the tagId to set
     */
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    /**
     * @return the relevance
     */
    public double getRelevance() {
        return relevance;
    }

    /**
     * @param relevance the relevance to set
     */
    public void setRelevance(double relevance) {
        this.relevance = relevance;
    }
}
