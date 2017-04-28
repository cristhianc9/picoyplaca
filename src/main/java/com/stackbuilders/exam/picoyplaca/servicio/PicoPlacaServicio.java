/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilders.exam.picoyplaca.servicio;

import com.stackbuilders.exam.picoyplaca.modelo.Horario;
import com.stackbuilders.exam.picoyplaca.modelo.PicoPlaca;
import com.stackbuilders.exam.picoyplaca.utils.DiaEnum;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author CRISTHIAN
 */
public class PicoPlacaServicio {

    public List<PicoPlaca> obtenerListaPicoPlaca() {
        List<PicoPlaca> listaPicoPlaca = new ArrayList<>();
        listaPicoPlaca.add(new PicoPlaca(1, DiaEnum.LUN, getHorarioDiurno(), "1"));
        listaPicoPlaca.add(new PicoPlaca(2, DiaEnum.LUN, getHorarioNocturno(), "1"));
        listaPicoPlaca.add(new PicoPlaca(3, DiaEnum.LUN, getHorarioDiurno(), "2"));
        listaPicoPlaca.add(new PicoPlaca(4, DiaEnum.LUN, getHorarioNocturno(), "2"));
        
        listaPicoPlaca.add(new PicoPlaca(5, DiaEnum.MAR, getHorarioDiurno(), "3"));
        listaPicoPlaca.add(new PicoPlaca(6, DiaEnum.MAR, getHorarioNocturno(), "3"));
        listaPicoPlaca.add(new PicoPlaca(7, DiaEnum.MAR, getHorarioDiurno(), "4"));
        listaPicoPlaca.add(new PicoPlaca(8, DiaEnum.MAR, getHorarioNocturno(), "4"));
        
        listaPicoPlaca.add(new PicoPlaca(9, DiaEnum.MIE, getHorarioDiurno(), "5"));
        listaPicoPlaca.add(new PicoPlaca(10, DiaEnum.MIE, getHorarioNocturno(), "5"));
        listaPicoPlaca.add(new PicoPlaca(11, DiaEnum.MIE, getHorarioDiurno(), "6"));
        listaPicoPlaca.add(new PicoPlaca(12, DiaEnum.MIE, getHorarioNocturno(), "6"));
        
        listaPicoPlaca.add(new PicoPlaca(13, DiaEnum.JUE, getHorarioDiurno(), "7"));
        listaPicoPlaca.add(new PicoPlaca(14, DiaEnum.JUE, getHorarioNocturno(), "7"));
        listaPicoPlaca.add(new PicoPlaca(15, DiaEnum.JUE, getHorarioDiurno(), "8"));
        listaPicoPlaca.add(new PicoPlaca(16, DiaEnum.JUE, getHorarioNocturno(), "8"));
        
        listaPicoPlaca.add(new PicoPlaca(17, DiaEnum.VIE, getHorarioDiurno(), "9"));
        listaPicoPlaca.add(new PicoPlaca(18, DiaEnum.VIE, getHorarioNocturno(), "9"));
        listaPicoPlaca.add(new PicoPlaca(19, DiaEnum.VIE, getHorarioDiurno(), "0"));
        listaPicoPlaca.add(new PicoPlaca(20, DiaEnum.VIE, getHorarioNocturno(), "0"));
        
        return listaPicoPlaca;
    }

    public Horario getHorarioNocturno() {
        Calendar horaDesde = Calendar.getInstance();
        horaDesde.set(Calendar.HOUR_OF_DAY, 16);
        horaDesde.set(Calendar.MINUTE, 0);
        horaDesde.set(Calendar.SECOND, 0);

        Calendar horaHasta = Calendar.getInstance();
        horaHasta.set(Calendar.HOUR_OF_DAY, 19);
        horaHasta.set(Calendar.MINUTE, 30);
        horaHasta.set(Calendar.SECOND, 0);

        return new Horario(1, "De 16:00 a 19:30", horaDesde, horaHasta);
    }

    public Horario getHorarioDiurno() {
        Calendar horaDesde = Calendar.getInstance();
        horaDesde.set(Calendar.HOUR_OF_DAY, 7);
        horaDesde.set(Calendar.MINUTE, 0);
        horaDesde.set(Calendar.SECOND, 0);

        Calendar horaHasta = Calendar.getInstance();
        horaHasta.set(Calendar.HOUR_OF_DAY, 9);
        horaHasta.set(Calendar.MINUTE, 30);
        horaHasta.set(Calendar.SECOND, 0);

        return new Horario(2, "De 7:00 a 9:30", horaDesde, horaHasta);
    }

}
