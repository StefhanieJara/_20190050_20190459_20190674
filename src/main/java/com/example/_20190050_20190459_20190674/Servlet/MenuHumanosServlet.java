package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Beans.Humano;
import com.example._20190050_20190459_20190674.Daos.HumanoDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MenuHumanosServlet", value = "/MenuHumanosServlet")
public class MenuHumanosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HumanoDao humanoDao = new HumanoDao();
        request.setAttribute("listaHumano",humanoDao.obtenerPerfil());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("menu_humanos.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
