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
public class GenomeTag extends Item{
    private String tagId;
    private String tag;
    
    public GenomeTag(String info){
        String[] dado=info.split(",");
        tagId = dado[0].trim();
        tag = dado[1];
    }

    /**
     * @return the tagId
     */
    public String getTagId() {
        return tagId;
    }

    /**
     * @param tagId the tagId to set
     */
    public void setTagId(String tagId) {
        this.tagId = tagId;
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

    @Override
    public String[] getAtributos() {
        String[] atributos = {"tagid","tag"};
        return atributos;
    }
}
