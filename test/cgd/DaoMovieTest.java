/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Movie;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Ferramenta;

/**
 *
 * @author jean
 */
public class DaoMovieTest {
    
    public DaoMovieTest() {
    }

    /**
     * Test of salvar method, of class DaoMovie.
     */
    
    public void testSalvar() {
        String sentenca = "131256,'Feuer, Eis & Dosenbier (2002)',Comedy";
        Movie filme  = new Movie(sentenca);
        Dao dao = new DaoMovie();
        assertTrue(dao.salvar(filme));
    }

    /**
     * Test of delete method, of class DaoMovie.
     */
   
    public void testDelete() {
        Movie filme  = new Movie("131256,'Feuer, Eis & Dosenbier (2002)',Comedy");
        Dao dao = new DaoMovie();
        assertTrue(dao.delete(filme));
    }
    
    public void testExiste(){
        DaoMovie dao = new DaoMovie();
        Movie movie = new Movie();
        movie.setMovieId("96");
        System.out.println(dao.existe(movie));
    }
    @Test
    public void testbuscar(){
        DaoMovie dao = new DaoMovie();
        System.out.println(dao.buscar("1"));
    }
}
