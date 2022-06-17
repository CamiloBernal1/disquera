<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilos.css">

    <title> Album </title>

</head>

<body background="./img/f2.jpg">

    <form method="post" action="album?accion1=addAlbum">

        <center>

            <h1 class="t1"> Crear un nuevo Album </h1>

            <br><br>

            <input type="text" id="nombreAlbum" class="fadeIn third" name="nombreAlbum" placeholder="Nombre del Album">

            <br><br>

            <input type="int" id="anioPublicacion" class="fadeIn third" name="anioPublicacion" placeholder="Año de publicacion">

            <br><br>

            <input type="int" id="idArtistaFK" class="fadeIn third" name="idArtistaFK" placeholder="Nombre del artista">

            <br><br>

            <input type="int" id="idGeneroFK" class="fadeIn third" name="idGeneroFK" placeholder="Genero">

            <br><br>

            <label for="estadoAlbum"> Activo </label>

            <input checked="" type="checkbox" id="estadoAlbum" name="estadoAlbum" class="tipo_us">

            <br><br>

            <input type="submit" name="accion1" class="fadeIn fourth" value="Ingresar">

    </form>

    <img src="./img/tr.jpg">

    </center>

</body>

</html>




    













