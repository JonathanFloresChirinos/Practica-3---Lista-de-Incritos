package com.emergentes.controlador;

import com.emergentes.modelo.Inscritos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        Inscritos ins = new Inscritos();
        int id, pos;
        
        HttpSession ses = request.getSession();
        ArrayList<Inscritos> list = (ArrayList<Inscritos>) ses.getAttribute("semi");
        
        switch (op){
            case "nuevo":
                request.setAttribute("obj", ins);
                request.getRequestDispatcher("Editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarId(request,id);
                ins = list.get(pos);
                request.setAttribute("obj", ins);
                request.getRequestDispatcher("Editar.jsp").forward(request, response);
                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarId(request,id);
                if (pos >= 0) {
                    list.remove(pos);
                }
                request.setAttribute("semi", list);
                response.sendRedirect("index.jsp");
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Inscritos> list = (ArrayList<Inscritos>)ses.getAttribute("semi");
        Inscritos ins = new Inscritos();
        ins.setId(id);
        ins.setFecha(request.getParameter("fecha"));
        ins.setNombre(request.getParameter("nombre"));
        ins.setApellidos(request.getParameter("apellidos"));
        ins.setSem1(request.getParameter("sem1"));
        ins.setSem2(request.getParameter("sem2"));
        ins.setSem3(request.getParameter("sem3"));
        ins.setSem4(request.getParameter("sem4"));
        ins.setTurno(request.getParameter("turno"));
        if (id == 0){
            int idn = obtenerId(request);
            ins.setId(idn);
            list.add(ins);
            
        } else {
            int pos = buscarId(request, id);
            list.set(pos, ins);
        }
        request.setAttribute("semi", list);
        response.sendRedirect("index.jsp");
    }
    
    public int buscarId (HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Inscritos> list = (ArrayList<Inscritos>) ses.getAttribute("semi");
        int pos = -1;
        if (list != null) {
            for (Inscritos i:list) {
                pos++;
                if (i.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }

    public int obtenerId (HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Inscritos> list = (ArrayList<Inscritos>) ses.getAttribute("semi");
        int idn = 0;
        for (Inscritos i:list) {
            idn = i.getId();
        }
        return idn+1;
    }
}
