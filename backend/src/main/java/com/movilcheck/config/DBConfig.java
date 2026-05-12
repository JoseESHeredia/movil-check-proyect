package com.movilcheck.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    // Estos datos los llenaremos cuando creemos el recurso en el portal de Azure
    private static final String URL = "jdbc:sqlserver://tu-servidor.database.windows.net:1433;database=movilcheck-db";
    private static final String USER = "usuario_azure";
    private static final String PASS = "tu_contraseña";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver de Azure SQL no encontrado", e);
        }
    }
}
