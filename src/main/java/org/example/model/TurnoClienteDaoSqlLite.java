package org.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TurnoClienteDaoSqlLite implements TurnoClienteRepositorio {

    private String AGREGAR_SQL = "INSERT INTO turnosClientes(nombre, telefono, fechaTurno, horaTurno) VALUES (?,?,?,?)";
    private String VER_TURNOS_DEL_DIA = "SELECT * FROM turnosClientes WHERE fechaTurno = ?";

    @Override
    public void agregarCliente(TurnoCliente turnoCliente) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(AGREGAR_SQL);
        statement.setString(1, turnoCliente.getNombre());
        statement.setInt(2, turnoCliente.getTelefono());
        statement.setString(3, turnoCliente.getFechaTurno().toString());
        statement.setString(4, turnoCliente.getHoraTurno().toString());

        statement.executeUpdate();
    }

    @Override
    public List<TurnoCliente> buscarTurnosDelDia() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(VER_TURNOS_DEL_DIA);
        statement.setString(1, LocalDate.now().toString());

        var rs = statement.executeQuery();
        List<TurnoCliente> turnos = new ArrayList<>();

        while (rs.next()) {
            TurnoCliente turnoCliente = new TurnoCliente();
            turnoCliente.setNombre(rs.getString("nombre"));
            turnoCliente.setTelefono(rs.getInt("telefono"));
            turnoCliente.setFechaTurno(LocalDate.parse(rs.getString("fechaTurno")));
            turnoCliente.setHoraTurno(LocalTime.parse(rs.getString("horaTurno")));
            turnos.add(turnoCliente);
        }

        return turnos;
    }

    @Override
    public List<TurnoCliente> burcarTurnosDeUnDia(String dia) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        return new ArrayList<>();
    }
}
