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
public class Classificacao {
    private int usuarioId;
    private int filmeId;
    private float classificacao;
    private String timestamp;
    
    public Classificacao(String classificacao){
        String[] dado = classificacao.split(",");
        usuarioId = Integer.parseInt(dado[0].trim());
        filmeId = Integer.parseInt(dado[1].trim());
        this.classificacao = Float.parseFloat(dado[2].trim());
        timestamp = dado[3];
    }

    /**
     * @return the usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * @return the filmeId
     */
    public int getFilmeId() {
        return filmeId;
    }

    /**
     * @param filmeId the filmeId to set
     */
    public void setFilmeId(int filmeId) {
        this.filmeId = filmeId;
    }

    /**
     * @return the classificacao
     */
    public float getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(float classificacao) {
        this.classificacao = classificacao;
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
    
}
