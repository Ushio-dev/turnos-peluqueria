package org.example;

import org.example.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int opc;
            Connection connection = DatabaseConnection.getConnection();
            DatabaseManager.GenerateTables(connection);
            TurnoClienteRepositorio turnoClienteDao = new TurnoClienteDaoSqlLite();

            do {
                opc = menu();

                switch (opc) {
                    case 1: {
                        //TODO Modificar el formato de la fecha a dd/mm/aaaa

                        System.out.println("Telefono: ");
                        int telefono = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Nombre: ");
                        String nombre = scanner.nextLine();
                        scanner.nextLine();

                        System.out.println("Fecha: ");
                        String fecha = scanner.nextLine();
                        scanner.nextLine();

                        System.out.println("Hora");
                        String hora = scanner.nextLine();
                        scanner.nextLine();


                        TurnoCliente nuevoTurno = new TurnoCliente(telefono
                                , nombre
                                , LocalDate.parse(fecha)
                                , LocalTime.parse(hora));


                        turnoClienteDao.agregarCliente(nuevoTurno);
                        break;
                    }

                    case 2: {
                        System.out.println("Mostrar Turnos");
                        List<TurnoCliente> turnos = turnoClienteDao.buscarTurnosDelDia();

                        turnos.forEach(System.out::println);
                        break;
                    }
                    case 3: {
                        System.out.println("Mostrar Turnos");
                        System.out.println("Ingrese dia");
                        String dia = scanner.nextLine();
                        scanner.nextLine();

                    }
                }
            } while (opc != 0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Cargar Turno");
        System.out.println("2-Mostrar Turnos del dia");
        System.out.println("3-Mostrar Turnos de un dia");
        System.out.println("4-Eliminar Turno");
        System.out.println("5-Modificar Turno");
        System.out.println("6-Buscar Turno");
        System.out.println("0-Salir");
        int opc = scanner.nextInt();
        return opc;
    }
}