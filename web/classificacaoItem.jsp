<%-- 
    Document   : classificacaoItem
    Created on : 28/06/2017, 07:57:44
    Author     : jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/funcoes.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">

        <title>Classificação Do Ítem</title>


    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <ul class="nav nav-pills">
                <li role="presentation"><a href="recomendacaoUsuarios.jsp">Recomendação De Usuários</a></li>
                <li role="presentation" class="active"><a href="classificacaoItem.jsp">Classificação Do Ítem</a></li>
                <li role="presentation"><a href="recomendacaoItens.jsp">Recomendação De Ítens</a></li>
            </ul>
        </nav>
        <form method="post" action="Controlador">
                <h1>Classificação Do Ítem</h1>
                <span class="campo" id="basic-addon1" >Código Do Usuário</span>
                <input id="descricao" type="text" class="campo" name="userid"  placeholder="Código Do Usuario" required="required" aria-describedby="basic-addon1">
                <span class="campo" id="basic-addon1" >Código Do Filme</span>
                <input id="descricao" type="text" class="campo" name="movieid"  placeholder="Código Do Item" required="required" aria-describedby="basic-addon1">
                <input type="text" class="oculto" name="operacao" value="classificar">
                <button type="submit" class="btn btn-default campo">Obter Classificação Do Item</button>
            </form>
        
        <div class="alert">
                <h3 class="mensagem">${mensagem}</h3>
            </div>
    </body>
</html>
