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

    <h1> Lista de Generos </h1>

    <a type="button" href="genero?accion=abrirForm"> Registra un genero nuevo </a>

    <br><br>

    <table border="1">

      <tr>
        <th class="l">Id</th>
        <th class="l">Nombre</th>
        <th class="l"><center>Estado</center></th>            

    </tr>

    <c:forEach var="genero" items="${generos}">         
        
        <tr>
        <td>${genero.getIdGenero()}</td>
        <td>${genero.getNombreGenero()}</td>

     	 <c:if test="${genero.getEstadoGenero() == true}">
          
           <td><span>Genero activo</span></td> 

        </c:if>

        <c:if test="${genero.getEstadoGenero() == false}">

            <td><span>Genero inactivo</span></td>

        </c:if>

        <tr>
        
</c:forEach>    

</table>

</div> 

      </center>
    
</body>
</html>