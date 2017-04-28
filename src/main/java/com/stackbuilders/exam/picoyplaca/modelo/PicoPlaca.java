/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilders.exam.picoyplaca.modelo;

import com.stackbuilders.exam.picoyplaca.utils.DiaEnum;

/**
 *
 * @author CRISTHIAN
 */
public class PicoPlaca {

    private int id;
    private DiaEnum diaEnum;
    private Horario horario;
    private String ultimoDigito;

    public PicoPlaca(int id, DiaEnum diaEnum, Horario horario, String ultimoDigito) {
        this.id = id;
        this.diaEnum = diaEnum;
        this.horario = horario;
        this.ultimoDigito = ultimoDigito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiaEnum getDiaEnum() {
        return diaEnum;
    }

    public void setDiaEnum(DiaEnum diaEnum) {
        this.diaEnum = diaEnum;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getUltimoDigito() {
        return ultimoDigito;
    }

    public void setUltimoDigito(String ultimoDigito) {
        this.ultimoDigito = ultimoDigito;
    }

    @Override
    public String toString() {
        return "PicoPlaca{" + "id=" + id + ", diaEnum=" + diaEnum + ", horario=" + horario + ", ultimoDigito=" + ultimoDigito + '}';
    }

}
