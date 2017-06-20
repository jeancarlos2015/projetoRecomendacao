/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Filme;

/**
 *
 * @author jean
 */
public class DaoFilme implements Dao{
    Persistencia persistencia = new Persistencia();
    @Override
    public boolean salvar(Object objeto) {
        Filme filme = (Filme) objeto;
        return persistencia.executar("insert into filme(filmeId, titulo, genero) values('"+filme.getFilmeId()+"','"+filme.getTitulo()+"','"+filme.getGenero()+"')");
    }

    @Override
    public boolean delete(Object objeto) {
        Filme filme = (Filme) objeto;
        return  persistencia.executar("delete from filme where filmeId = '"+filme.getFilmeId()+"'");
    }
    
}
