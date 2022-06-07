/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Curso;
import Modelo.UsuarioCurso;
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
public final class UsuarioCursoDao {
    private final String NOMBREAP = "UsuarioCurso.asi"; //Binario
        private ArrayList<UsuarioCurso> registrados;

        public UsuarioCursoDao(){
            if(abrirArchivo()==null){
                nuevoArchivo();
            }
        }

        private void nuevoArchivo(){
            registrados=new ArrayList();
            FileOutputStream fo = null;

            try {
                fo = new FileOutputStream(NOMBREAP);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(registrados);
                oo.close();
            } catch (FileNotFoundException var16) {
                var16.printStackTrace();
            } catch (IOException var17) {
                var17.printStackTrace();
            } finally {
                try {
                    fo.close();
                } catch (IOException var15) {
                }
            }
        }

        public boolean guardarArchivo(ArrayList<UsuarioCurso> lista) {
            FileOutputStream fo = null;
            this.registrados=lista;
            try {
                fo = new FileOutputStream(NOMBREAP);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(this.registrados);
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

        public ArrayList<UsuarioCurso> abrirArchivo() {
            FileInputStream fi;
            try {
                try {
                    fi = new FileInputStream(NOMBREAP);
                    ObjectInputStream oi = new ObjectInputStream(fi);
                    this.registrados = (ArrayList<UsuarioCurso>)oi.readObject();
                    oi.close();
                    fi.close();
                    return registrados;
                } catch (FileNotFoundException var10) {
                    nuevoArchivo();
                } catch (IOException | ClassNotFoundException var11) {
                }
                return null;
            } finally {

            }
        }
    
}
