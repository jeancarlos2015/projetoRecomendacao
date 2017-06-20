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
public class Tag {
    private String usuarioId;
    private String filmeId;
    private String tag;
    private String timestamp;
    
    public Tag(String info){
        String[] dado = info.split(",");
        usuarioId = dado[0].trim();
        filmeId = dado[1].trim();
        tag = dado[2];
        timestamp = dado[3];
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
     * @return the usuarioId
     */
    public String getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
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
    
}
