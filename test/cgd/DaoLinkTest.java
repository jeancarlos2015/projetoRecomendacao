/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Link;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class DaoLinkTest {
    
    public DaoLinkTest() {
    }

    /**
     * Test of salvar method, of class DaoLink.
     */
    @Test
    public void testSalvar() {
        Dao dao = new DaoLink();
        Link ligacao = new Link("5,0113041,11862");
        boolean result=dao.salvar(ligacao);
        assertTrue(result);
    }
    
    public void testDelete(){
        Dao dao = new DaoLink();
        Link ligacao = new Link("131256,0358273,69");
        boolean result=dao.delete(ligacao);
        assertTrue(result);
    }
}
