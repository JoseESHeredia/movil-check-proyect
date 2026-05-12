package com.movilcheck.dao;

import com.movilcheck.config.DBConfig;
import com.movilcheck.models.EquipoModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    public List<EquipoModel> listarEquipos() {
        List<EquipoModel> lista = new ArrayList<>();
        String sql = "SELECT id_equipo, marca, modelo_comercial, memoria_ram, almacenamiento, camara, bateria FROM Equipos";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new EquipoModel(
                    rs.getInt("id_equipo"),
                    rs.getString("marca"),
                    rs.getString("modelo_comercial"),
                    rs.getInt("memoria_ram"),
                    rs.getInt("almacenamiento"),
                    rs.getInt("camara"),
                    rs.getInt("bateria")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
