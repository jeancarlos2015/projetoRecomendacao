/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Filme;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class DaoFilmeTest {
    
    public DaoFilmeTest() {
    }

    /**
     * Test of salvar method, of class DaoFilme.
     */
    @Test
    public void testSalvar() {
        Filme filme  = new Filme("131256,'Feuer, Eis & Dosenbier (2002)',Comedy");
        Dao dao = new DaoFilme();
        assertTrue(dao.salvar(filme));
    }

    /**
     * Test of delete method, of class DaoFilme.
     */
    @Test
    public void testDelete() {
        Filme filme  = new Filme("131256,'Feuer, Eis & Dosenbier (2002)',Comedy");
        Dao dao = new DaoFilme();
        assertTrue(dao.delete(filme));
    }
    
}
