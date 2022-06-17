<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilos.css">

    <title> Lista </title>

</head>

<body background="img/tk.jpg">

    <center>

    <h1> Lista de Albunes </h1>

    <a type="button" href="album?accion1=AbrirForm2"> Registra un album nuevo </a>

    <br><br>

    <table border="1">

      <tr>
        <th class="l">Id</th>
        <th class="l">Nombre</th>
        <th class="l">Año de publicacion </th>
        <th class="l">Artista</th>
        <th class="l">Genero</th>
        <th class="l"><center>Estado</center></th>            

    </tr>

    <c:forEach var="album" items="${albums}">         
        
        <tr>
        <td>${album.getIdAlbum()}</td>
        <td>${album.getNombreAlbum()}</td>
        <td>${album.getAnioPublicacion()}</td>
        <td>${album.getIdArtista()}</td>
        <td>${album.getIdGenero()}</td>

     	 <c:if test="${album.getEstadoAlbum() == true}">
          
           <td><span>Album activo</span></td> 

        </c:if>

        <c:if test="${album.getEstadoAlbum() == false}">

            <td><span>Album inactivo</span></td>

        </c:if>

        <tr>
        
</c:forEach>    

</table>

</div> 

      </center>
    
</body>
</html>

</html>