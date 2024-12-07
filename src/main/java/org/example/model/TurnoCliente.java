package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoCliente {
    private int telefono;
    private String nombre;
    private LocalDate fechaTurno;
    private LocalTime horaTurno;

    public TurnoCliente() {
    }

    public TurnoCliente(int telefono, String nombre, LocalDate fechaTurno, LocalTime horaTurno) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public LocalTime getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(LocalTime horaTurno) {
        this.horaTurno = horaTurno;
    }

    @Override
    public String toString() {
        return "\nNombre: " + this.nombre
                + "\nTelfono: " + this.telefono
                + "\nFecha: " + this.fechaTurno
                + "\nHora: " + this.horaTurno + "\n";
    }
}
