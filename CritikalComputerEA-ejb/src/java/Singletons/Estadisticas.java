/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singletons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
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
public class Estadisticas {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static int UsuariosInicioSession;
    private static HashMap<String,Integer> RegistroPagina;
    private static HashMap<String,Integer> RegistroComponentes;
    private static HashMap<String,HashMap<String,Integer>> RegistroComponentesUsuario;
    private final String rutaArchivo="C:\\Users\\Adriel\\Documents\\NetBeansProjects\\CritikalComputerEA\\ArchivosGuardados\\Estadisticas.json";

    @Lock(LockType.READ)
    public static int getUsuariosInicioSession() {
        return UsuariosInicioSession;
    }
    
    @Lock(LockType.READ)
    public static HashMap<String, Integer> getRegistroPagina() {
        return new HashMap<>(RegistroPagina);
    }

    @Lock(LockType.READ)
    public static HashMap<String, Integer> getRegistroComponentes() {
        return new HashMap<>(RegistroComponentes);
    }

    @Lock(LockType.READ)
    public static HashMap<String, HashMap<String, Integer>> getRegistroComponentesUsuario() {
        return new HashMap<>(RegistroComponentesUsuario);
    }
   
    @Lock(LockType.WRITE)
    public static void incrementarLogin(){
        UsuariosInicioSession++;
    }
    @Lock(LockType.WRITE)
    public static void incrementarRegistroPagina(String pagina){
        if (RegistroPagina.containsKey(pagina)) RegistroPagina.put(pagina, RegistroPagina.get(pagina)+1);
        else RegistroPagina.put(pagina, 1);
    }
    
    @Lock(LockType.WRITE)
    public static void incrementarRegistroComponentes(String componente){
        if (RegistroComponentes.containsKey(componente)) RegistroComponentes.put(componente, RegistroComponentes.get(componente)+1);
        else RegistroComponentes.put(componente, 1);
    }
    @Lock(LockType.WRITE)
    public static void incrementarRegistroComponentesUsuario(String componente, String usuario){
        if(RegistroComponentesUsuario.containsKey(usuario)){
            if (RegistroComponentesUsuario.get(usuario).containsKey(componente)) {
                RegistroComponentesUsuario.get(usuario).put(componente, RegistroComponentesUsuario.get(usuario).get(componente)+1);
            }else{
                RegistroComponentesUsuario.get(usuario).put(componente,1);
            }
        }else{
            RegistroComponentesUsuario.put(usuario, new HashMap<>());
            RegistroComponentesUsuario.get(usuario).put(componente, 1);
        }
    }
    @Schedule(hour = "*",minute = "*",second = "*/5")
    public  void guardarEnDisco() throws IOException{
        FileWriter salida= new FileWriter(rutaArchivo);
//        GsonBuilder builder=new GsonBuilder();
//        builder.excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT);
//        Gson guardarEnDisco= builder.create();
//        try (Writer writer= salida) {
//            guardarEnDisco.toJson(this,writer);
//        } catch (Exception e) {
//        }
        salida.write(rutaArchivo);
    }
    
    @PostConstruct
    public void init(){
        UsuariosInicioSession=0;
        RegistroPagina=new HashMap<>();
        RegistroComponentes=new HashMap<>();
        RegistroComponentesUsuario= new HashMap<>();
    }
    
    
}
