package com.example._20190050_20190459_20190674.Servlet;

import com.example._20190050_20190459_20190674.Daos.SupervivientesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.Float.valueOf;

@WebServlet(name = "BorrarSupervivienteServlet", value = "/BorrarSupervivienteServlet")
public class BorrarSupervivienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SupervivientesDao supervivientesDao = new SupervivientesDao();
         String id = request.getParameter("id");
         supervivientesDao.eliminarSuperviviente(id);
        response.sendRedirect(request.getContextPath()+"/MenuSupervivientesServlet");
    }
}
