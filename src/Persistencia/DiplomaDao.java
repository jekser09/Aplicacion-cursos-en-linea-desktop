/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Diploma;
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
public class DiplomaDao {
    private final String NOMBREAP = "diplomas.asi";
    private ArrayList<Diploma> diplomas;
    
    public DiplomaDao(){
        if(abrirArchivo()==null){
            nuevoArchivo();
        }
    }
    
    private void nuevoArchivo(){
        diplomas=new ArrayList();
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(diplomas);
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
    
    public boolean guardarArchivo(ArrayList<Diploma> diplo) {
        FileOutputStream fo = null;
        diplomas=diplo;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo;
            oo = new ObjectOutputStream(fo);
            oo.writeObject(diplomas);
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

    public ArrayList<Diploma> abrirArchivo() {
        FileInputStream fi;
        try {
            try {
                fi = new FileInputStream(NOMBREAP);
                ObjectInputStream oi = new ObjectInputStream(fi);
                diplomas = (ArrayList<Diploma>)oi.readObject();
                oi.close();
                fi.close();
                return diplomas;
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
