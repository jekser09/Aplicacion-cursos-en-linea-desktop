package persistencia;

import Modelo.Curso;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class CursoDao {

        private final String NOMBREAP = "cursos.asi"; //Binario
        private ArrayList<Curso> cursos;

        public CursoDao() {
            if(abrirArchivo()==null){
                nuevoArchivo();
            }
        }

        private void nuevoArchivo(){
            cursos=new ArrayList();
            FileOutputStream fo = null;

            try {
                fo = new FileOutputStream(NOMBREAP);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(cursos);
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

        public boolean guardarArchivo(ArrayList<Curso> cursos) {
            FileOutputStream fo = null;
            this.cursos=cursos;
            try {
                fo = new FileOutputStream(NOMBREAP);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(this.cursos);
                oo.close();
                return true;
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
            return false;
        }

        public ArrayList<Curso> abrirArchivo() {
            FileInputStream fi = null;
            try {
                try {
                    fi = new FileInputStream(NOMBREAP);
                    ObjectInputStream oi = new ObjectInputStream(fi);
                    this.cursos = (ArrayList<Curso>)oi.readObject();
                    oi.close();
                    fi.close();
                    return cursos;
                } catch (FileNotFoundException var10) {
                    nuevoArchivo();
                } catch (IOException var11) {
                    var11.printStackTrace();
                } catch (ClassNotFoundException var12) {
                    var12.printStackTrace();
                }
                return null;
            } finally {

            }
        }
    }