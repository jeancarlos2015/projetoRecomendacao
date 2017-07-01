/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Genre;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class DaoGenreTest {
    
    public DaoGenreTest() {
    }

    /**
     * Test of salvar method, of class DaoGenre.
     */
    
    public void testSalvar_Object() {
        Genre genre = new Genre("131256","teste");
        Dao dao = new DaoGenre();
        assertTrue(dao.salvar(genre));
    }

    /**
     * Test of delete method, of class DaoGenre.
     */
    
    public void testDelete() {
    }

    /**
     * Test of existe method, of class DaoGenre.
     */
    
    public void testExiste() {
    }

    /**
     * Test of salvar method, of class DaoGenre.
     */
    
    public void testSalvar_List() {
    }
    @Test
    public void testBuscar(){
        DaoGenre dao = new DaoGenre();
        System.out.println(dao.buscar("1"));
    }
}
