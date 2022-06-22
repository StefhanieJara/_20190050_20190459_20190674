package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Beans.Zombie;
import com.example._20190050_20190459_20190674.Daos.ZombieDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MenuAnadirZombieServlet", value = "/AnadirZombieServlet")
public class MenuAnadirZombieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        ZombieDao zombieDao = new ZombieDao();

        switch (action) {
            case "listar" -> {
                request.setAttribute("listavariantes",zombieDao.obtenerVariantes());
                RequestDispatcher view =request.getRequestDispatcher("anadirZombies.jsp");
                view.forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        ZombieDao zombieDao = new ZombieDao();

        switch (action){
            case "guardar" -> {
                String nombre_apellido = request.getParameter("nombre_apellido");
                String sexo = request.getParameter("sexo");
                String id_tipo_zombie = request.getParameter("id_tipo_zombie");
                String id_variante = request.getParameter("id_variante");
                try {

                    zombieDao.crearZombie(nombre_apellido, sexo, id_tipo_zombie, id_variante);

                    response.sendRedirect(request.getContextPath() + "/MenuZombiesServlet");

                } catch (NumberFormatException e) {
                    System.out.println("error al parsear");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AnadirZombieServlet");
                    requestDispatcher.forward(request, response);
                }
            }
        }
    }
}