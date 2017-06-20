/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Tag;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class DaoTagTest {
    
    public DaoTagTest() {
    }

    /**
     * Test of salvar method, of class DaoTag.
     */
    @Test
    public void testSalvar() {
        Dao dao = new DaoTag();
        Tag tag = new Tag("50798,6874,visceral,1273666358");
        assertTrue(dao.salvar(tag));
    }

    /**
     * Test of delete method, of class DaoTag.
     */
    @Test
    public void testDelete() {
        Dao dao = new DaoTag();
        Tag tag = new Tag("50798,6874,visceral,1273666358");
        assertTrue(dao.delete(tag));
    }
    
}
