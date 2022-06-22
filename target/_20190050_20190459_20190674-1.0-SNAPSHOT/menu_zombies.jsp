<%@ page import="com.example._20190050_20190459_20190674.Beans.Zombie" %>
<%@ page import="java.util.Objects" %>
<%@ page import="static java.lang.Math.abs" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaZombies" scope="request" type="java.util.ArrayList<com.example._20190050_20190459_20190674.Beans.Zombie>" />
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
                href="<%=request.getContextPath()%>/AnadirZombieServlet"
                class="btn-float"
                style="margin-right: 100px"
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
                        <h3 class="text-white">Bienvenido al menú de zombies</h3>
                    </div>
                </div>

                <!--Barra de búsqueda producto-->
                <div id="main-container">
                    <table>
                        <thead>
                            <tr>
                                <th>Tiempo Infectado (minutos)</th>
                                <th>Variante de Virus</th>
                                <th>Número de Victimas</th>
                                <th>Tipo de zombies</th>
                                <th><a href="<%=request.getContextPath()%>/EstadisticaZombieServlet"><button type="button" class="btn btn-dark">Ver Stats</button></a></th>
                            </tr>
                        </thead>
                        <tr>
                                <%for (Zombie virusZombie:listaZombies){%>
                                <%if(virusZombie.getEstado()==1){%>
                        <tr>
                            <td><%=abs((int) virusZombie.getTiempo_inf())%></td>
                            <td><%=virusZombie.getNombre_variante()%></td>
                            <td><%=virusZombie.getNum_victimas()%></td>
                            <td><%=virusZombie.getNombre_zombie()%></td>
                            <td></td>
                        </tr>
                        <%}%>
                        <%}%>
                        </tr>
                    </table>
                </div>
            </main>

            <script src="bootstrap/js/bootstrap.min.js"></script>
        </div>
    </body>
</html>

