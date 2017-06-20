/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Tag;

/**
 *
 * @author jean
 */
public class DaoTag implements Dao{
    private final Persistencia persistencia = new Persistencia();
    @Override
    public boolean salvar(Object objeto) {
        Tag tag = (Tag) objeto;
        return  persistencia.executar("insert into tag(usuarioId, filmeId, tag, time_stamp) values('"+tag.getUsuarioId()+"','"+tag.getFilmeId()+"','"+tag.getTag()+"', '"+tag.getTimestamp()+"')");
    }

    @Override
    public boolean delete(Object objeto) {
        Tag tag = (Tag) objeto;
        return persistencia.executar("delete from tag where usuarioId = '"+tag.getUsuarioId()+"'");
    }
    
}
