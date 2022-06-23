package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Daos.ObjetosDao;
import com.example._20190050_20190459_20190674.Daos.SupervivientesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.Float.valueOf;

@WebServlet(name = "CrearObjetoServlet", value = "/CrearObjetoServlet")
public class CrearObjetoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("anadirObjeto.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ObjetosDao objetosDao = new ObjetosDao();
        String nombre = request.getParameter("nombre");
        String peso = request.getParameter("peso");
        objetosDao.crearObjeto_normal(nombre,valueOf(peso));

        response.sendRedirect(request.getContextPath()+"/ObjetoServlet");
    }
}
