/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

import org.junit.Test;
import static org.junit.Assert.*;
import util.Ferramenta;

/**
 *
 * @author jean
 */
public class FilmeTest {
    
    public FilmeTest() {
    }
    
    public void testExpressaoParentes(){
        System.out.println("Sentenca parenteses");
        String sentenca = "294,\"Perez Family, The (1995)\",Comedy|Romance";
        String[] dado = sentenca.split(",");
        String id = dado[0];
        String generos = dado[dado.length-1];
        String info="";
        for(int index=1;index<dado.length-1;index++){
            info+=dado[index].replace("\"", "").replace("'", "");
        }
        System.out.println(id+","+info+","+generos+","+ Ferramenta.exprAno(info, "\\d{4,4}"));
    }
    @Test
    public void testFilme(){
        System.out.println("TESTE 1");
        Movie filme = new Movie("1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy");
        System.out.println(filme.getMovieId()+","+filme.getTitle()+","+filme.getYear());
        for(Genre genre:filme.getGenres()){
            System.out.println(genre.getNome());
        }
    }
    
    @Test
    public void testFilmeGenero(){
        System.out.println("TESTE 2");
        Movie filme = new Movie("1613,Star Maps (1997),Drama");
        System.out.println(filme.getMovieId()+","+filme.getTitle()+","+filme.getYear());
        for(Genre genre:filme.getGenres()){
            System.out.println(genre.getNome());
        }
    }
    
    @Test
    public void testFilmeGenero1(){
        System.out.println("TESTE 3");
        Movie filme = new Movie("2716,Ghostbusters (a.k.a. Ghost Busters)");
        System.out.println(filme.getMovieId()+","+filme.getTitle()+","+filme.getYear());
        for(Genre genre:filme.getGenres()){
            System.out.println(genre.getNome());
        }
    }
}
