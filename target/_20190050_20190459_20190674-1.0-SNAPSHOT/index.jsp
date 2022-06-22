<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
</head>
<body>
<div class="container">
    <div class="navbar">
        <img src="img/logo.png" class="logo" alt="Main Logo" />

        <ul>
            <li><a href="<%=request.getContextPath()%>/MenuHumanosServlet">Humanos</a></li>
            <li><a href="<%=request.getContextPath()%>/MenuSupervivientesServlet">Supervivientes</a></li>
            <li><a href="#">Virus</a></li>
            <li><a href="#">Zoombies</a></li>
            <li><a href="<%=request.getContextPath()%>/ObjetoServlet">Objetos</a></li>
            <li><a href="#">Cacería</a></li>
        </ul>
    </div>
    <main>
        <div class="card-header my-2"></div>
        <div class="container">
            <div class="row">
                <div class="moverTitulo">
                    <h3 class="text-white">
                        Bienvenido a la base de datos de Apocalipsis Zoombie
                    </h3>
                </div>
            </div>
            <div class="row">
                <div class="container px-5 py-2" id="custom-cards-san-miguel">
                    <h4 class="pb-2 border-bottom" style="color: #f57f00">
                        ¿Qué menú desea ver el día de hoy?
                    </h4>
                    <div
                            class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-3"
                    >
                        <div class="col">
                            <div class="card">
                                <div
                                        class="card-header h-100 shadow border-0 text-white"
                                        style="
                        background-image: url('img/humanos.jpg');
                        background-size: cover;
                      "
                                >
                                    <h2
                                            class="mt-5 mb-3 fw-bold"
                                            style="text-shadow: 0.5px 0.5px #2b2b2b"
                                    >
                                        Menú de Humanos
                                    </h2>
                                </div>
                                <div class="card-body">
                                    <div
                                            class="d-flex flex-column mt-auto h-100 text-dark align-items-start"
                                    >
                                        <ul class="">
                                            <p>
                                                Vea la lista de humanos asi sean zoombies o
                                                supervivientes
                                            </p>
                                        </ul>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <a href="<%=request.getContextPath()%>/MenuHumanosServlet" class="btn btn-danger"
                                        >Ir a Humanos</a
                                        >
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div
                                        class="card-header h-100 shadow border-0 text-white"
                                        style="
                        background-image: url('img/persona.jpg');
                        background-size: cover;
                      "
                                >
                                    <h2
                                            class="mt-5 mb-3 fw-bold"
                                            style="text-shadow: 0.5px 0.5px #2b2b2b"
                                    >
                                        Menú de Supervivientes
                                    </h2>
                                </div>
                                <div class="card-body">
                                    <div
                                            class="d-flex flex-column mt-auto h-100 text-dark align-items-start"
                                    >
                                        <ul class="">
                                            <p>Vea la lista de supervivientes</p>
                                        </ul>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <a
                                                href="<%=request.getContextPath()%>/MenuSupervivientesServlet"
                                                class="btn btn-danger"
                                        >Ir a supervivientes</a
                                        >
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div
                                        class="card-header h-100 shadow border-0 text-white"
                                        style="
                        background-image: url('img/virus.jpg');
                        background-size: cover;
                      "
                                >
                                    <h2
                                            class="mt-5 mb-3 fw-bold"
                                            style="text-shadow: 0.5px 0.5px #2b2b2b"
                                    >
                                        Menú de virus
                                    </h2>
                                </div>
                                <div class="card-body">
                                    <div
                                            class="d-flex flex-column mt-auto h-100 text-dark align-items-start"
                                    >
                                        <ul class="">
                                            <p>Visualice la lista de virus y sus variantes.</p>
                                        </ul>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <a
                                                href="visualizacionOperadores.html"
                                                class="btn btn-danger"
                                        >Ir a Virus</a
                                        >
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div
                                        class="card-header h-100 shadow border-0 text-white"
                                        style="
                        background-image: url('img/zombies.jpg');
                        background-size: cover;
                      "
                                >
                                    <h2
                                            class="mt-5 mb-3 fw-bold"
                                            style="text-shadow: 0.5px 0.5px #2b2b2b"
                                    >
                                        Menú de Zombies
                                    </h2>
                                </div>
                                <div class="card-body">
                                    <div
                                            class="d-flex flex-column mt-auto h-100 text-dark align-items-start"
                                    >
                                        <ul class="">
                                            <p>
                                                Visualice la lista de zoombies, con sus
                                                carácteristicas.
                                            </p>
                                        </ul>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <a href="listaclientesV2.html" class="btn btn-danger"
                                        >Ir a Zombies</a
                                        >
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div
                                        class="card-header h-100 shadow border-0 text-white"
                                        style="
                        background-image: url('img/herramientas.jpg');
                        background-size: cover;
                      "
                                >
                                    <h2
                                            class="mt-5 mb-3 fw-bold"
                                            style="text-shadow: 0.5px 0.5px #2b2b2b"
                                    >
                                        Menú de objetos
                                    </h2>
                                </div>
                                <div class="card-body">
                                    <div
                                            class="d-flex flex-column mt-auto h-100 text-dark align-items-start"
                                    >
                                        <ul class="">
                                            <p>Visualice el menú de objetos</p>
                                        </ul>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <a href="<%=request.getContextPath()%>/ObjetoServlet" class="btn btn-danger"
                                        >Ir a objetos</a
                                        >
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div
                                        class="card-header h-100 shadow border-0 text-white"
                                        style="
                        background-image: url('img/caceria.jpg');
                        background-size: cover;
                      "
                                >
                                    <h2
                                            class="mt-5 mb-3 fw-bold"
                                            style="text-shadow: 0.5px 0.5px #2b2b2b"
                                    >
                                        Menú de Cacería.
                                    </h2>
                                </div>
                                <div class="card-body">
                                    <div
                                            class="d-flex flex-column mt-auto h-100 text-dark align-items-start"
                                    >
                                        <ul class="">
                                            <p>Ataque entre zombies y humanos.</p>
                                        </ul>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <a href="listaclientesV2.html" class="btn btn-danger"
                                        >Ir a cacería</a
                                        >
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <script src="bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>
