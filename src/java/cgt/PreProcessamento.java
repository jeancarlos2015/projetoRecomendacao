/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Rating;
import cgd.DaoRating;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jean
 */
public class PreProcessamento {
    private DaoRating dao = new DaoRating();
  
  
    

   public float predicao(String movieid, int tam){
        List<Rating> classificacoes = dao.obterClassificacoesPorFilme(movieid, tam);
        List<Rating> classificacoes1 = new ArrayList();
        Rating maiorClassificacao = dao.maior(classificacoes);
        float soma = 0;
        float similaridade = 0;
        float similaridades = 0;
        for (Rating usuario : classificacoes1) {
            if (!maiorClassificacao.equals(usuario)) {
                similaridade = similaridade(maiorClassificacao.getUserId(), usuario.getUserId(), tam);
                float media = dao.obtercalcMediaPorUsuario(usuario.getUserId()).getMedia();
                float classificacao = dao.getRating(usuario.getUserId(), movieid).getRating();
                soma += (media - classificacao) * similaridade;
                similaridades += similaridade;
            }
        }
        String userid = maiorClassificacao.getUserId();
        Rating mediausuario = dao.obtercalcMediaPorUsuario(userid);
        if (similaridades == 0) {
            similaridades =  (float)0.000001;
        }
        float predicao = mediausuario.getMedia() + (soma / similaridades);
        return predicao;
   }
   
  
  public float classificar(int userid, int movieid){
        Rating rating = dao.getRating(userid, movieid);
        float rat = rating.getRating();
        return rat;
    }
    
    public float classificar(String userid, String movieid){
        int iduser = Integer.parseInt(userid);
        int idmovie = Integer.parseInt(movieid);
        return classificar(iduser, idmovie);
    }
    
    public List<String> recomendarUsuarios(String movieId){
        float predicao = predicao(""+movieId,5000000);
        return dao.getUsuarios(movieId, predicao);
    }
    
   
   public void imprime(List<Rating> ratings){
       for(Rating r:ratings){
           System.out.println(r.getMovieId()+";"+r.getRating().toString().replace(".", ","));
       }
   }
   
   private void normalizarLista(List<Rating> listaA, List<Rating> listaB) {

        if (listaA.size() > listaB.size()) {
//            float media = maior(listaB);
            while (listaA.size() > listaB.size()) {
                listaB.add(new Rating());
            }
        }
        if (listaA.size() < listaB.size()) {
            while (listaB.size() > listaA.size()) {
                listaA.add(new Rating());
            }
        }
    }
   //calcula a similaridade entre user12 e user22 para quantidade tam classificacoes
   public float similaridade(int user12, int user22, int tam){
        String user1= ""+user12;
        String user2=""+user22;
        List<Rating> listaA = dao.obtercalcMediaDiferencaClassificao(user1,tam);
        List<Rating> listaB = dao.obtercalcMediaDiferencaClassificao(user2,tam);
        normalizarLista(listaA, listaB);
        float result1 = dao.obtercalcRaizSomaQuadrado(listaA);
        float result2 = dao.obtercalcRaizSomaQuadrado(listaB);
        float resultado2 = result1*result2;
        float resultado1=0;
        for(Rating primeiro:listaA){   
            for(Rating segundo:listaB){
                if(primeiro.getMovieId().equals(segundo.getMovieId())){
                    System.out.println(primeiro.getRatingMenosMedia());
                    resultado1+=primeiro.getRatingMenosMedia()*segundo.getRatingMenosMedia();
                    break;
                }
            }
        }
        float resultado3 = 0;
        if(resultado2==0){
            resultado2 = (float)0.00000001;
            resultado3 = resultado1/resultado2;
        }else{
            resultado3 = resultado1/resultado2;
        }
        return resultado3;
   }
   private Rating  maiorSimilaridade(List<Rating> usuarios){
       Rating maior = usuarios.get(0);
       for(Rating usuario:usuarios){
           if(maior.getSimilaridade()<usuario.getSimilaridade()){
               maior = usuario;
           }
       }
       return maior;
   }
   public List<String> recomendarFilmes(String userid, int tam){
       List<Rating> usuarios = dao.obterUsuariosFilmes(userid);
       List<Rating> usuariosparecidos = new ArrayList();
       float similaridade=0;
       for(Rating usuario:usuarios){
           if(!usuariosparecidos.contains(usuario)){
               similaridade = similaridade(usuario.getUserId(), userid, tam);
           }
           
           if(similaridade>=0.001 && !usuario.getUserId().equals(userid) && !usuariosparecidos.contains(usuario)){
               Rating r = new Rating();
               r.setUserId(usuario.getUserId());
               r.setMovieId(usuario.getMovieId());
               r.setSimilaridade(similaridade);
               usuariosparecidos.add(r);
               if(usuariosparecidos.size()==tam){
                   break;
               }
           }
       }
        Rating maior = maiorSimilaridade(usuariosparecidos);
        List<Rating> filmes = dao.obterClassificacoesPorUsuario(maior.getUserId(), tam);
        List<String> filmes_str = new ArrayList();
        for(Rating filme:filmes){
            filmes_str.add(filme.getMovieId());
        }
       return filmes_str;
   }
       
   //calcula a similaridade entre dois usuarios para tam classificacoes
   public float similaridade(String user1, String user2, int tam){
       if(user1==null || user2==null){return 0;}
        List<Rating> listaA = dao.obtercalcMediaDiferencaClassificao(user1,tam);
        List<Rating> listaB = dao.obtercalcMediaDiferencaClassificao(user2,tam);
        normalizarLista(listaA, listaB);
        float result1 = dao.obtercalcRaizSomaQuadrado(listaA);
        float result2 = dao.obtercalcRaizSomaQuadrado(listaB);
        float resultado2 = result1*result2;
        float resultado1=0;
        for(Rating primeiro:listaA){   
            for(Rating segundo:listaB){
                if(primeiro.getMovieId().equals(segundo.getMovieId())){
                    resultado1+=primeiro.getRatingMenosMedia()*segundo.getRatingMenosMedia();
                    break;
                }
            }
        }
        float resultado3 = 0;
        
        if(resultado2==0){
            resultado2 = (float)0.00001;
            resultado3 = resultado1/resultado2;
        }else{
            resultado3 = resultado1/resultado2;
        }
        return resultado3;

   }
   
   
   
   
}
