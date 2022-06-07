/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitarios;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 *
 * @author Jekse
 */
public class Imagenes {
    private BufferedImage image;

    public Imagenes() {
    }
    
    public BufferedImage buscarImg(String ruta){
        try {
            image = ImageIO.read(new File(ruta));
            return image;
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error al guardar imagen "+e.getMessage(),"Alerta",JOptionPane.ERROR_MESSAGE);
            return null;
        }  
    }
    
    public boolean subir(String ruta1,String ruta2){
        try {
        //leemos la imagen
        image = ImageIO.read(new File(ruta1));        
        
        //parametros: imagen,extension,direccion donde se guardara la imagen
        
        ImageIO.write(image, "jpg", new File(ruta2));
        return true;
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error al guardar imagen "+e.getMessage(),"Alerta",JOptionPane.ERROR_MESSAGE);
            return false;
        }            
    }
    
    public boolean borrar(String ruta){
        if(ruta.equals(""))return false;
        File archivo=new File(ruta);        
        if(archivo.delete()) return true;
        return false;        
    }
}
