/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cdp.Movie;
import cdp.Rating;
import cgd.DaoMovie;
import cgd.DaoRating;
import cgt.PreProcessamento;
import cih.Tela;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jean
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    private PreProcessamento processador = new PreProcessamento();
    private Tela tela = new Tela();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        classificar(request, response);
        recomendarUsuarios(request, response);
        recomendarItens(request, response);
    }

    
    public void classificar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String operacao = tela.getDado(request, "operacao");
        
        
        if(operacao.equals("classificar")){
            Rating rating = new Rating();
            DaoRating daoRating = new DaoRating();
            String userid = tela.getDado(request, "userid");
            String movieid = tela.getDado(request, "movieid");
            rating.setMovieId(movieid);
            rating.setUserId(userid);
            
            if(daoRating.existe(rating)){
                float classifi = processador.classificar(Integer.parseInt(userid),Integer.parseInt(movieid));
                tela.enviarMensagem(request, response, "Classificacao = "+classifi,"classificacaoItem.jsp");
            }else{
                tela.enviarMensagem(request, response, "Usuario ou filme nao existem!!!","classificacaoItem.jsp");
            }
            

        }
        
    }
    
    public void recomendarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String operacao = tela.getDado(request, "operacao");
        if(operacao.equals("recomendacaoUsuarios")){
            PrintWriter pw = response.getWriter();
            String movieid = request.getParameter("movieid");
            List<String> usuarios = processador.recomendarUsuarios(movieid);
            pw.println("<h1>Lista De Usuarios Recomendados</h1>");
            for(String usuario:usuarios){
                pw.println("userid: "+ usuario);
                pw.println("<br>");
            }
        }
        
    }
    
    public void recomendarItens(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String operacao = tela.getDado(request, "operacao");
        
        if(operacao.equals("recomendacaoItens")){
            
            PrintWriter pw = response.getWriter();
            String userid = request.getParameter("userid");
            List<String> id_filmes = new ArrayList();
            id_filmes = processador.recomendarFilmes(userid.trim(),15);
            DaoMovie dao = new DaoMovie();
            pw.println("<h1>Lista De Filmes Recomendados</h1>");
            for(String id_filme:id_filmes){
                Movie movie = (Movie) dao.buscar(id_filme);
                pw.println("Titulo :"+movie.getTitle()+"               Ano :"+ movie.getYear());
                pw.println("<br>");
            }
//            
//          
        }
        
    }
}
