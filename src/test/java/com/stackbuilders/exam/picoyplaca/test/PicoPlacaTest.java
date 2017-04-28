/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilders.exam.picoyplaca.test;

import com.stackbuilders.exam.picoyplaca.modelo.Horario;
import com.stackbuilders.exam.picoyplaca.modelo.PicoPlaca;
import com.stackbuilders.exam.picoyplaca.servicio.PicoPlacaServicio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CRISTHIAN
 */
public class PicoPlacaTest {

    PicoPlacaServicio servicio;

    public PicoPlacaTest() {
        servicio = new PicoPlacaServicio();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void verificarPicoPlaca() {

        // DATOS DE INGRESO
        final String placa = "PCH-1806";
        final String fecha = "26-04-2017";
        final String hora = "09:00";
        Calendar fechaHoraConFormato = obtenerFechaHora(fecha, hora);

        System.out.println("Dia de la fecha ingresada = " + fechaHoraConFormato.getDisplayName(Calendar.DAY_OF_WEEK, 2, new Locale("es")) + "(" + fechaHoraConFormato.get(Calendar.DAY_OF_WEEK) + ")");
        System.out.println("Hora ingresada = " + fechaHoraConFormato.get(Calendar.HOUR_OF_DAY) + ":" + fechaHoraConFormato.get(Calendar.MINUTE));

        final String ultimoDigito = obtenerUltimoDigito(placa);
        System.out.println("Para la Placa Nro. " + placa + " el último digito es: " + ultimoDigito);

        PicoPlaca picoPlaca = validarPicoPlaca(fechaHoraConFormato.get(Calendar.DAY_OF_WEEK),
                fechaHoraConFormato, ultimoDigito);
        if (picoPlaca == null) {
            System.out.println("Su vehiculo con placa Nro. " + placa + " SI tiene permitido circular");
        } else {
            System.out.println("Horario de Pico y Placa: " + picoPlaca.getDiaEnum().getNombreDia() + " " + picoPlaca.getHorario().getDescripcion() + " digito: " + picoPlaca.getUltimoDigito());
            System.out.println("**Su vehiculo con placa Nro. " + placa + " NO tiene permitido circular");
        }

    }

    private PicoPlaca validarPicoPlaca(int dia, Calendar hora, String ultimoDigito) {

        for (PicoPlaca picoPlacaValidar : servicio.obtenerListaPicoPlaca()) {
            System.out.println("Dia " + picoPlacaValidar.getDiaEnum().getNumeroDia() + " digito " + picoPlacaValidar.getUltimoDigito() + " esta en horario: " + estaEnHorario(picoPlacaValidar.getHorario(), hora));
            if (dia == picoPlacaValidar.getDiaEnum().getNumeroDia()
                    && picoPlacaValidar.getUltimoDigito().equals(ultimoDigito)
                    && estaEnHorario(picoPlacaValidar.getHorario(), hora)) {
                return picoPlacaValidar;
            }
        }
        return null;
    }

    private static String obtenerUltimoDigito(String placa) {
        if (placa == null || placa.isEmpty()) {
            return null;
        }
        int tamanio = placa.length();
        return placa.substring(tamanio - 1, tamanio);
    }

    private boolean estaEnHorario(Horario horario, Calendar hora) {
        Calendar horarioDesde = Calendar.getInstance();
        horarioDesde.setTime(hora.getTime());
        horarioDesde.set(Calendar.HOUR_OF_DAY, horario.getHoraDesde().get(Calendar.HOUR_OF_DAY));
        horarioDesde.set(Calendar.MINUTE, horario.getHoraDesde().get(Calendar.MINUTE));
        horarioDesde.set(Calendar.SECOND, 0);
        horarioDesde.set(Calendar.MILLISECOND, 0);

        Calendar horarioHasta = Calendar.getInstance();
        horarioHasta.setTime(hora.getTime());
        horarioHasta.set(Calendar.HOUR_OF_DAY, horario.getHoraHasta().get(Calendar.HOUR_OF_DAY));
        horarioHasta.set(Calendar.MINUTE, horario.getHoraHasta().get(Calendar.MINUTE));
        horarioHasta.set(Calendar.SECOND, 0);
        horarioHasta.set(Calendar.MILLISECOND, 0);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        
        System.out.println("DESDE " + formato.format(horarioDesde.getTime()) 
                + " HASTA " + formato.format(horarioHasta.getTime()) 
                + " HORA VALIDAR " + formato.format(hora.getTime()));
        
        return (hora.compareTo(horarioDesde) >= 0 && hora.compareTo(horarioHasta) <= 0);
    }

    private Calendar obtenerFechaHora(String fecha, String hora) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        Calendar fechaCal = null;
        try {
            format.parse(fecha + " " + hora);
            fechaCal = Calendar.getInstance();
            fechaCal.setTime(format.parse(fecha + " " + hora));
        } catch (ParseException ex) {
            Logger.getLogger(PicoPlacaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaCal;
    }
}
