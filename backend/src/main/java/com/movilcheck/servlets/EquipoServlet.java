package com.movilcheck.servlets;

import com.movilcheck.dao.EquipoDAO;
import com.movilcheck.models.EquipoModel;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/equipos")
public class EquipoServlet extends HttpServlet {
    private EquipoDAO equipoDAO = new EquipoDAO();
    private Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Configuramos la respuesta para que Azure y React se entiendan (JSON)
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        List<EquipoModel> equipos = equipoDAO.listarEquipos();
        String json = this.gson.toJson(equipos);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
