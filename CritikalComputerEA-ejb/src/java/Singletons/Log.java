/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singletons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Startup;

/**
 *
 * @author Adriel
 */
@Singleton
@Startup
@LocalBean
public class Log {

    private static final String rutaArchivo = "C:\\Users\\Adriel\\Documents\\NetBeansProjects\\CritikalComputerEA\\ArchivosGuardados\\controlAcceso.log";
    private static Logger log;
    FileHandler archivos;
    private static int segundos;

//    @Lock(LockType.READ)
//    public static Logger getLog() {
//        return log;
//    }
    @PostConstruct
    public void init() {
        log = Logger.getLogger(Log.class.getName());
        segundos = 0;
        for (Handler h : log.getHandlers()) { //Quitamos los de por defecto
            log.removeHandler(h);
        }
        try {
            archivos = new FileHandler(rutaArchivo);
            log.addHandler(archivos);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Schedule(hour = "*", minute = "*", second = "*/1")
    @Lock(LockType.WRITE)
    public void incrementarSegundos() {
        segundos++;
    }

    @Schedule(hour = "*", minute = "*", second = "*/5")
    @Lock(LockType.WRITE)
    public void actualizarLog() {
        if(segundos>=5){
            log.log(Level.INFO,"ESTOY OCIOSO");
            segundos=0;
        }
    }

    @Lock(LockType.WRITE)
    public static void guardarJSP(String rutaAcceso) {
        log.log(Level.INFO, rutaAcceso);
        segundos=0;
    }

    @Lock(LockType.WRITE)
    public static void guardarComandos(String comando) {
        log.log(Level.INFO, comando);
        segundos=0;
    }

    @Lock(LockType.WRITE)
    public static void guardarComponentes(String descripcion) {
        log.log(Level.INFO, descripcion);
        segundos=0;
    }

    @Lock(LockType.WRITE)
    public static void guardarExcepcion(String excepcion) {
        log.log(Level.INFO, excepcion);
        segundos=0;
    }

    @Lock(LockType.READ)
    public static String leerLog() {
        String resultado = "";
        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            try {
                String linea = lector.readLine();
                while (linea != null) {
                    resultado += linea;
                    linea = lector.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            Log.guardarExcepcion(ex.getMessage()); //Guardar en mi log
        }
        return resultado;
    }

}
