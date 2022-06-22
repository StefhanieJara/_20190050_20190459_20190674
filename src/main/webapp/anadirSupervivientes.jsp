<%@ page import="com.example._20190050_20190459_20190674.Beans.Superviviente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listasupervivientes" scope="request" type="java.util.ArrayList<com.example._20190050_20190459_20190674.Beans.Superviviente>"/>

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
      <li><a href="<%=request.getContextPath()%>/MenuHumanosServlet">Humanos</a></li>
      <li><a href="<%=request.getContextPath()%>/MenuSupervivientesServlet">Supervivientes</a></li>
      <li><a href="<%=request.getContextPath()%>/MenuVirusServlet">Virus</a></li>
      <li><a href="<%=request.getContextPath()%>/MenuZombiesServlet">Zoombies</a></li>
      <li><a href="<%=request.getContextPath()%>/ObjetoServlet">Objetos</a></li>
      <li><a href="<%=request.getContextPath()%>/MenuCaceriaServlet">Cacería</a></li>
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
                <h4 class="my-2">Registrar Superviviente</h4>
              </div>

              <div class="card-body p-4 p-md-5">
                <form method="POST" action="<%=request.getContextPath()%>/MenuAnadirSupervivienteServlet">
                  <div class="row">
                    <div class="col-md-6 mb-1">
                      <div class="form-outline mb-4">
                        <label class="form-label" for="productName"
                        >Nombres del superviviente</label
                        >
                        <input
                                type="text"
                                name="nombre"
                                class="form-control "
                                placeholder="Ingrese los nombres"
                        />
                      </div>
                      <div class="form-outline mb-4">
                        <div class="rows-auto">
                          <select
                                  class="form-select form-select-sm"
                                  name="sexo"
                                  aria-label=".form-select-sm example"
                          >
                            <option value="">
                              Selecciona el género
                            </option>
                            <option value="M">
                              Masculino
                            </option>
                            <option value="F">
                              Femenino
                            </option>
                            <option value="O">
                              Otro
                            </option>
                          </select>
                        </div>
                      </div>
                      <div class="form-outline mb-4">
                        <label class="form-label" for="productName"
                        >Fuerza</label
                        >
                        <input
                                type="number"
                                name="fuerza"
                                id="productName"
                                class="form-control"
                                placeholder="Ingrese la fuerza"
                        />
                      </div>
                      <div class="form-outline mb-4">
                        <label class="form-label" for="productName1"
                        >Peso</label
                        >
                        <input
                                type="number"
                                name="peso"
                                id="productName1"
                                class="form-control"
                                placeholder="Ingrese el peso"
                        />
                      </div>
                      <div class="form-outline mb-4">
                        <div class="rows-auto">
                          <label class="form-label"
                          >Nombre de la Pareja</label
                          >
                          <select
                                  class="form-select form-select-sm"
                                  name="filtro"
                                  aria-label=".form-select-sm example"
                          >
                            <option value="nada">
                              Selecciona la pareja
                            </option>
                            <%for(Superviviente listasuper: listasupervivientes){%>
                            <option value="<%=listasuper.getId()%>"><%=listasuper.getNombre_apellido()%></option>
                            <%}%>
                          </select>

                        </div >
                      </div>
                    </div>

                    <div class="col-md-6 mb-4 text-center">
                      <img
                              src="img/persona.png"
                              class="img-thumbnail"
                              width="200px"
                              height="200px"
                              alt="medicamento"
                      />
                    </div>
                  </div>

                  <div class="">
                    <input
                            class="btn btn-tele"
                            type="submit"
                            value="Guardar Superviviente"
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

