package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Daos.CaceriaDao;
import com.example._20190050_20190459_20190674.Daos.ZombieDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CaceriaServlet", value = "/CaceriaServlet")
public class CaceriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        CaceriaDao caceriaDao = new CaceriaDao();
        ZombieDao zombieDao = new ZombieDao();

        switch (action){
            case "listar" -> {
                request.setAttribute("listaSupervivientes",caceriaDao.obtenerSuperviviente());
                request.setAttribute("listaZombies",zombieDao.obtenerZombies());
                RequestDispatcher view =request.getRequestDispatcher("caceria.jsp");
                view.forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
