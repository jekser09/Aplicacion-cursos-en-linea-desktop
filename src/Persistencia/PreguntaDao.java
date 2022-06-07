/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;


import Modelo.Pregunta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jekse
 */
public class PreguntaDao {
    private final String NOMBREAP = "cuestionarios.asi";
    private ArrayList<Pregunta> preguntas;
    
    public PreguntaDao(){
        if(abrirArchivo()==null){
            nuevoArchivo();
        }
    }
    
    private void nuevoArchivo(){
        preguntas=new ArrayList();
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(preguntas);
            oo.close();
        } catch (FileNotFoundException var16) {
        } catch (IOException var17) {
        } finally {
            try {
                fo.close();
            } catch (IOException var15) {
            }
        }
    }
    
    public boolean guardarArchivo(ArrayList<Pregunta> preg) {
        FileOutputStream fo = null;
        preguntas=preg;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo;
            oo = new ObjectOutputStream(fo);
            oo.writeObject(preguntas);
            oo.close();
            return true;
        } catch (FileNotFoundException var16) {
        } catch (IOException var17) {
        } finally {
            try {
                fo.close();
            } catch (IOException var15) {
            }
        }
        return false;
    }

    public ArrayList<Pregunta> abrirArchivo() {
        FileInputStream fi;
        try {
            try {
                fi = new FileInputStream(NOMBREAP);
                ObjectInputStream oi = new ObjectInputStream(fi);
                preguntas = (ArrayList<Pregunta>)oi.readObject();
                oi.close();
                fi.close();
                return preguntas;
            } catch (FileNotFoundException var10) {
                nuevoArchivo();
            } catch (IOException var11){
            } catch (ClassNotFoundException var12){
            }
            return null;
        } finally {

        }
    }
}
