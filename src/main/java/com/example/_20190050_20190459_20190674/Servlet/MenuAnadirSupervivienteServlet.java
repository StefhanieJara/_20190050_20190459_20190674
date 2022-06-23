package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Daos.SupervivientesDao;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.Float.valueOf;

@WebServlet(name = "MenuAnadirSupervivienteServlet", value = "/MenuAnadirSupervivienteServlet")
public class MenuAnadirSupervivienteServlet extends HttpServlet {
    String filtro;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupervivientesDao supervivientesDao = new SupervivientesDao();
        request.setAttribute("listasupervivientes",supervivientesDao.obtenerLista(filtro));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("anadirSupervivientes.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SupervivientesDao supervivientesDao = new SupervivientesDao();
        String name =(String) request.getParameter("nombre");
        String sexo=(String)request.getParameter("sexo");
        String fuerza = (String)request.getParameter("fuerza");
        String peso = (String)request.getParameter("peso");
        String idPareja = (String) request.getParameter("filtro");
        if(idPareja.equals("nada")){
            supervivientesDao.crearSupervivencia(name,sexo,valueOf(fuerza),valueOf(peso),null);
        }else{
            supervivientesDao.crearSupervivencia(name,sexo,valueOf(fuerza),valueOf(peso),idPareja);
        }

        response.sendRedirect(request.getContextPath()+"/MenuSupervivientesServlet");
    }
}
