package org.example.model;

import java.sql.SQLException;
import java.util.List;

public interface TurnoClienteRepositorio {
    void agregarCliente(TurnoCliente turnoCliente) throws SQLException;

    List<TurnoCliente> buscarTurnosDelDia() throws SQLException;

    List<TurnoCliente> burcarTurnosDeUnDia(String dia) throws SQLException;
}
