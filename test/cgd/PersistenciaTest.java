/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Link;
import cdp.Movie;
import cdp.Rating;
import cdp.Tag;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        String[] links = persistencia.lerArquivo("C:\\Users\\jean\\Desktop\\ml-20m\\links.csv").split(";");
        Dao dao = new DaoLink();
        for(String info:links){
            Link link = new Link(info);
            dao.salvar(link);
        }
        
        assertTrue(true);
    }
    
    public List<Movie> listFilmes(){
        List<Movie> movies = new ArrayList();
        Movie movie1 = new Movie();
        movie1.setMovieId("500001");
        movie1.setTitle("Teste teste 1");
        
        Movie movie2 = new Movie();
        movie2.setTitle("Teste teste 2");
        movie2.setMovieId("500002");
        
        Movie movie3 = new Movie();
        movie3.setTitle("Teste teste 3");
        movie3.setMovieId("500003");
        
        Movie movie4 = new Movie();
        movie4.setTitle("Teste teste 4");
        movie4.setMovieId("500004");
        
        Movie movie5 = new Movie();
        movie5.setTitle("Teste teste 5");
        movie5.setMovieId("500005");
        
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        return movies;
    }
    
    public List<Rating> listRatingTestAlice(){
       List<Rating> lista = new ArrayList();
       Rating r = new Rating();
       r.setRating((float)5);
       r.setMovieId("500001");
       
       Rating r2 = new Rating();
       r2.setMovieId("500002");
       r2.setRating((float)3);
       
       Rating r3 = new Rating();
       r3.setMovieId("500003");
       r3.setRating((float)4);
       
       Rating r4 = new Rating();
       r2.setMovieId("500004");
       r4.setRating((float)4);
       
       Rating r5 = new Rating();
       r5.setMovieId("500005");
       r5.setRating((float)0);
       lista.add(r);
       lista.add(r2);
       lista.add(r3);
       lista.add(r4);
       lista.add(r5);
       for(Rating buffer:lista){
           buffer.setUserId("30005");
       }
       return lista;
   }
    public List<Rating> listRatingTestUser1(){
       List<Rating> lista = new ArrayList();
       Rating r = new Rating();
       r.setRating((float)3);
       r.setMovieId("500001");
       
       Rating r2 = new Rating();
       r2.setMovieId("500002");
       r2.setRating((float)1);
       
       Rating r3 = new Rating();
       r3.setMovieId("500003");
       r3.setRating((float)2);
       
       Rating r4 = new Rating();
       r2.setMovieId("500004");
       r4.setRating((float)3);
       
       Rating r5 = new Rating();
       r5.setMovieId("500005");
       r5.setRating((float)3);
       lista.add(r);
       lista.add(r2);
       lista.add(r3);
       lista.add(r4);
       lista.add(r5);
       for(Rating buffer:lista){
           buffer.setUserId("30006");
       }
       return lista;
   }
    
    public void testdeletar(){
        DaoRating daoRating = new DaoRating();
        DaoMovie daoMovies = new DaoMovie();
        List<Rating> ratings1 = listRatingTestUser1();
        List<Rating> ratingsA = listRatingTestAlice();
        List<Movie> movies = listFilmes();
        
        for(Rating rat1:ratings1){
            daoRating.delete(rat1);
        }
        for(Rating rata:ratingsA){
            daoRating.delete(rata);
        }
        for(Movie movie:movies){
            daoMovies.delete(movie);
        }
    }
    
    
    public void testsalvar(){
        DaoRating daoRating = new DaoRating();
        DaoMovie daoMovies = new DaoMovie();
        List<Rating> ratings1 = listRatingTestUser1();
        List<Rating> ratingsA = listRatingTestAlice();
        List<Movie> movies = listFilmes();
        for(Movie movie:movies){
            for(Rating rat1:ratings1){
                rat1.setMovieId(movie.getMovieId());
                daoRating.salvar(rat1);
            }
            for(Rating rata:ratingsA){
                rata.setMovieId(movie.getMovieId());
                daoRating.salvar(rata);
            }
        }
        
        
        
    }
    public void testLerArquivoMovies() {
        Persistencia persistencia = new Persistencia();
        String[] movies = persistencia.lerArquivo("C:\\Users\\jean\\Desktop\\ml-20m\\movies.csv").split(";");
        Dao dao = new DaoMovie();
        int contador=0;
        for(String info:movies){
            System.out.println(contador);
            Movie movie = new Movie(info);
            if(!dao.existe(movie)){
                contador++;
                dao.salvar(movie);
            }
            
        }
        assertTrue(true);
    }
    
    public void testLerArquivoTags() {
        Persistencia persistencia = new Persistencia();
        String[] tags = persistencia.lerArquivo("C:\\Users\\jean\\Desktop\\ml-20m\\tags.csv").split(";");
        Dao dao = new DaoTag();
        for(String info:tags){
            Tag tag = new Tag(info);
            dao.salvar(tag);
        }
        assertTrue(true);
    }
    
    
    public void testLerArquivoRating() {
        Persistencia persistencia = new Persistencia();
        String[] ratings = persistencia.lerArquivo("C:\\Users\\jean\\Desktop\\ml-20m\\ratings.csv").split(";");
        Dao dao = new DaoRating();
        int contador=0;
        for(String info:ratings){
            System.out.println(contador);
            if(contador>65607){
                Rating rating = new Rating(info);
                dao.salvar(rating);
            }
            contador++;
        }
        assertTrue(true);
    }
    
    public void testLerArquivoFilmes() {
        Persistencia persistencia = new Persistencia();
        persistencia.lerArquivo("C:\\Users\\jean\\Desktop\\ml-20m\\movies.csv");
    }
    
    public void testExpressaoRegularAno(){
        String linha="131256,'Feuer, Eis & Dosenbier (2002)',Comedy";
        String padrao="/(.+?/)";
        Pattern p = Pattern.compile(padrao);
        Matcher m = p.matcher(linha);
        if(m.find()){
            System.out.println(m.group());
        }
    }
    
    public void testExpressaoRegularNome(){
        String linha="22,Copycat (1995),Crime|Drama|Horror|Mystery|Thriller";
        String padrao="[A-Z].+\\s";
        Pattern p = Pattern.compile(padrao);
        Matcher m = p.matcher(linha);
        if(m.find()){
            System.out.println(m.group());
        }
    }
    
    public void testExpressaoRegularNome1(){
        String linha="131256,'Feuer, Eis & Dosenbier (2002)',Comedy";
        String padrao="[[A-Z]+[a-z]*\\s]+";
        Pattern p = Pattern.compile(padrao);
        Matcher m = p.matcher(linha);
        if(m.find()){
            System.out.println(m.group());
        }
    }
    
    public void testExpressaoRegularId(){
        String linha="22,Copycat (1995),Crime|Drama|Horror|Mystery|Thriller";
        String padrao="\\d+";
        Pattern p = Pattern.compile(padrao);
        Matcher m = p.matcher(linha);
        if(m.find()){
            System.out.println(m.group());
        }
    }
    
    public void testExpressaoRegularGenero(){
        String linha="22,Copycat (1995),Crime|Drama|Horror|Mystery|Thriller";
        String padrao="[a-z]*";
        Pattern p = Pattern.compile(padrao);
        Matcher m = p.matcher(linha);
        if(m.find()){
            System.out.println(m.group());
        }
    }

    public void criaBancoTag(){
        Persistencia persistencia = new Persistencia();
        assertTrue(persistencia.executar("create table Tag(tagId SERIAL, userId int not null primary key, movieId int, tag varchar(50), time_stamp varchar(50));"));
    }
    
    public void criaBancoRatings(){
        Persistencia persistencia = new Persistencia();
        assertTrue(persistencia.executar("create table Ratings(ratingId SERIAL, userId int, movieId int, time_stamp varchar(50));"));
    }
    
    public void criaBancoMovie(){
        Persistencia persistencia = new Persistencia();
        assertTrue(persistencia.executar("create table Movie(movieId int not null primary key, title varchar(50), year varchar(50), author varchar(50));"));
    }
    
    public void criaBancoGenre(){
        Persistencia persistencia = new Persistencia();
        assertTrue(persistencia.executar("create table Genre(genreId SERIAL, movieId int, name varchar(50));"));
    }
    
    public void criaBancoLink(){
        Persistencia persistencia = new Persistencia();
        assertTrue(persistencia.executar("create table Link(linkId SERIAL, imdbld int, tmdbld int, movieId int);"));
    }
    
    public void criChaveExtrangeiras(){
        Persistencia persistencia = new Persistencia();
        boolean result = persistencia.executar("alter table Tag add foreign key(movieId) REFERENCES movie(movieId);");
        result = result && persistencia.executar("alter table Ratings add foreign key(movieId) REFERENCES movie(movieId);");
        result = result && persistencia.executar("alter table Link add foreign key(movieId) REFERENCES movie(movieId);");
        result = result && persistencia.executar("alter table Genre add foreign key(movieId) REFERENCES movie(movieId);");
        assertTrue(result);
    }
    
    public void testPersistencia(){
        Persistencia persistencia = new Persistencia();
        int userid=1;
        String[] result = persistencia.executarSelecaoA("select c.userid, c.rating-m.media as media from  rating as c, MediaClassificaoesUsuarios as m where c.userid=m.userid and c.userid="+userid,"userid,media").split(";");
        for(String str:result){
            String[] dado = str.split(",");
            Rating rating = new Rating();
            rating.setUserId(dado[0]);
            rating.setRating(dado[1]);
            System.out.println(rating.getUserId()+" "+rating.getRating());
        }
    }
    public void testCriaBanco(){
        Persistencia persistencia = new Persistencia();
        assertTrue(persistencia.criaBanco());
    }
    
    public void testgetUsuarios(){
        int movieid=1;
        Persistencia persistencia = new Persistencia();
        String comando="select userid from rating where movieid="+movieid;
        String[] result = persistencia.executarSelecao(comando).split(";");
        List<Integer> usuariosLista = new ArrayList();
        for(String str:result){
            if(!str.equals("null")){
                System.out.println(Integer.parseInt(str));
            }
        }
        
    }
    
    public void testobtercolunas(){
        Persistencia p = new Persistencia(new Rating());
        String[] dado = p.executarSelecaoA("select r.userid , r.movieid , r.rating from rating as r, movie as m where r.userid=1 and r.movieid= m.movieid","userid,movieid,rating").split(";");
        for(String str:dado){
            System.out.println(str);
        }
        
    }
}
