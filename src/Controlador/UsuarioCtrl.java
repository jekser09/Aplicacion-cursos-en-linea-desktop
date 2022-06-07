/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Diploma;
import Modelo.Usuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import persistencia.UsuarioDao;
/**
 *
 * @author juans
 */
//Clase para controlar usuarios
public final class UsuarioCtrl {    
    private final UsuarioDao usuarioDao = new UsuarioDao();;
    private ArrayList<Usuario> listaUsuario;

    public UsuarioCtrl() {        
        cargarUsuarios();
        if(listaUsuario == null){
            listaUsuario=new ArrayList();
        }       
    }
    // Metodo para actualizar la persistencia (Archivo binario)
    private void actualizarArchivo(){
        usuarioDao.guardarArchivo(listaUsuario);
    }
    //Metodo para leer el archivo de usuarios
    public void cargarUsuarios(){
        listaUsuario=usuarioDao.abrirArchivo();
    }
    
    public ArrayList<Usuario> usuarios(){
        cargarUsuarios();
        return listaUsuario;
    }
    // Funcion para registro de usuarios
    public boolean registrar(Usuario usuario){
        if(buscarUsuario(usuario.getCedula()) != null) return false;
        if(usuario.getCedula()<=0) return false;
        listaUsuario.add(usuario);
        actualizarArchivo();
        return true;
    }
    
    public DefaultTableModel tablaUsuarios(){
        cargarUsuarios();
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("edad");        
        String[] datos=new String[3];
        for(Usuario aux:listaUsuario){
            if(aux.getTipoUsuario()==1){
                datos[0]=String.valueOf(aux.getCedula());
                datos[1]=aux.getNombre();
                datos[2]=String.valueOf(aux.getEdad());            
                modelo.addRow(datos);
            }
        }
        return modelo;
    }
    // Funcion para busar un usuario segun su documento
    public Usuario buscarUsuario(int cedula){
        cargarUsuarios();
        if(listaUsuario.isEmpty()) return null;
        for(Usuario usuAux:listaUsuario){
            if(usuAux.getCedula()==cedula) return usuAux;            
        }       
        return null;
    }
    // Funcion para 'iniciar sesion'
    public int inicioSesion(int cedula, String contraseña){
        if(buscarUsuario(cedula)!= null){
            if(buscarUsuario(cedula).getContraseña().equals(contraseña)){
                return buscarUsuario(cedula).getTipoUsuario();
            }
        }
        return 0;
    }
}
