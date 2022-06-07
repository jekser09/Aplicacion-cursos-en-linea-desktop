/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Pregunta;
import Modelo.Diploma;
import Persistencia.DiplomaDao;
import Persistencia.PreguntaDao;
import Persistencia.RespuestaDao;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author juans
 */
public final class DiplomaCtrl{
    private Date fecha;  
    private Diploma diploma;
    private final DiplomaDao dipDao=new DiplomaDao();;
    private final PreguntaDao preDao=new PreguntaDao();
    private final RespuestaDao resDao=new RespuestaDao();
    private final UsuarioCtrl usuCtrl;
    private final CursoCtrl curCrtl;
    private ArrayList<Diploma> diplomas;
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Pregunta> respuestas;
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    /**
    *@param usuCtrl
    * @param curCtrl
    */
    public DiplomaCtrl(UsuarioCtrl usuCtrl,CursoCtrl curCtrl){
        this.usuCtrl=usuCtrl;
        this.curCrtl=curCtrl;
        cargarDiplomas();
        cargarPreguntas();
        cargarRespuestas();
        if(diplomas==null) diplomas=new ArrayList<>();
        if(preguntas==null) preguntas=new ArrayList<>();
        if(respuestas==null) respuestas=new ArrayList<>();
        
    }
    
    
    
    private void guardarDiplomas(){
        dipDao.guardarArchivo(diplomas);
    }
    
    private void guardarPreguntas(){
        preDao.guardarArchivo(preguntas);
    }
    
    private void guardarRespuestas(){
        resDao.guardarArchivo(respuestas);
    }
    
    public void cargarRespuestas(){
        respuestas=resDao.abrirArchivo();
        
    }
    
    public void cargarPreguntas(){
        preguntas=preDao.abrirArchivo();
    }
    
    public void cargarDiplomas(){
        diplomas=dipDao.abrirArchivo();
    }
    
    public boolean generarPregunta(Pregunta preg){
        if(preg==null) return false;
        preguntas.add(preg);
        guardarPreguntas();
        return true;
    }
    
    public ArrayList<Pregunta> preguntasCurso(int codCurso){
        if(preguntas.isEmpty()) return null;
        ArrayList<Pregunta> lista=new ArrayList<>();
        for(Pregunta aux:preguntas){
            if(aux.getCodCurso()==codCurso) lista.add(aux);
        }
        if(lista.isEmpty()) return null;
        return lista;
    }
    
    public boolean responderPreguntas(ArrayList<Pregunta> respt){
        if(respt==null)return false;        
        ArrayList<Pregunta> lista=respt;
        if(preguntasCurso(lista.get(0).getCodCurso())==null)return false;         
        for(int i=0;i<respt.size();i++){
            respuestas.add(respt.get(i));
        }
        guardarRespuestas();
        return true;
    }
          
    public ArrayList<Pregunta> respuestasPersona(int cedula){
        cargarRespuestas();
        if(respuestas.isEmpty()) return null;
        ArrayList<Pregunta> lista=new ArrayList<>();
        for(Pregunta aux:respuestas){
            if(aux.getCedula()==cedula){
                lista.add(aux);
            }
        }        
        return lista;
    }
    
    public void eliminarPreguntas(int cod){
        for(Pregunta preg:preguntas){
            if(preg.getCodCurso()==cod){
                preguntas.remove(preg);
            }
        }
        guardarPreguntas();
    }
    
    private float calificar(ArrayList<Pregunta> resp){
        float nota=0;
        for(int i=0;i<resp.size();i++){
            if(resp.get(i).isCorrecto()) nota=nota+1;
        }
        return nota/resp.size();
    }
    
    private boolean generarDiploma(Diploma diplo){
        if(diplo==null) return false;
        if(buscarDiploma(diplo.getCedula(),diplo.getCodCurso())!=null) return false;
        diplomas.add(diplo);
        guardarDiplomas();
        return true;
    }
    
    public Diploma buscarDiploma(int cedula,int codCurso){
        if(diplomas.isEmpty()) return null;
        for(Diploma aux:diplomas){
            if(aux.getCedula()==cedula && aux.getCodCurso()==codCurso) return aux;                    
        }
        return null;
    }
    
    public ArrayList<Diploma> diplomasPersona(int cedula){        
        if(diplomas.isEmpty()) return null;       
        ArrayList<Diploma> lista=new ArrayList<>();
        for(Diploma aux:diplomas){
            if(aux.getCedula()==cedula){                
                lista.add(aux);
            }
            
        }
        return lista;
    }
    
    public DefaultTableModel tabla(int cedula){
        cargarDiplomas();
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Titulo");
        modelo.addColumn("Cedula");
        modelo.addColumn("Codigo curso");
        modelo.addColumn("Fecha");
        String[] datos=new String[4];
        for(Diploma aux:diplomas){
            if(aux.getCedula()==cedula){
                datos[0]=aux.getTitulo();
                datos[1]=String.valueOf(aux.getCedula());
                datos[2]=String.valueOf(aux.getCodCurso());
                datos[3]=dateFormat.format(aux.getFecha());
                modelo.addRow(datos);
            }
        }
        return modelo;
    }
    
    
    
    public boolean certificar(ArrayList<Pregunta> respuestas,int cedula,int codCurso){
        if(respuestas==null) return false;        
        if(calificar(respuestas)>=0.7){                    
            diploma=new Diploma(curCrtl.buscarCurso(codCurso).getNombreCurso(),
                                fecha=new Date(),
                                usuCtrl.buscarUsuario(cedula).getNombre(),
                                cedula,
                                codCurso,
                                "Felicidades por graduarte del curso, aqui esta tu diploma pana <3");
            generarDiploma(diploma);
            guardarDiplomas();
            return true;
        }
        return false;
    }
    
}
