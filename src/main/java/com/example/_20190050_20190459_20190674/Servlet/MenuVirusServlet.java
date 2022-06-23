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
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        VirusDao virusDao = new VirusDao();

        switch (action){
            case "listar" ->{
                request.setAttribute("listaVirus",virusDao.obtenerVirus());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("menu_virus.jsp");
                requestDispatcher.forward(request,response);
            }
            case "crear" ->{
                request.setAttribute("listaVirus2",virusDao.obtenerVirus_sinRepetir());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("anadirVirus.jsp");
                requestDispatcher.forward(request,response);

            }
            case "crear2" ->{
                request.setAttribute("listaVirus",virusDao.obtenerVirus_sinRepetir());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("anadirVirus2.jsp");
                requestDispatcher.forward(request,response);
            }
            case "borrar" -> {
                String id = request.getParameter("id");
                virusDao.eliminarVariante(id);
                response.sendRedirect(request.getContextPath() + "/MenuVirusServlet");
            }

        }







    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        VirusDao virusDao = new VirusDao();

        switch (action){
            case "guardar" ->{
                String virusStr = request.getParameter("virus");
                String nombre_Variante = request.getParameter("nombre_Variante");
                int virus = virusDao.encontrarIDVirus(virusStr);
                virusDao.crear_variante(nombre_Variante,virus);
                response.sendRedirect(request.getContextPath()+"/MenuVirusServlet");


            }
            case "guardar2" ->{
                String nombre_Variante = request.getParameter("virus_name");
                virusDao.crear_virus(nombre_Variante);
                response.sendRedirect(request.getContextPath()+"/MenuVirusServlet");


            }
        }



    }
}
