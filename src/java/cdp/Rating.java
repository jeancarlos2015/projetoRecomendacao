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
public class Rating extends Item{
    private String userId="0";
    private String movieId="0";
    private float rating=0;
    private String timestamp="0";
    private float media=0;
    private float similaridade=0;
    private float ratingMenosMedia=0;
    
    /**
     * @return the similaridade
     */
    public float getSimilaridade() {
        return similaridade;
    }

    /**
     * @param similaridade the similaridade to set
     */
    public void setSimilaridade(float similaridade) {
        this.similaridade = similaridade;
    }

    /**
     * @return the media
     */
    public float getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(float media) {
        this.media = media;
    }
    public Rating(){}
    
    public Rating(String classificacao){
        expr(classificacao);
    }
    public void expr(String classificacao){
        String[] dado = classificacao.split(",");
        if(dado.length==4){
            userId = dado[0].trim();
            movieId = dado[1].trim();
            this.rating = Float.parseFloat(dado[2].trim());
            timestamp = dado[3];
        }else if (dado.length==3){
            userId = dado[0].trim();
            movieId = dado[1].trim();
            this.rating = Float.parseFloat(dado[2].trim());
            timestamp = "000";
        }else if(dado.length==2){
            userId = dado[0].trim();
            movieId = dado[1].trim();
            this.rating = 0;
            timestamp = "000";
        }else {
            userId = dado[0].trim();
            movieId = "1";
            this.rating = 0;
            timestamp = "000";
        }
        
    }
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return the rating
     */
    
    public Float getRating() {
        return rating;
    }
    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = Float.parseFloat(rating.trim());
    }
    
    public void setRating(Float rating) {
        this.rating = rating;
    }

    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String[] getAtributos() {
        String[] atributos = {"rating","userid","movieid","times_tamp", "media"};
        return atributos;
    }
    public void setMedia(String media){
        this.media = Float.parseFloat(media.trim());
    }

    /**
     * @return the ratingMenosMedia
     */
    public float getRatingMenosMedia() {
        return ratingMenosMedia;
    }

    /**
     * @param ratingMenosMedia the ratingMenosMedia to set
     */
    public void setRatingMenosMedia(float ratingMenosMedia) {
        this.ratingMenosMedia = ratingMenosMedia;
    }

    @Override
    public boolean equals(Object objeto){
        Rating o = (Rating) objeto;
        return userId.equals(o.getUserId());
    }
}
