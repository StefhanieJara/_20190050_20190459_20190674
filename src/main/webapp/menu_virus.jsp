<%@ page import="com.example._20190050_20190459_20190674.Beans.Virus" %><%--
  Created by IntelliJ IDEA.
  User: stefh
  Date: 20/06/2022
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaVirus" scope="request" type="java.util.ArrayList<com.example._20190050_20190459_20190674.Beans.Virus>" />

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
        href="<%=request.getContextPath()%>/MenuVirusServlet?action=crear"
        class="btn-float"
        style="margin-right: 100px"
>
    <i class="fas fa-plus my-float"></i>
</a>
<a
        href="<%=request.getContextPath()%>/MenuVirusServlet?action=crear2"
        class="btn-float2"
        style="margin-right: 10px"
>
    <i class="fas fa-plus my-float"></i>
</a>
<div class="container">
    <div class="navbar">
        <img src="img/logo.png" class="logo" alt="Main Logo" />

        <ul>
            <li><a href="<%=request.getContextPath()%>/MenuHumanosServlet">Humanos</a></li>
            <li><a href="<%=request.getContextPath()%>/MenuSupervivientesServlet">Supervivientes</a></li>
            <li><a href="<%=request.getContextPath()%>/MenuVirusServlet">Virus</a></li>
            <li><a href="<%=request.getContextPath()%>/MenuZombiesServlet">Zoombies</a></li>
            <li><a href="<%=request.getContextPath()%>/ObjetoServlet">Objetos</a></li>
            <li><a href="<%=request.getContextPath()%>/MenuCaceriaServlet">Cacería</a></li>
        </ul>
    </div>
    <main>
        <div class="card-header my-2"></div>
        <div class="row">
            <div class="moverTitulo">
                <h3 class="text-white">
                    Bienvenido al menú de Virus
                </h3>
            </div>
            <h4 class="text" style="color: #f57f00">
                El boton anaranjado es para agregar variante seleccionando un virus y el boton rojo para
                agregar un nuevo virus.
            </h4>
        </div>

        <!--Barra de búsqueda producto-->
        <div id="main-container">
            <table>
                <thead>
                <tr>
                    <th> Id de virus</th>
                    <th>Virus</th>
                    <th>Id Variante</th>
                    <th>Variante</th>
                    <th>Casos encontrados por variante</th>
                    <th></th>
                </tr>
                </thead>
                <tr>
                        <%for (Virus viruslista:listaVirus){%>
                <tr>
                    <td><%=viruslista.getIdVirus()%></td>
                    <td><%=viruslista.getNombre_virus()%></td>
                    <td><%=viruslista.getIdVariante()%></td>
                    <td><%=viruslista.getNombre_variante()%></td>
                    <td><%=viruslista.getCasos_encontrados()%></td>
                <td>
                    <a href="<%=request.getContextPath()%>/MenuVirusServlet?a=borrar&id=<%=viruslista.getIdVariante()%>"
                       class="btn btn-danger">Borrar</a>
                </td>

                </tr>
                <%}%>
                </tr>
            </table>
        </div>
    </main>

    <script src="bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>
