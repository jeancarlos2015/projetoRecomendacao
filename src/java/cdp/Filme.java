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
public class Filme extends Item{
    private String filmeId;
    private String titulo;
    private String genero;
    
    public Filme(String info){
        String[] dado = info.split(",");
        filmeId = dado[0];
        titulo = dado[1];
        genero = dado[2];
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
