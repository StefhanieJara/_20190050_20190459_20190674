<%--
  Created by IntelliJ IDEA.
  User: stefh
  Date: 21/06/2022
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Modern NavBar + Underline</title>
    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap"
            rel="stylesheet"
    />
    <link rel="stylesheet" href="css/estilos.css" />
    <script
            src="https://kit.fontawesome.com/5733880de3.js"
            crossorigin="anonymous"
    ></script>
    <style type="text/css">
        body {
            font-family: Arial;
        }
        #main-container {
            margin: 52px;
            margin-left: auto;
            margin-right: auto;
            justify-content: center;
            width: 1000px;
        }
        .busqueda {
            margin-left: auto;
            margin-right: auto;
            justify-content: center;
            width: 250px;
        }
        table {
            background-color: white;
            text-align: left;
            border-collapse: collapse;
            margin-left: auto;
            margin-right: auto;
            justify-content: center;
        }
        th,
        td {
            padding: 20px;
        }
        thead {
            background-color: #efb810;
            border-bottom: solid 5px #0f362d;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #ddd;
        }
        tr:hover td {
            background-color: #51514f;
            color: white;
        }
    </style>
</head>
<body>
<a
        href="registrarCelebridad.html"
        class="btn-float"
        style="margin-right: 100px"
>
    <i class="fas fa-plus my-float"></i>
</a>
<a
        href="registrarCelebridad.html"
        class="btn-float2"
        style="margin-right: 10px"
>
    <i class="fas fa-plus my-float"></i>
</a>

<div class="container">
    <div class="navbar">
        <img src="img/logo.png" class="logo" alt="Main Logo" />

        <ul>
            <li><a href="#">Humanos</a></li>
            <li><a href="#">Supervivientes</a></li>
            <li><a href="#">Virus</a></li>
            <li><a href="#">Zoombies</a></li>
            <li><a href="#">Objetos</a></li>
            <li><a href="#">Cacería</a></li>
        </ul>
    </div>
    <main>
        <div class="card-header my-2"></div>
        <div class="row">
            <div class="moverTitulo">
                <h3 class="text-white">Bienvenido al menú de objetos</h3>
            </div>
            <h4 class="text" style="color: #f57f00">
                El boton anaranjado es para agregar objetos y el boton rojo para
                vacunas
            </h4>
        </div>

        <div id="main-container">
            <table>
                <thead>
                <tr>
                    <th>Nombre del Objeto</th>
                    <th>Peso</th>
                    <th>Tipo</th>
                    <th>Efectividad</th>
                    <th>Editar objeto</th>
                    <th>Eliminar</th>
                </tr>
                </thead>
                <tr>
                    <td>Vacuna</td>
                    <td>0.5</td>
                    <td>Vacuna</td>
                    <td>
                        <button type="button" class="btn btn-dark">Ver</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-dark">Editar</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-dark">Eliminar</button>
                    </td>
                </tr>
            </table>
        </div>
    </main>

    <script src="bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>
