<%--
  Created by IntelliJ IDEA.
  User: stefh
  Date: 20/06/2022
  Time: 19:48
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
            margin-left: -250px;
            width: 1000px;
        }
        table {
            background-color: white;
            text-align: left;
            border-collapse: collapse;
            width: 86%;
            position: static;
            left: 90%;
            margin-left: 355px;
            top: 300%;
            margin-top: -20px;
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
            background-color: #efb810;
            color: white;
        }
        .caja1 {
            background-color: #ddd;
            width: 250px;
            height: 900px;
            position: absolute;
            margin-top: 30px;
            left: 1%;
            margin-left: 60px;
            margin-right: 50px;
        }
        .caja2 {
            background-color: #ddd;
            width: 300px;
            height: 930px;
            position: absolute;
            margin-top: 30px;
            left: 1%;
            margin-left: 40px;
            margin-right: 50px;
        }
    </style>
</head>
<body>
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
                <h3 class="text-white">
                    Bienvenido a la base de datos de Apocalipsis Zoombie
                </h3>
            </div>
        </div>
        <button type="button" class="btn btn-success">Menu Zoombies</button>
        <button type="button" class="btn btn-warning">
            Menu Supervivientes
        </button>
        <div id="main-container">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Codigo PUCP</th>
                    <th>Correo PUCP</th>
                    <th>Telefono</th>
                    <th>Nacimiento</th>
                    <th>Distrito</th>
                </tr>
                </thead>
                <tr>
                    <td>12345</td>
                    <td>Mario</td>
                    <td>Montaneda</td>
                    <td>20152014</td>
                    <td>ma@pucp.pe</td>
                    <td>972241302</td>
                    <td>12/12/2012</td>
                    <td>Comas</td>
                </tr>
            </table>
        </div>
    </main>

    <script src="bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>
