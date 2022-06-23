package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Daos.SupervivientesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MenuSupervivientesServlet", value = "/MenuSupervivientesServlet")
public class MenuSupervivientesServlet extends HttpServlet {
    String filtro;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                SupervivientesDao supervivientesDao = new SupervivientesDao();
                request.setAttribute("listasupervivientes",supervivientesDao.obtenerLista(filtro));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("menu_supervivientes.jsp");
                requestDispatcher.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        filtro = (String) request.getParameter("filtro");

        response.sendRedirect(request.getContextPath()+"/MenuSupervivientesServlet");
    }
}
