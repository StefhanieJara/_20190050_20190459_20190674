package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Beans.Objetos;
import com.example._20190050_20190459_20190674.Daos.HumanoDao;
import com.example._20190050_20190459_20190674.Daos.ObjetosDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ObjetoServlet", value = "/ObjetoServlet")
public class ObjetoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjetosDao objetosDao = new ObjetosDao();
        request.setAttribute("listaObjetos",objetosDao.obtenerObjetos());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("menu_objetos.jsp");
        requestDispatcher.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
