package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Beans.Zombie;
import com.example._20190050_20190459_20190674.Daos.ZombieDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EstadisticaZombieServlet", value = "/EstadisticaZombieServlet")
public class EstadisticaZombieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        ZombieDao zombieDao = new ZombieDao();

        switch (action) {
            case "listar" -> {

                request.setAttribute("porcentajeSexoM",zombieDao.porcentajeSexo("M"));
                request.setAttribute("porcentajeSexoF",zombieDao.porcentajeSexo("F"));
                request.setAttribute("porcentajeSexoO",zombieDao.porcentajeSexo("O"));

                request.setAttribute("porcentajeVictimas1",zombieDao.victimas("1"));
                request.setAttribute("porcentajeVictimas2",zombieDao.victimas("2"));
                request.setAttribute("porcentajeVictimas3",zombieDao.victimas("3"));
                request.setAttribute("porcentajeVictimas4",zombieDao.victimas("4"));
                request.setAttribute("porcentajeVictimas5",zombieDao.victimas("5"));

                RequestDispatcher view =request.getRequestDispatcher("estadisticasZombie.jsp");
                view.forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}