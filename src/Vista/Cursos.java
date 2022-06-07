/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.CursoCtrl;
import Controlador.UsuarioCtrl;
import Modelo.Curso;
import Modelo.Usuario;
import Utilitarios.Imagenes;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jekse
 */
public class Cursos extends javax.swing.JPanel {
    private final Principal p;
    private final CursoCtrl curCt;
    private final UsuarioCtrl usuCt=new UsuarioCtrl();
    private GridBagConstraints gbc=new GridBagConstraints();
    private final Imagenes imgs=new Imagenes();
    private ArrayList<Curso> lista;
    public int cod;    
    public boolean inscripcion=false;
    public boolean atras=false;
    public boolean ventana=false;
    
    /**
     * Creates new form Cursos
     * @param p
     * @param curCt
     */
    public Cursos(Principal p,CursoCtrl curCt) {
        initComponents();
        this.p=p;
        this.curCt=curCt;
        jscPanel.setBorder(new LineBorder(Color.BLACK));
        jscPanel.getVerticalScrollBar().setUnitIncrement(15);
        jscPanel.getVerticalScrollBar().setValue(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jscPanel = new javax.swing.JScrollPane();
        jPanelCursos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanelCursos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCursos.setPreferredSize(null);
        jPanelCursos.setLayout(new java.awt.GridBagLayout());
        jscPanel.setViewportView(jPanelCursos);

        add(jscPanel);
        jscPanel.setBounds(0, 100, 1000, 550);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("LISTA DE CURSOS");
        add(jLabel2);
        jLabel2.setBounds(10, 11, 218, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("COSTO");
        add(jLabel3);
        jLabel3.setBounds(790, 70, 62, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("DESCRIPCION");
        add(jLabel4);
        jLabel4.setBounds(400, 70, 131, 22);

        btnAtras.setText("Atras");
        btnAtras.setEnabled(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        add(btnAtras);
        btnAtras.setBounds(910, 10, 73, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        atras();
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelCursos;
    private javax.swing.JScrollPane jscPanel;
    // End of variables declaration//GEN-END:variables
    
    private void atras(){
        if(ventana){
            p.visualizarVentanas(false,false,false,false,true,false,false,true,false,false);
            p.cambiarVentanas(4);
        }else{
            p.visualizarVentanas(false,false,false,false,false,true,false,false,false,false);
            p.cambiarVentanas(5);
        }
    }
       
    public void cargarCursos(){
        jscPanel.getVerticalScrollBar().setValue(0);
        btnAtras.setEnabled(atras);
        jPanelCursos.removeAll();       
        lista=curCt.cursos();
        ImageIcon img;
        gbc.weightx=0.25;        
        if(!lista.isEmpty()){
            for(int i=0;i<lista.size();i++){
                final int ind=i;
                img=new ImageIcon(imgs.buscarImg(lista.get(i).getFotoCurso()));
                JLabel lblimg=new JLabel();
                lblimg.setBorder(new LineBorder(Color.BLACK));
                lblimg.setHorizontalAlignment((int)CENTER_ALIGNMENT);                
                Icon icon=new ImageIcon(img.getImage().getScaledInstance(190,170,Image.SCALE_SMOOTH));
                lblimg.setIcon(icon);
                JTextArea desc=new JTextArea();
                desc.setBorder(new LineBorder(Color.BLACK));
                desc.setAlignmentX(TOP_ALIGNMENT);
                desc.setFont(new Font("Calibri", Font.PLAIN, 17));
                desc.setWrapStyleWord(true);
                desc.setLineWrap(true);
                desc.setEditable(false);               
                desc.setText("Nombre: "+lista.get(i).getNombreCurso()+"\n"+
                             "Descripcion: "+lista.get(i).getDescripcion());                
                JLabel valor=new JLabel();
                valor.setBorder(new LineBorder(Color.BLACK));
                valor.setHorizontalAlignment((int)CENTER_ALIGNMENT);
                valor.setFont(new Font("Calibri", Font.BOLD, 17));
                valor.setText(String.valueOf("$ "+lista.get(i).getValorCurso()));
                JButton boton=new JButton("Inscribirse");
                boton.setEnabled(inscripcion);
                boton.addActionListener((ActionEvent e) -> {
                    inscripcion(ind);
                });                
                gbc.fill=GridBagConstraints.BOTH;
                gbc.gridx=0;
                gbc.gridy=i;
                gbc.ipadx=0;
                gbc.ipady=0;                               
                jPanelCursos.add(lblimg,gbc);
                gbc.gridx=1;
                gbc.ipadx=0;
                gbc.ipady=0;                
                jPanelCursos.add(desc,gbc);
                gbc.gridx=2;                
                jPanelCursos.add(valor,gbc);
                gbc.fill=GridBagConstraints.BASELINE;
                gbc.gridx=3;
                gbc.ipadx=20;
                gbc.ipady=30;                
                jPanelCursos.add(boton,gbc);                           
                jPanelCursos.updateUI();                
            }         
        }
    }
    
    private void inscripcion(int indice){
        JFrame emergente = new JFrame();        
        emergente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        emergente.setResizable(false);
        JDialog jd = new JDialog(emergente);                        
        jd.setLayout(new GridLayout(6,1));
        jd.setBounds(500,200,350, 200);
        jd.setResizable(false);
        JLabel lblMetPago = new JLabel("Metodo de pago");                        
        JLabel lblAddress = new JLabel("Direccion"); 
        JComboBox<String> jcmMetPago=new JComboBox<>();
        jcmMetPago.addItem("...");
        jcmMetPago.addItem("Tarjeta Credito");
        jcmMetPago.addItem("Tarjeta Debito");
        jcmMetPago.addItem("Transferencia Bancaria");
        jcmMetPago.addItem("Nequi");
        jcmMetPago.addItem("Daviplata");
        jcmMetPago.addItem("Contado");
        JTextField txtAddress=new JTextField();                        
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");                        

        btnAceptar.addActionListener((ActionEvent e) -> {                        
            if(!(jcmMetPago.getSelectedIndex()==0 ||
                    txtAddress.getText().equals("") ||
                    cod==0))
            {
                Usuario user=usuCt.buscarUsuario(cod);
                boolean bandera=curCt.inscribirse(lista.get(indice).getCodigoCurso(),
                        cod,
                        user.getNombre(),
                        jcmMetPago.getSelectedItem().toString(),
                        txtAddress.getText());
                if(bandera){
                    emergente.dispose();
                    JOptionPane.showMessageDialog(null,"Inscrito","Felicidades",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Posiblemente ya se encuentre inscrito","Alerta",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Rellene los campos","Alerta",JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener((ActionEvent e) -> {
            emergente.dispose();
        });
        jd.add(lblMetPago);
        jd.add(jcmMetPago);
        jd.add(lblAddress);
        jd.add(txtAddress);
        jd.add(btnAceptar);
        jd.add(btnCancelar);
        jd.setVisible(true);        
    }
    

}