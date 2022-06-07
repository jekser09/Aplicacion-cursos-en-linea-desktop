/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.UsuarioCtrl;
import Modelo.Usuario;

/**
 *
 * @author Jekse
 */
public class Estudiante extends javax.swing.JPanel {
    private Principal p;
    private Cursos cursos;
    private final UsuarioCtrl usuCt;
    public int cod=0;
    /**
     * Creates new form Estudiante
     * @param p
     * @param cursos
     * @param usuCt
     */
    public Estudiante(Principal p,Cursos cursos,UsuarioCtrl usuCt) {
        initComponents();
        this.p=p;
        this.cursos=cursos;
        this.usuCt=usuCt;
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
        jLabel3 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        pasContraseña = new javax.swing.JPasswordField();
        lblNombre5 = new javax.swing.JLabel();
        lblFacturas = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre7 = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblInscritos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ablaze academy.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(780, 0, 215, 196);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ablaze academy.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 215, 196);

        lbl1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("Bienvenido");
        lbl1.setToolTipText("");
        add(lbl1);
        lbl1.setBounds(260, 80, 420, 40);

        lblNombre1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre1.setText("Nombre:");
        lblNombre1.setToolTipText("");
        add(lblNombre1);
        lblNombre1.setBounds(230, 180, 100, 40);

        lblNombre2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblNombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre2.setText("Contraseña:");
        lblNombre2.setToolTipText("");
        add(lblNombre2);
        lblNombre2.setBounds(200, 240, 126, 40);

        lblNombre3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblNombre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre3.setText("Cedula:");
        lblNombre3.setToolTipText("");
        add(lblNombre3);
        lblNombre3.setBounds(240, 310, 90, 40);

        btnCerrarSesion.setText("Cerrar sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        add(btnCerrarSesion);
        btnCerrarSesion.setBounds(420, 570, 120, 23);

        lblCedula.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula.setText("---------------------");
        lblCedula.setToolTipText("");
        add(lblCedula);
        lblCedula.setBounds(350, 310, 250, 40);

        pasContraseña.setEnabled(false);
        add(pasContraseña);
        pasContraseña.setBounds(340, 240, 250, 30);

        lblNombre5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblNombre5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre5.setText("Facturas pendientes:");
        lblNombre5.setToolTipText("");
        add(lblNombre5);
        lblNombre5.setBounds(120, 510, 230, 40);

        lblFacturas.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblFacturas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFacturas.setText("---------------------");
        lblFacturas.setToolTipText("");
        add(lblFacturas);
        lblFacturas.setBounds(350, 500, 250, 40);

        txtNombre.setEnabled(false);
        add(txtNombre);
        txtNombre.setBounds(340, 180, 250, 30);

        btnAceptar.setText("Aceptar");
        add(btnAceptar);
        btnAceptar.setBounds(730, 290, 73, 23);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        add(btnModificar);
        btnModificar.setBounds(720, 380, 90, 20);

        lblNombre6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblNombre6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre6.setText("Tipo de usuario:");
        lblNombre6.setToolTipText("");
        add(lblNombre6);
        lblNombre6.setBounds(150, 380, 180, 40);

        lblNombre7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblNombre7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre7.setText("Cursos Inscritos:");
        lblNombre7.setToolTipText("");
        add(lblNombre7);
        lblNombre7.setBounds(160, 450, 180, 40);

        lblTipoUsuario.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTipoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoUsuario.setText("---------------------");
        lblTipoUsuario.setToolTipText("");
        add(lblTipoUsuario);
        lblTipoUsuario.setBounds(350, 380, 250, 40);

        lblInscritos.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblInscritos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInscritos.setText("---------------------");
        lblInscritos.setToolTipText("");
        add(lblInscritos);
        lblInscritos.setBounds(350, 440, 250, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        habilitar(true, true, true,false);
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblFacturas;
    private javax.swing.JLabel lblInscritos;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPasswordField pasContraseña;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void cerrarSesion() {
       p.habilitar(true,true,true,false,false,false,false);
       habilitar(false,false,false,false);
       p.visualizarVentanas(false,true,false,false,false,false,false,false,false,false);
       limpiar();
       cursos.inscripcion=false;
       cursos.atras=false;
       p.cambiarVentanas(2);       
    }
    
    private void habilitar(boolean nombre,boolean pass,boolean acept,
                           boolean modi)
    {
        txtNombre.setEnabled(nombre);
        pasContraseña.setEnabled(pass);
        btnAceptar.setEnabled(acept);
        btnModificar.setEnabled(modi);
    }
    
    private void limpiar(){
       txtNombre.setText("");
       pasContraseña.setText("");
       lblCedula.setText("");
       lblTipoUsuario.setText("");
       lblInscritos.setText("");
       lblFacturas.setText("");
    }
    
    public void cargarDatos(){
        Usuario usu=usuCt.buscarUsuario(cod);
        txtNombre.setText(usu.getNombre());
        pasContraseña.setText(usu.getContraseña());
        lblCedula.setText(String.valueOf(usu.getCedula()));
        lblTipoUsuario.setText(String.valueOf(usu.getTipoUsuario()));
        lblInscritos.setText(String.valueOf(0));
        lblFacturas.setText(String.valueOf(0));
    }
}
