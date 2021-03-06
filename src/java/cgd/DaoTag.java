/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Tag;
import cdp.Tag;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class DaoTag implements Dao{
    private final Persistencia persistencia = new Persistencia();
    @Override
    public boolean salvar(Object objeto) {
        if(objeto==null){return false;}
        Tag tag = (Tag) objeto;
        return  persistencia.executar("insert into tag(userId, movieId, tag, time_stamp) values('"+tag.getUserId()+"','"+tag.getMovieId()+"','"+tag.getTag()+"', '"+tag.getTimestamp()+"')");
    }

    @Override
    public boolean delete(Object objeto) {
        Tag tag = (Tag) objeto;
        return persistencia.executar("delete from tag where userId = '"+tag.getUserId()+"'");
    }

    @Override
    public boolean existe(Object objeto) {
        Tag tag = (Tag) objeto;
        String comando="select movieid from tag where movieid="+tag.getMovieId();
        String[] result = persistencia.executarSelecao(comando).split(";");
        for(String info:result){
            if(info.equals(tag.getMovieId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
