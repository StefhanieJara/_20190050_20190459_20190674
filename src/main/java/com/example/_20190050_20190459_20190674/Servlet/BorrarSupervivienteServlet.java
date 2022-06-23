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
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
         SupervivientesDao supervivientesDao = new SupervivientesDao();
        switch (action){
            case "borrar"->{
                String id = request.getParameter("id");
                System.out.println(id);
                supervivientesDao.eliminarSuperviviente(id);
                response.sendRedirect(request.getContextPath() + "/MenuSupervivientesServlet");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
