/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Ligacao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class DaoLigacaoTest {
    
    public DaoLigacaoTest() {
    }

    /**
     * Test of salvar method, of class DaoLigacao.
     */
    @Test
    public void testSalvar() {
        Dao dao = new DaoLigacao();
        Ligacao ligacao = new Ligacao("40819,0358273,69");
        boolean result=dao.salvar(ligacao);
        assertTrue(result);
    }
    @Test
    public void testDelete(){
        Dao dao = new DaoLigacao();
        Ligacao ligacao = new Ligacao("40819,0358273,69");
        boolean result=dao.delete(ligacao);
        assertTrue(result);
    }
}
