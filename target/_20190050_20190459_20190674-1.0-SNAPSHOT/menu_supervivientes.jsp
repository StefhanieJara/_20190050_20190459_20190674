<%@ page import="com.example._20190050_20190459_20190674.Beans.Superviviente" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listasupervivientes" scope="request" type="java.util.ArrayList<com.example._20190050_20190459_20190674.Beans.Superviviente>" />

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
        href="<%=request.getContextPath()%>/MenuAnadirSupervivienteServlet"
        class="btn-float"
        style="margin-right: 100px"
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
                    Bienvenido al menú de supervivientes
                </h3>
            </div>
        </div>

        <!--Barra de búsqueda producto-->
        <form class="busqueda" method ="POST" action="<%=request.getContextPath()%>/MenuSupervivientesServlet">
            <div class="row g-3 align-items-center mt-2">
                <div class="rows-auto">
                    <select

                            class="form-select form-select-sm"
                            name="filtro"
                            aria-label=".form-select-sm example"

                    >
                        <option value="Seleccionar genero">Selecciona el género</option>
                        <option value="F">Mujer</option>
                        <option value="M">Hombre</option>
                        <option value="O">Otro</option>
                    </select>
                </div>
            </div>
            <div class="row row-cols-3 justify-content-center">
                <button class="btn btn-tele" type="submit">Filtrar</button>
            </div>
        </form>

        <div id="main-container">
            <table>
                <thead>
                <tr>
                    <th>Peso</th>
                    <th>Fuerza</th>
                    <th>Nombre comleto de la pareja</th>
                    <th>Peso cargado</th>
                    <th>-</th>
                </tr>
                </thead>
                <%for(Superviviente superviviente:listasupervivientes){%>
                <tr>
                    <td><%=superviviente.getPeso()%></td>
                    <td><%=superviviente.getFuerza()%></td>
                    <td>
                        <% if(superviviente.getPareja() == null){%>
                           No tiene pareja
                        <%}else{%>
                            <%=superviviente.getPareja()%>
                        <%}%>
                    </td>
                    <td><%=superviviente.getPeso_cargado()%></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/BorrarSupervivienteServlet?a=borrar&id=<%=superviviente.getId()%>"><button
                                type="button" class="btn btn-danger" >Eliminar</button> </a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
    </main>

    <script src="bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>
