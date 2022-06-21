<%--
  Created by IntelliJ IDEA.
  User: stefh
  Date: 21/06/2022
  Time: 12:23
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
        <section class="vh-100">
            <div class="container py-4 h-100">
                <div class="row justify-content-center align-items-center h-100">
                    <div class="col-12 col-lg-9 col-xl-7">
                        <div
                                class="card shadow-2-strong card-registration"
                                style="border-radius: 15px"
                        >
                            <div
                                    class="card-header"
                                    style="background-color: #e72d4b; color: white"
                            >
                                <h4 class="my-2">Efectividad por tipo de Zombie</h4>
                            </div>
                            <div class="card-body p-4 p-md-5">
                                <form>
                                    <div class="row">
                                        <div class="col-md-6 mb-1">
                                            <div class="form-outline mb-4">
                                                <h4
                                                        class="pb-2 border-bottom"
                                                        style="color: #f57f00"
                                                >
                                                    Demoledor
                                                </h4>

                                                <div class="form-outline mb-4">
                                                    <div class="rows-auto">
                                                        <label class="form-label" for="productName"
                                                        >Porcentaje</label
                                                        >
                                                        <div class="progress">
                                                            <div
                                                                    class="progress-bar bg-danger"
                                                                    role="progressbar"
                                                                    style="width: 25%"
                                                                    aria-valuenow="25"
                                                                    aria-valuemin="0"
                                                                    aria-valuemax="100"
                                                            >
                                                                25%
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <h4
                                                        class="pb-2 border-bottom"
                                                        style="color: #f57f00"
                                                >
                                                    Rápido
                                                </h4>

                                                <div class="form-outline mb-4">
                                                    <div class="rows-auto">
                                                        <label class="form-label" for="productName"
                                                        >Porcentaje</label
                                                        >
                                                        <div class="progress">
                                                            <div
                                                                    class="progress-bar bg-danger"
                                                                    role="progressbar"
                                                                    style="width: 25%"
                                                                    aria-valuenow="25"
                                                                    aria-valuemin="0"
                                                                    aria-valuemax="100"
                                                            >
                                                                25%
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <h4
                                                        class="pb-2 border-bottom"
                                                        style="color: #f57f00"
                                                >
                                                    Niño
                                                </h4>

                                                <div class="form-outline mb-4">
                                                    <div class="rows-auto">
                                                        <label class="form-label" for="productName"
                                                        >Porcentaje</label
                                                        >
                                                        <div class="progress">
                                                            <div
                                                                    class="progress-bar bg-danger"
                                                                    role="progressbar"
                                                                    style="width: 25%"
                                                                    aria-valuenow="25"
                                                                    aria-valuemin="0"
                                                                    aria-valuemax="100"
                                                            >
                                                                25%
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <h4
                                                        class="pb-2 border-bottom"
                                                        style="color: #f57f00"
                                                >
                                                    Normal
                                                </h4>

                                                <div class="form-outline mb-4">
                                                    <div class="rows-auto">
                                                        <label class="form-label" for="productName"
                                                        >Porcentaje</label
                                                        >
                                                        <div class="progress">
                                                            <div
                                                                    class="progress-bar bg-danger"
                                                                    role="progressbar"
                                                                    style="width: 25%"
                                                                    aria-valuenow="25"
                                                                    aria-valuemin="0"
                                                                    aria-valuemax="100"
                                                            >
                                                                25%
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <h4
                                                        class="pb-2 border-bottom"
                                                        style="color: #f57f00"
                                                >
                                                    Otro
                                                </h4>

                                                <div class="form-outline mb-4">
                                                    <div class="rows-auto">
                                                        <label class="form-label" for="productName"
                                                        >Porcentaje</label
                                                        >
                                                        <div class="progress">
                                                            <div
                                                                    class="progress-bar bg-danger"
                                                                    role="progressbar"
                                                                    style="width: 25%"
                                                                    aria-valuenow="25"
                                                                    aria-valuemin="0"
                                                                    aria-valuemax="100"
                                                            >
                                                                25%
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6 mb-4 text-center">
                                            <img
                                                    src="img/variante.jpg"
                                                    class="img-thumbnail"
                                                    width="800px"
                                                    height="800px"
                                                    alt=""
                                            />
                                        </div>
                                    </div>

                                    <div class="">
                                        <input
                                                class="btn btn-tele"
                                                type="submit"
                                                value="Regresar a la lista"
                                        />
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <script src="bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>
