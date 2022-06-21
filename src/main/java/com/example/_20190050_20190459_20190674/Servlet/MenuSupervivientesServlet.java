package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Daos.SupervivientesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MenuSupervivientesServlet", value = "/MenuSupervivientesServlet")
public class MenuSupervivientesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupervivientesDao supervivientesDao = new SupervivientesDao();
        request.setAttribute("listasupervivientes",supervivientesDao.obtenerLista());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("menu_supervivientes.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
