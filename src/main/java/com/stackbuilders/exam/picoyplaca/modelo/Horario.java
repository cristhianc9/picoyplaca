/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilders.exam.picoyplaca.modelo;

import java.util.Calendar;

/**
 *
 * @author CRISTHIAN
 */
public class Horario {

    private int id;
    private String descripcion;
    private Calendar horaDesde;
    private Calendar horaHasta;

    public Horario(int id, String descripcion, Calendar horaDesde, Calendar horaHasta) {
        this.id = id;
        this.descripcion = descripcion;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(Calendar horaDesde) {
        this.horaDesde = horaDesde;
    }

    public Calendar getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(Calendar horaHasta) {
        this.horaHasta = horaHasta;
    }

}
