/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Jekse
 */
public final class FactuActual {
    private final String NOMBREAP = "codActual.asi"; //Binario        
    private int codActual;
    public FactuActual() {            
        if(abrirArchivo()==0){
            nuevoArchivo();
        }
    }

    private void nuevoArchivo(){
        int codFac=0;
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(codFac);
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

    public boolean guardarArchivo(int cod) {
        FileOutputStream fo = null;
        codActual=cod;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(codActual);
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

    public int abrirArchivo() {
        FileInputStream fi;
        try {
            try {
                fi = new FileInputStream(NOMBREAP);
                ObjectInputStream oi = new ObjectInputStream(fi);
                codActual = (int)oi.readObject();
                oi.close();
                fi.close();
                return codActual;
            } catch (FileNotFoundException var10) {
                nuevoArchivo();
            } catch (IOException | ClassNotFoundException var11) {
            }
            return 0;
        } finally {

        }
    }
}
