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
public class Ligacao {
    private String filmeId;
    private String imdbId;
    private String tmdbId;
    
    public Ligacao(String info){
        String[] dado = info.split(",");
        filmeId = dado[0].trim();
        imdbId = dado[1].trim();
        tmdbId = dado[2].trim();
    }
    
    /**
     * @return the filmeId
     */
    public String getFilmeId() {
        return filmeId;
    }

    /**
     * @param filmeId the filmeId to set
     */
    public void setFilmeId(String filmeId) {
        this.filmeId = filmeId;
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
    
    
}
