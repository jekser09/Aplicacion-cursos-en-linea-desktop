/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Curso;
import Modelo.Factura;
import Modelo.UsuarioCurso;
import Persistencia.UsuarioCursoDao;
import Utilitarios.Imagenes;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import persistencia.CursoDao;

/**
 *
 * @author Johand Esteban Castro Rodriguez
 */
public final class CursoCtrl {
    private ArrayList<Curso> listaCursos;
    private ArrayList<UsuarioCurso> listaInscritos;
    private final CursoDao cursoDao = new CursoDao();;
    private final FacturaCtrl facturaCtrl= new FacturaCtrl();
    private final Factura factura=new Factura();
    private final UsuarioCurso usuCur=new UsuarioCurso();
    private final UsuarioCursoDao usuCurDao=new UsuarioCursoDao();    
    private final Imagenes imgs=new Imagenes();   

    public CursoCtrl() {       
        cargarCursos();
        cargarInscritos();
        if(listaCursos == null) listaCursos=new ArrayList();
        if(listaInscritos==null) listaInscritos=new ArrayList();        
    }
    
    private void guardarCursos(){
        cursoDao.guardarArchivo(listaCursos);        
    }
    
    private void guardarInscritos(){
        usuCurDao.guardarArchivo(listaInscritos);
    }
    
    public void cargarCursos(){
        listaCursos = cursoDao.abrirArchivo();        
    }
    
    public void cargarInscritos(){
        listaInscritos=usuCurDao.abrirArchivo();
        
    }
    
    public boolean añadirCurso(Curso curso,String ruta){
        if(curso == null)return false;            
        if(buscarCurso(curso.getCodigoCurso()) != null) return false;        
        if(!imgs.subir(ruta,curso.getFotoCurso())) return false;
        listaCursos.add(curso);
        guardarCursos();
        return true;
    }
    
    public Curso buscarCurso(int codigoCurso){
        if(listaCursos.isEmpty()) return null;
        for(Curso curAux:listaCursos){
            if(curAux.getCodigoCurso()==codigoCurso){
                return curAux;
            }
        }
        return null;
    }
    
    public boolean eliminarCurso(int codigoCurso,String ruta){
        if(ruta.equals("")) return false;         
        if(!imgs.borrar(buscarCurso(codigoCurso).getFotoCurso())) return false;
        listaCursos.remove(buscarCurso(codigoCurso));
        guardarCursos();
        eliminarInscritos(codigoCurso);
        //dipCt.eliminarPreguntas(codigoCurso);
        return true;       
    }
    
    private void eliminarInscritos(int cod){
        listaInscritos.stream().filter(aux -> (cod==aux.getCodCurso())).forEachOrdered(aux -> {
            listaInscritos.remove(aux);
        });
        guardarInscritos();
    }
    
    public boolean actualizarCurso(Curso curso,String ruta){
        if(curso==null) return false;
        if(!imgs.subir(ruta, curso.getFotoCurso())) return false;
        for(int i=0;i<listaCursos.size();i++){
            if(listaCursos.get(i).getCodigoCurso()==curso.getCodigoCurso()){
                listaCursos.set(i, curso);
                guardarCursos();
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Curso> cursos(){
        cargarCursos();
        return listaCursos;
    }
    
    public ArrayList<UsuarioCurso>inscritos(){
        if(listaCursos.isEmpty()) return null;
        return listaInscritos;
    }

    public boolean inscrito(int codCurso,int cedula){
        if(listaCursos.isEmpty()) return false;
        return listaInscritos.stream().anyMatch(aux -> (aux.getCodCurso()==codCurso && aux.getCedula()==cedula));
    }
    
    public ArrayList<UsuarioCurso> cursosPersona(int cedula){
        cargarCursos();
        cargarInscritos();
        if(listaInscritos.isEmpty()) return null;
        ArrayList<UsuarioCurso> lista=new ArrayList();
        listaInscritos.stream().filter(aux -> (aux.getCedula()==cedula)).forEachOrdered(aux -> {
            lista.add(aux);
        });
        return lista;
    }
    
    public boolean inscribirse(int codCurso, int cedula,String nombre,String metPago,String direccion){
        cargarCursos();
        cargarInscritos();
        if(listaCursos.isEmpty()) return false;
        if(buscarCurso(codCurso)==null) return false;
        if(inscrito(codCurso, cedula)) return false;
        usuCur.setCedula(cedula);
        usuCur.setCodCurso(codCurso);
        listaInscritos.add(usuCur);
        factura.setCedula(cedula);
        factura.setCodCurso(codCurso);
        factura.setCosto(buscarCurso(codCurso).getValorCurso());
        factura.setDireccion(direccion);
        factura.setEstadoPago(false);
        factura.setMetodoPago(metPago);
        factura.setNombre(nombre);
        facturaCtrl.generarFac(factura);
        guardarInscritos();
        return true; 
    }
    
    public DefaultTableModel tabla(){
        cargarCursos();
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Valor");
        String []datos=new String[3];
        for(int i=0;i<listaCursos.size();i++){
            datos[0]=String.valueOf(listaCursos.get(i).getCodigoCurso());
            datos[1]=listaCursos.get(i).getNombreCurso();
            datos[2]=String.valueOf(listaCursos.get(i).getValorCurso());
            modelo.addRow(datos);
        }
        return modelo;
    }
}
