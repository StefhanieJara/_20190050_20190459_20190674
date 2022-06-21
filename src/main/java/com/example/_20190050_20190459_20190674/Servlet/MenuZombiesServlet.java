package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Beans.Zombie;
import com.example._20190050_20190459_20190674.Daos.ZombieDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MenuZombiesServlet", value = "/MenuZombiesServlet")
public class MenuZombiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ZombieDao zombieDao = new ZombieDao();
        request.setAttribute("listaZombies",zombieDao.obtenerZombies());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("menu_zombies.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
