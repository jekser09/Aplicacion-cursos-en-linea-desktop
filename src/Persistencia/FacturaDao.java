/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Factura;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author juans
 */
public final class FacturaDao {
    private final String NOMBREAP = "facturas.asi";
    private ArrayList<Factura> facturas;

    public FacturaDao() {
        if(abrirArchivo()==null){
            nuevoArchivo();
        }
    }

    private void nuevoArchivo(){
        facturas=new ArrayList();
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(facturas);
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

    public boolean guardarArchivo(ArrayList<Factura> facturas) {
        FileOutputStream fo = null;
        this.facturas=facturas;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(this.facturas);
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

    public ArrayList<Factura> abrirArchivo() {
        FileInputStream fi;
        try {
            try {
                fi = new FileInputStream(NOMBREAP);
                ObjectInputStream oi = new ObjectInputStream(fi);
                this.facturas = (ArrayList<Factura>)oi.readObject();
                oi.close();
                fi.close();
                return facturas;
            } catch (FileNotFoundException var10) {
                nuevoArchivo();
            } catch (IOException | ClassNotFoundException var11) {
            }
            return null;
        } finally {

        }
    }
}
