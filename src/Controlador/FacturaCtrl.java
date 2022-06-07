/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Factura;
import Persistencia.FacturaDao;
import Utilitarios.FactuActual;
import java.util.ArrayList;


/**
 *
 * @author juans
 */
public class FacturaCtrl {       
    private final FacturaDao facDao;    
    private ArrayList<Factura> listaFac;
    private final FactuActual util=new FactuActual();;
    private final int CODACTUAL=util.abrirArchivo();
    
    
    public FacturaCtrl() {        
        facDao=new FacturaDao();
        listaFac=facDao.abrirArchivo();        
        if(listaFac==null){
            listaFac=new ArrayList();
        }
    }
    
    private void actualizarArchivo(){
        facDao.guardarArchivo(listaFac);
    }
    
    public boolean generarFac(Factura factura){            
        if(factura==null) return false;        
        if(buscarFactura(factura.getCedula(),factura.getCodCurso())!=null) return false;
        factura.setCodigoFactura(CODACTUAL+1);
        util.guardarArchivo(CODACTUAL+1);        
        listaFac.add(factura);
        actualizarArchivo();
        return true;
    }
    
    public Factura buscarFactura(int cedula,int codCurso){
        if(listaFac.isEmpty()) return null;
        for(Factura facAux:listaFac){
            if(facAux.getCedula()==cedula && facAux.getCodCurso()==codCurso){
                return facAux;
            }
        }
        return null;
    }
    
    public ArrayList facturasPersona(int cedula){
        if(listaFac.isEmpty()) return null;
        ArrayList<Factura> lista=new ArrayList<>();                
        for(Factura facAux:listaFac){
            if(facAux.getCedula()==cedula){
                lista.add(facAux);
            }
        }
        return lista;
    }
    
    public ArrayList todasFacturas(){
        if(listaFac.isEmpty()) return null;
        return listaFac;
    }
    
    public String pagarFactura(int cedula,int codCurso,float pago){
        if(listaFac.isEmpty()) return "No hay facturas";
        if(buscarFactura(cedula,codCurso).getEstadoPago()) return "Ya esta paga esta factura";
        Factura factura=buscarFactura(cedula,codCurso);
        if(factura!=null){
            if(factura.getCosto()<=pago){
                factura.setEstadoPago(true);
                factura.setCosto(0);
                for(int i=0;i<listaFac.size();i++){
                    if(listaFac.get(i).getCedula()==cedula && listaFac.get(i).getCodCurso()==codCurso){
                        listaFac.set(i, factura);
                        actualizarArchivo();
                        return "Pago realizado";
                    }
                }
            }            
        }
        return "No se pudo realizar el pago";
    }
}
