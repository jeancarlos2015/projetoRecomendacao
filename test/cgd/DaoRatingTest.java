/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Rating;
import cgt.PreProcessamento;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class DaoRatingTest {

    private DaoRating dao = new DaoRating();

    public DaoRatingTest() {
    }

    public void testSalvarRating() {
        Rating rating = new Rating("1,131256,2.5,1260759144");
        assertTrue(dao.salvar(rating));
    }

    public void testExisteRating() {
        Rating rating = new Rating("1,131256,2.5,1260759144");
        assertTrue(dao.existe(rating));
    }

    public void testgetRating() {
        Rating rating = dao.getRating(1, 31);
        System.out.println(rating.getMovieId());
        System.out.println(rating.getRating());
        System.out.println(rating.getTimestamp());
        System.out.println(rating.getUserId());
    }

    private float somatorio(List<Float> lista) {
        float somatorio = 0;
        for (float valor : lista) {
            somatorio += valor;
        }
        return somatorio;
    }

    private List<Float> calcDiferencaMediaLista(List<Float> lista, float media) {
        List<Float> itens = new ArrayList();
        for (Float item : lista) {
            itens.add(item - media);
        }
        return itens;
    }

    public float maior(List<Float> lista) {
        float maior = lista.get(0);
        for (float va : lista) {
            if (maior < va) {
                maior = va;
            }
        }
        return maior;
    }

    private void normalizarLista(List<Rating> listaA, List<Rating> listaB) {

        if (listaA.size() > listaB.size()) {
//            float media = maior(listaB);
            while (listaA.size() > listaB.size()) {
                listaB.add(new Rating());
            }
        }
        if (listaA.size() < listaB.size()) {
//            float media = maior(listaA);
            while (listaB.size() > listaA.size()) {
                listaA.add(new Rating());
            }
        }
    }

    private float calcMedia(List<Float> lista) {
        float soma = somatorio(lista);
        return soma / lista.size();
    }

    private List<Float> produtoEntreLista(List<Float> listaA, List<Float> listaB) {
        List<Float> listac = new ArrayList();
        for (int index = 0; index < listaA.size(); index++) {
            listac.add(listaA.get(index) * listaB.get(index));
        }
        return listac;
    }

    private List<Float> calcListaQuadrado(List<Float> lista) {
        List<Float> result = new ArrayList();
        for (int index = 0; index < lista.size(); index++) {
            result.add((float) Math.pow(lista.get(index), 2));
        }
        return result;
    }

//    public float similaridade(Integer user1, Integer user2) {
//
//        List<Float> itensA = dao.obterClassificacoes(user1);
//        List<Float> itensU = dao.obterClassificacoes(user2);
//        normalizarLista(itensA, itensU);
//
//        float mediaA = calcMedia(itensA);
//        float mediaB = calcMedia(itensU);
//        List<Float> listaA = calcDiferencaMediaLista(itensA, mediaA);
//        List<Float> listaB = calcDiferencaMediaLista(itensU, mediaB);
//        List<Float> listaDiferencaMedia = produtoEntreLista(listaA, listaB);
//        float resultado1 = somatorio(listaDiferencaMedia);
//
//        List<Float> listaMediaQuadradoA = calcListaQuadrado(listaA);
//        List<Float> listaMediaQuadradoB = calcListaQuadrado(listaB);
//        float somatorioA = somatorio(listaMediaQuadradoA);
//        float somatorioB = somatorio(listaMediaQuadradoB);
//
//        float raizSomatorioA = (float) Math.sqrt(somatorioA);
//        float raizSomatorioB = (float) Math.sqrt(somatorioB);
//        float resultado2 = raizSomatorioA * raizSomatorioB;
//        if (resultado2 == 0) {
//            resultado2 = 99f;
//        }
//        float similaridade = resultado1 / resultado2;
//
//        return similaridade;
//
//    }
//    
//    public void testSimilaridade() {
//        List<Float> listaA = dao.obtercalcMediaDiferencaClassificao(1);
//        List<Float> listaB = dao.obtercalcMediaDiferencaClassificao(1);
//        normalizarLista(listaA, listaB);
//        float result1 = dao.obtercalcRaizSomaQuadrado(1);
//        float result2 = dao.obtercalcRaizSomaQuadrado(1);
//        float resultado2 = result1*result2;
//        DecimalFormat df = new DecimalFormat("0.00000");
//        float resultado1=0;
//        for(int index=0;index<listaA.size();index++){
//            resultado1+=listaA.get(index)*listaB.get(index);
//        }
//        System.out.println(df.format(resultado1));
//        System.out.println(resultado2);
//        float resultado3 = resultado1/resultado2;
//        System.out.println(resultado3);
//    }
 
    public void testPredicao() {
//        String movieid="7";
//        PreProcessamento p = new PreProcessamento();
//        float predicao = p.predicao(""+movieid,5000000);
//        System.out.println(predicao);
        dao.getUsuarios("1", 3);
    }

//    public void testgetUsuarios() {
//        Integer movieid = 1;
//        List<Integer> usuarios = dao.obterUsuarios(movieid);
//        float soma=0;
//        for (int userid1 = 0; userid1 < usuarios.size(); userid1++) {
//            for(int userid2=userid1+1;userid2<usuarios.size()-1;userid2++){
//                Integer segundo = usuarios.get(userid2);
//                Integer primeiro = usuarios.get(userid1);
//                soma+=similaridade(primeiro, segundo);
//            }   
//        }
//        System.out.println("soma similaridades: " +soma);
//        List<Float> classificacoes = dao.obterClassificacoes(usuarios.get(0));
//        float similaridade = similaridade(usuarios.get(0), usuarios.get(0));
//        float media = calcMedia(classificacoes);
//        List<Float> resultist = calcDiferencaMediaLista(classificacoes, media);
//        System.out.println(resultist);
//    }
    public void testObterUsuarios() {
        List<Integer> users = dao.obterUsuarios(1);
        System.out.println(users.toString());
    }

    public void testGetlista() {
        DaoRating dao = new DaoRating();
//        List<Float> listaClassificacaoA = dao.obterClassificacoes(1);
//        List<Float> listaClassificacaoB = dao.obterClassificacoes(2);
//        System.out.println(listaClassificacaoA.toString());
//        System.out.println(listaClassificacaoB.toString());
        float mediaA, mediaB, somaA = 0, somaB = 0;

        //RAP-MEDIA
//        for(Float rating:listaClassificacaoA){
//            somaA+=rating;
//        }
//        for(Float rating:listaClassificacaoB){
//            somaB+=rating;
//        }
//        mediaA = somaA/listaClassificacaoA.size();
//        mediaB = somaB/listaClassificacaoB.size();
//        
//        List<Float> resultadoDiferencaMediaA = new ArrayList();
//        List<Float> resultadoDiferencaMediaB = new ArrayList();
//        for(Float rat:listaClassificacaoA){
//            resultadoDiferencaMediaA.add(rat-mediaA);
//        }
//        for(Float rat:listaClassificacaoB){
//            resultadoDiferencaMediaB.add(rat-mediaB);
//        }
        List<Float> itensA = itensA();
        List<Float> itensU = itensUser1();

        System.out.println(itensA);
        System.out.println(itensU);
        System.out.println("Media Alice " + calcMedia(itensA));
        System.out.println("Media User1 " + calcMedia(itensU));
        mediaA = calcMedia(itensA);
        mediaB = calcMedia(itensU);
        List<Float> listaA = calcDiferencaMediaLista(itensA, mediaA);
        List<Float> listaB = calcDiferencaMediaLista(itensU, mediaB);
        List<Float> listaDiferencaMedia = produtoEntreLista(listaA, listaB);
        float resultado1 = somatorio(listaDiferencaMedia);

        System.out.println(listaA);
        System.out.println(listaB);
        System.out.println(listaDiferencaMedia.toString());
        System.out.println(resultado1);

        List<Float> listaMediaQuadradoA = calcListaQuadrado(listaA);
        List<Float> listaMediaQuadradoB = calcListaQuadrado(listaB);
        float somatorioA = somatorio(listaMediaQuadradoA);
        float somatorioB = somatorio(listaMediaQuadradoB);
        System.out.println(listaMediaQuadradoA.toString());
        System.out.println(listaMediaQuadradoB.toString());
        System.out.println(somatorioA);
        System.out.println(somatorioB);
        float raizSomatorioA = (float) Math.sqrt(somatorioA);
        float raizSomatorioB = (float) Math.sqrt(somatorioB);
        float resultado2 = raizSomatorioA * raizSomatorioB;
        System.out.println(raizSomatorioA);
        System.out.println(raizSomatorioB);
        System.out.println(resultado2);
        resultado2 = 0;
        if (resultado2 == 0) {
            resultado2 = 99f;
        }
        float similaridade = resultado1 / resultado2;
        System.out.println("similaridade: " + similaridade);
    }
    
    public void testExiste() {
        DaoRating dao = new DaoRating();
        Rating rat = new Rating();
        rat.setMovieId("31");
        rat.setUserId("1");
        System.out.println(dao.existe(rat));
    }

    public List<Float> itensA() {
        List<Float> lista = new ArrayList<>();
        Integer[] ratings = {5, 3, 4, 4, 5};
        for (Integer ava : ratings) {
            lista.add(ava.floatValue());
        }
        return lista;
    }

    public List<Float> itensUser1() {
        Integer[] ratings = {3, 1, 2, 3, 3};
        List<Float> lista = new ArrayList<>();
        for (Integer ava : ratings) {
            lista.add(ava.floatValue());
        }
        return lista;
    }

    public void testgetUer() {
        DaoRating dao = new DaoRating();
        String userid = dao.getuserId(1);
        System.out.println("usuario :" + userid);
    }

    public void testsimilaridade2() {
        String user1 = "1";
        String user2 = "15";
        List<Rating> listaA = dao.obtercalcMediaDiferencaClassificao(user1, 20);
        List<Rating> listaB = dao.obtercalcMediaDiferencaClassificao(user2, 20);
//        float result1 = dao.obtercalcRaizSomaQuadrado(listaA);
//        float result2 = dao.obtercalcRaizSomaQuadrado(listaB);
//        float resultado2 = result1*result2;
//        float resultado1=0;
//        for(Rating primeiro:listaA){   
//            for(Rating segundo:listaB){
//                System.out.println(primeiro.getMovieId()+" "+segundo.getMovieId());
//            }
//        }
//        float resultado3 = 0;
//        
//        if(resultado2==0){
//            resultado2 = (float)0.00001;
//            resultado3 = resultado1/resultado2;
//        }else{
//            resultado3 = resultado1/resultado2;
//        }
//        System.out.println("similaridade: "+resultado3);
    }

    public void testclassificacoes() {
        Persistencia persistencia = new Persistencia();
        String userid = "15";
        String comando = "select userid , movieid , rating from rating where userid= " + userid;
        String[] result = persistencia.executarSelecao(comando).split(";");
        List<Rating> ratingsList = new ArrayList();
        for (String str : result) {
            String[] dado = str.split(",");
            if (!dado[0].equals("null")) {
                Rating r = new Rating();
                r.setUserId(dado[0]);
                r.setMovieId(dado[1]);
                r.setRating(dado[2]);
                ratingsList.add(r);
            }
        }
        for (Rating r : ratingsList) {
            System.out.println(r.getMovieId());
        }

    }

    public void testmetodosimilaridade() {
        String user1 = "1";
        String user2 = "4";
        List<Rating> listaA = dao.obtercalcMediaDiferencaClassificao(user1, 20);
        List<Rating> listaB = dao.obtercalcMediaDiferencaClassificao(user2, 20);
        float result1 = dao.obtercalcRaizSomaQuadrado(listaA);
        float result2 = dao.obtercalcRaizSomaQuadrado(listaB);
        float resultado2 = result1 * result2;
        float resultado1 = 0;
        for (Rating primeiro : listaA) {
            for (Rating segundo : listaB) {
                if (primeiro.getMovieId().equals(segundo.getMovieId())) {
                    resultado1 += primeiro.getRatingMenosMedia() * segundo.getRatingMenosMedia();

                }
            }
        }
        float resultado3 = 0;

        if (resultado2 == 0) {
            resultado2 = (float) 0.00001;
            resultado3 = resultado1 / resultado2;
        } else {
            resultado3 = resultado1 / resultado2;
        }
        System.out.println(resultado3);
    }

    
    public void testobtencaodaclassificacao() {
        List<Integer> usuarios = dao.obterUsuarios("1");
        PreProcessamento p = new PreProcessamento();

        for (Integer primeiro : usuarios) {
            for (Integer segundo : usuarios) {
                System.out.println(primeiro + " " + segundo + " " + p.similaridade("" + primeiro, "" + segundo, 20));
            }
        }
    }

    
    public void testsimilaridade() {
        PreProcessamento p = new PreProcessamento();
        
        DaoRating dao = new DaoRating();
        System.out.println(p.recomendarFilmes("1", 15));
        
        
    }
    @Test
    public void testclassificar(){
        PreProcessamento processador = new PreProcessamento();
        List<String> id_filmes = new ArrayList();
        String movieid="1";
        id_filmes = processador.recomendarFilmes(movieid.trim(),15);
        System.out.println(id_filmes);
    }
    
    
    
}
