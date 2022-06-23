<%@ page import="com.example._20190050_20190459_20190674.Beans.Zombie" %>
<%@ page import="com.example._20190050_20190459_20190674.Beans.Superviviente" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaSupervivientes" scope="request" type="java.util.ArrayList<com.example._20190050_20190459_20190674.Beans.Superviviente>" />
<jsp:useBean id="listaZombies" scope="request" type="java.util.ArrayList<com.example._20190050_20190459_20190674.Beans.Zombie>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Caceria</title>
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
            margin-left: -180px;
            width: 1000px;
            margin-top: 52px;
        }
        #main-container2 {
            margin-left: 400px;
            width: 1000px;
            margin-top: -132px;
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
        class="btn-float3"
        style="margin-right: 10px"
>
    <i class="fas fa-plus my-float"></i>
</a>

<div class="container">
    <div class="navbar">
        <a href="index.jsp"><img src="img/logo.png" class="logo" alt="Main Logo" /></a>

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
                <h3 class="text-white">Bienvenido a Cacería</h3>
            </div>
            <h4 class="" style="color: #f57f00">La batalla esta por comenzar. Da click en la cabeza del zombie para empezar una batalla</h4>
        </div>
        <tr>
            <td>
                <div id="main-container">
                    <table>
                        <thead>
                        <tr>
                            <th>Nombre del Zombie</th>
                            <th>Número de Victimas</th>
                        </tr>
                        </thead>
                        <tr>
                            <%for(Zombie listaZombie: listaZombies){%>
                            <td><%=listaZombie.getNombre_apellido()%></td>
                            <td><%=listaZombie.getNum_victimas()%></td>
                            <%}%>
                        </tr>
                    </table>
                </div>
            </td>

            <td>
                <div id="main-container2">
                    <table>
                        <thead>
                        <tr>
                            <th>Nombre del Humano</th>
                            <th>Cantidad de Vacunas</th>
                        </tr>
                        </thead>
                        <tr>
                            <%for(Superviviente listasuperviviente: listaSupervivientes){%>
                            <td><%=listasuperviviente.getNombre_apellido()%></td>
                            <td><%=listasuperviviente.getCantidad_vacunas()%></td>
                            <%}%>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
    </main>

    <script src="bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>

