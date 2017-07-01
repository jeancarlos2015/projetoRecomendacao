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
public class Tag extends Item{
    private String userId="";
    private String movieId="";
    private String tag="";
    private String timestamp="000";
    
    public Tag(){};
    public Tag(String info){
        expr(info);
    }
   public void expr(String info){
       String[] dado = info.split(",");
        if(dado.length>2){
            userId = dado[0].trim();
            movieId = dado[1].trim();
            for(int index=2;index<dado.length-1;index++){
                tag+=dado[index].replace("\"", "").replace("'", "");
            }
            timestamp = dado[dado.length-1];
        }else if (dado.length==2){
            userId = dado[0].trim();
            movieId =dado[1].trim();
            timestamp = "0000";
        }else{
            userId = dado[0].trim();
            movieId ="1";
            timestamp = "0000";
        }
        
   }

   
    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
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

    @Override
    public String[] getAtributos() {
        String[] atributos = {"tagid","userid","movieid","tag","time_stamp"};
        return atributos;
    }
    
}
