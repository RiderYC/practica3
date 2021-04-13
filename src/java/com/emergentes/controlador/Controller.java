package com.emergentes.controlador;

import com.emergentes.modelo.GestorAlmacen;
import com.emergentes.modelo.almacen;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        almacen objProducto = new almacen();
        int id;
        int pos;
        String op = request.getParameter("op");
        
        if(op.equals("nuevo")){
            HttpSession ses = request.getSession();
            GestorAlmacen agenda = (GestorAlmacen) ses.getAttribute("agenda");
            objProducto.setId(agenda.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("miProducto", objProducto);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("modificar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorAlmacen agenda = (GestorAlmacen) ses.getAttribute("agenda");
            pos = agenda.ubicarProducto(id);
            objProducto = agenda.getLista().get(pos);
            request.setAttribute("op", op);
            request.setAttribute("miProducto", objProducto);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorAlmacen agenda = (GestorAlmacen) ses.getAttribute("agenda");
            pos = agenda.ubicarProducto(id);
            agenda.eliminarProducto(pos);
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        almacen objProducto = new almacen();
        int pos;
        String op = request.getParameter("op");
        
        if(op.equals("grabar")){
            objProducto.setId(Integer.parseInt(request.getParameter("id")));
            objProducto.setProducto(request.getParameter("producto"));
            objProducto.setPrecio(Integer.parseInt(request.getParameter("precio")));
            objProducto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            
            HttpSession ses = request.getSession();
            GestorAlmacen agenda = (GestorAlmacen) ses.getAttribute("agenda");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo")){
                agenda.insertarProducto(objProducto);
            }
            else{
                pos = agenda.ubicarProducto(objProducto.getId());
                agenda.modificarProducto(pos, objProducto);
            }
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
        }
    }
}
