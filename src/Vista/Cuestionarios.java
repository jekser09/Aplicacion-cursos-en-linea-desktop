/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.CursoCtrl;
import Controlador.DiplomaCtrl;
import Controlador.UsuarioCtrl;
import Modelo.Pregunta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jekse
 */
public class Cuestionarios extends javax.swing.JPanel {
    private final DiplomaCtrl dipCt;
    private final Principal p;
    private final UsuarioCtrl usuCt=new UsuarioCtrl();
    private ArrayList<Pregunta> lista;
    /**
     * Creates new form Cuestionarios
     * @param p     
     * @param usuCt     
     * @param curCt     
     */
    public Cuestionarios(Principal p,UsuarioCtrl usuCt,CursoCtrl curCt){
        this.p=p;
        dipCt=new DiplomaCtrl(usuCt,curCt);
        initComponents();
        config();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblCodCurso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbUsuarios = new javax.swing.JTable();
        lblAdmin = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaPregunta3 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaPregunta5 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtaPregunta2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtaPregunta1 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtaPregunta4 = new javax.swing.JTextArea();
        jcCorrecto5 = new javax.swing.JCheckBox();
        jcCorrecto1 = new javax.swing.JCheckBox();
        jcCorrecto2 = new javax.swing.JCheckBox();
        jcCorrecto3 = new javax.swing.JCheckBox();
        jcCorrecto4 = new javax.swing.JCheckBox();
        btnCalificar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ablaze academy.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 215, 196);

        lblCodCurso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCodCurso.setText("---");
        add(lblCodCurso);
        lblCodCurso.setBounds(410, 340, 90, 22);

        jtbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbUsuarios);

        add(jScrollPane1);
        jScrollPane1.setBounds(300, 80, 590, 240);

        lblAdmin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmin.setText("CUESTIONARIOS");
        lblAdmin.setToolTipText("");
        add(lblAdmin);
        lblAdmin.setBounds(400, 0, 420, 80);

        lblCedula.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCedula.setText("---");
        add(lblCedula);
        lblCedula.setBounds(720, 340, 100, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Codigo Curso:");
        add(jLabel8);
        jLabel8.setBounds(220, 340, 125, 22);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Cedula:");
        add(jLabel10);
        jLabel10.setBounds(620, 340, 70, 22);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Pregunta 2:");
        add(jLabel13);
        jLabel13.setBounds(100, 490, 120, 22);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Pregunta 3:");
        add(jLabel15);
        jLabel15.setBounds(100, 560, 120, 22);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Pregunta 1:");
        add(jLabel14);
        jLabel14.setBounds(100, 400, 120, 22);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Pregunta 4:");
        add(jLabel16);
        jLabel16.setBounds(520, 400, 120, 22);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Pregunta 5:");
        add(jLabel17);
        jLabel17.setBounds(520, 480, 120, 22);

        jtaPregunta3.setColumns(20);
        jtaPregunta3.setRows(5);
        jScrollPane2.setViewportView(jtaPregunta3);

        add(jScrollPane2);
        jScrollPane2.setBounds(220, 550, 240, 50);

        jtaPregunta5.setColumns(20);
        jtaPregunta5.setRows(5);
        jScrollPane3.setViewportView(jtaPregunta5);

        add(jScrollPane3);
        jScrollPane3.setBounds(630, 470, 240, 50);

        jtaPregunta2.setColumns(20);
        jtaPregunta2.setRows(5);
        jScrollPane4.setViewportView(jtaPregunta2);

        add(jScrollPane4);
        jScrollPane4.setBounds(220, 470, 240, 50);

        jtaPregunta1.setColumns(20);
        jtaPregunta1.setRows(5);
        jScrollPane5.setViewportView(jtaPregunta1);

        add(jScrollPane5);
        jScrollPane5.setBounds(220, 390, 240, 50);

        jtaPregunta4.setColumns(20);
        jtaPregunta4.setRows(5);
        jScrollPane6.setViewportView(jtaPregunta4);

        add(jScrollPane6);
        jScrollPane6.setBounds(630, 390, 240, 50);

        jcCorrecto5.setText("Es correcto?");
        jcCorrecto5.setEnabled(false);
        add(jcCorrecto5);
        jcCorrecto5.setBounds(630, 520, 100, 20);

        jcCorrecto1.setText("Es correcto?");
        jcCorrecto1.setEnabled(false);
        add(jcCorrecto1);
        jcCorrecto1.setBounds(220, 440, 100, 20);

        jcCorrecto2.setText("Es correcto?");
        jcCorrecto2.setEnabled(false);
        add(jcCorrecto2);
        jcCorrecto2.setBounds(220, 520, 100, 20);

        jcCorrecto3.setText("Es correcto?");
        jcCorrecto3.setEnabled(false);
        add(jcCorrecto3);
        jcCorrecto3.setBounds(220, 600, 100, 20);

        jcCorrecto4.setText("Es correcto?");
        jcCorrecto4.setEnabled(false);
        add(jcCorrecto4);
        jcCorrecto4.setBounds(630, 440, 100, 20);

        btnCalificar.setText("Calificar");
        btnCalificar.setEnabled(false);
        btnCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificarActionPerformed(evt);
            }
        });
        add(btnCalificar);
        btnCalificar.setBounds(690, 560, 120, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbUsuariosMouseClicked
        if(!usuCt.usuarios().isEmpty()){
            traerPreguntas();
        }
    }//GEN-LAST:event_jtbUsuariosMouseClicked

    private void btnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificarActionPerformed
        calificar();
    }//GEN-LAST:event_btnCalificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JCheckBox jcCorrecto1;
    private javax.swing.JCheckBox jcCorrecto2;
    private javax.swing.JCheckBox jcCorrecto3;
    private javax.swing.JCheckBox jcCorrecto4;
    private javax.swing.JCheckBox jcCorrecto5;
    private javax.swing.JTextArea jtaPregunta1;
    private javax.swing.JTextArea jtaPregunta2;
    private javax.swing.JTextArea jtaPregunta3;
    private javax.swing.JTextArea jtaPregunta4;
    private javax.swing.JTextArea jtaPregunta5;
    private javax.swing.JTable jtbUsuarios;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCodCurso;
    // End of variables declaration//GEN-END:variables
    
    private void config(){
        jtaPregunta1.setEditable(false);
        jtaPregunta2.setEditable(false);
        jtaPregunta3.setEditable(false);
        jtaPregunta4.setEditable(false);
        jtaPregunta5.setEditable(false);
        jtaPregunta1.setLineWrap(true);
        jtaPregunta2.setLineWrap(true);
        jtaPregunta3.setLineWrap(true);
        jtaPregunta4.setLineWrap(true);
        jtaPregunta5.setLineWrap(true);
        jtaPregunta1.setWrapStyleWord(true);
        jtaPregunta2.setWrapStyleWord(true);
        jtaPregunta3.setWrapStyleWord(true);
        jtaPregunta4.setWrapStyleWord(true);
        jtaPregunta5.setWrapStyleWord(true);
    }
    
    public void cargarTabla(){
        jtbUsuarios.setModel(usuCt.tablaUsuarios());
        jtbUsuarios.updateUI();
    }
    
    private void traerPreguntas(){
        int cod=Integer.parseInt(jtbUsuarios.getModel().getValueAt(jtbUsuarios.getSelectedRow(),0).toString());
        lista=dipCt.respuestasPersona(cod);
        if(jtbUsuarios.getSelectedRow()>=0 && lista!=null && !lista.isEmpty()){           
            
            lblCodCurso.setText(String.valueOf(lista.get(0).getCodCurso()));
            lblCedula.setText(String.valueOf(cod));
            jtaPregunta1.setText(lista.get(0).getPregunta()+"\n"+
                                lista.get(0).getRespuesta());
            jtaPregunta2.setText(lista.get(1).getPregunta()+"\n"+
                                lista.get(1).getRespuesta());
            jtaPregunta3.setText(lista.get(2).getPregunta()+"\n"+
                                lista.get(2).getRespuesta());
            jtaPregunta4.setText(lista.get(3).getPregunta()+"\n"+
                                lista.get(3).getRespuesta());
            jtaPregunta5.setText(lista.get(4).getPregunta()+"\n"+
                                lista.get(4).getRespuesta());
            btnCalificar.setEnabled(true);
            jcCorrecto1.setEnabled(true);
            jcCorrecto2.setEnabled(true);
            jcCorrecto3.setEnabled(true);
            jcCorrecto4.setEnabled(true);
            jcCorrecto5.setEnabled(true);
        }else{
            lblCodCurso.setText("---");
            lblCedula.setText("---");
            jtaPregunta1.setText("No hay");
            jtaPregunta2.setText("No hay");
            jtaPregunta3.setText("No hay");
            jtaPregunta4.setText("No hay");
            jtaPregunta5.setText("No hay");
            btnCalificar.setEnabled(false);
            jcCorrecto1.setEnabled(false);
            jcCorrecto2.setEnabled(false);
            jcCorrecto3.setEnabled(false);
            jcCorrecto4.setEnabled(false);
            jcCorrecto5.setEnabled(false);
        }
    }

    private void calificar() {
        ArrayList<Pregunta> lista2=new ArrayList<>();
        Pregunta preg;
        preg=lista.get(0);        
        preg.setCorrecto(jcCorrecto1.isSelected());
        lista2.add(preg);
        preg=lista.get(1);
        preg.setCorrecto(jcCorrecto2.isSelected());
        lista2.add(preg);
        preg=lista.get(2);
        preg.setCorrecto(jcCorrecto3.isSelected());
        lista2.add(preg);
        preg=lista.get(3);
        preg.setCorrecto(jcCorrecto4.isSelected());
        lista2.add(preg);
        preg=lista.get(4);
        preg.setCorrecto(jcCorrecto5.isSelected());
        lista2.add(preg);
        if(dipCt.certificar(lista2, preg.getCedula(),preg.getCodCurso())){
            JOptionPane.showMessageDialog(null,"Calificado","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"No se califico","Alerta",JOptionPane.ERROR_MESSAGE);
        }
        
    }
        
   }
    

