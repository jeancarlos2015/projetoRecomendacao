/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class PersistenciaTest {
    
    

    /**
     * Test of lerArquivo method, of class Persistencia.
     */
   
    public void testLerArquivoLinks() {
        Persistencia persistencia = new Persistencia();
        persistencia.lerArquivo("C:\\Users\\jean\\Desktop\\ml-20m\\links.csv");
    }
    
 
    public void testLerArquivoTags() {
        Persistencia persistencia = new Persistencia();
        persistencia.lerArquivo("C:\\Users\\jean\\Desktop\\ml-20m\\tags.csv");
    }
    @Test
    public void testLerArquivoFilmes() {
        Persistencia persistencia = new Persistencia();
        persistencia.lerArquivo("C:\\Users\\jean\\Desktop\\ml-20m\\movies.csv");
    }
}
