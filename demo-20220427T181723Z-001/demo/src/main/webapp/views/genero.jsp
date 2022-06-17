<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilos.css">

    <title> Genero </title>
</head>

<body background="img/f2.jpg">

    <form method="post" action="genero?accion=addGenero">

        <center>

            <h1 class="t1"> Crear nuevo Genero </h1>

            <br><br>

            <input type="text" id="nombreGenero" class="fadeIn third" name="nombreGenero" placeholder="Nombre del genero">

            <br><br>

            <label for="estadoGenero"> Activo </label>

            <input checked="" type="checkbox" id="estadoGenero" name="estadoGenero" class="tipo_us">

            <br><br>

            <input type="submit" name="accion" class="fadeIn fourth" value="Ingresar">

    </form>

    </center>

</body>

</html>