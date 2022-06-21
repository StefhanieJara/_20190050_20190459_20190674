package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Daos.VirusDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MenuVirusServlet", value = "/MenuVirusServlet")
public class MenuVirusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VirusDao virusDao = new VirusDao();
        request.setAttribute("listaVirus",virusDao.obtenerVirus());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("menu_virus.jsp");
        requestDispatcher.forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
