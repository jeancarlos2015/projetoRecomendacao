/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cih;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jean
 */
public class Tela {
    public void redirecionaPagina(HttpServletRequest request, HttpServletResponse response, String pagina) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("/"+pagina);
        rd.forward(request, response);
    }
    
    public void enviarMensagem(HttpServletRequest request, HttpServletResponse response, String mensagem, String pagina) throws ServletException, IOException {
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher rd = request.getRequestDispatcher("/"+pagina);
        rd.forward(request, response);
    }
    
    public String getDado(HttpServletRequest request, String atributoName){
        return request.getParameter(atributoName).trim();
    }
    
    public void testando(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter pw = response.getWriter();
        pw.println("<%--  " +
"    Document   : listaUsuarios " +
"    Created on : 28/06/2017, 07:58:53 " +
"    Author     : jean " +
"--%> " +
" " +
"<!DOCTYPE html> " +
"<!-- " +
"To change this license header, choose License Headers in Project Properties. " +
"To change this template file, choose Tools | Templates " +
"and open the template in the editor. " +
"--> " +
"<html> " +
"    <head> " +
"        <meta charset= 'utf-8 '> " +
"        <meta http-equiv= 'X-UA-Compatible ' content= 'IE=edge '> " +
"        <meta name= 'viewport ' content= 'width=device-width, initial-scale=1 '> " +
" " +
"        <script src= 'https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js '></script> " +
"        <script src= 'js/funcoes.js '></script> " +
"        <link href= 'css/bootstrap.min.css ' rel= 'stylesheet '> " +
"        <link href= 'css/bootstrap.css ' rel= 'stylesheet '> " +
"        <link href= 'css/bootstrap-theme.css ' rel= 'stylesheet '> " +
"        <link href= 'css/estilo.css ' rel= 'stylesheet '> " +
" " +
"        <title>Lista De Ítens</title> " +
" " +
" " +
"    </head> " +
"    <body> " +
"        <nav class= 'navbar navbar-inverse '> " +
"            <ul class= 'nav nav-pills '> " +
"                <li role= 'presentation ' ><a href= 'classificacaoItens.jsp '>Perfis De Usuários</a></li> " +
"                <li role= 'presentation ' ><a href= 'classificacaoItem.jsp '>Classificação Do Ítem</a></li> " +
"                <li role= 'presentation ' class= 'active '><a href= 'listaUsuarios.jsp '>Lista De Usuários Recomendados</a></li> " +
"            </ul> " +
"        </nav> " +
"        <form method= 'post ' action= 'Controlador '> " +
"            <h1>Lista De Usuários Recomendados</h1> " +
"            <span class= 'campo ' id= 'basic-addon1 ' >Código Do Item</span> " +
"            <input id= 'descricao ' type= 'text ' class= 'campo ' name= 'codigoitem '  placeholder= 'Código Do Item ' required= 'required ' aria-describedby= 'basic-addon1 '> " +
"            <input type= 'text ' class= 'oculto ' name= 'operacao ' value= 'recomendacaoUsuarios '> " +
"            <button type= 'submit ' class= 'btn btn-default campo '>Listar Usuarios Recomendados</button> " +
"        </form> " +
"        <div class= 'alert '> " +
"                <h3 class= 'mensagem '>${mensagem}</h3> " +
"            </div> " +
"    </body> " +
"</html> " +
"");
    }
}
