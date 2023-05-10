package aplicacion;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion extends javax.swing.JFrame {

    public static final String URL = "jdbc:mysql://localhost:3306/escuela";
    public static final String usuario = "root";
    public static final String contraseña = "1234";

    public Conexion() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(botonConectar)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(botonConectar)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        Connection conexion = getConnection();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexion.prepareStatement(URL,usuario,contraseña);
            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Nombre: " + rs.getString("nombre")
                        + "\nDomicilio: " + rs.getString("domicilio")
                        + "\nCelular: " + rs.getString("celular")
                        + "\nCorreo Electronico: " + rs.getString("correo_electronico")
                        + "\nFecha Nacimiento: " + String.valueOf(rs.getDate("fecha_nacimiento"))
                        + "\nGenero: " + rs.getString("genero"));
            } else {
                JOptionPane.showMessageDialog(null, "no existen registros");
            }
            conexion.close();

        } catch (Exception ex) {
            System.err.println("Error " + ex);
        }
    }//GEN-LAST:event_botonConectarActionPerformed

    public Connection getConnection() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conexión = java.sql.DriverManager.getConnection(URL, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");

        } catch (Exception ex) {
            System.err.println("Error " + ex);
        }
        return conexion;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConectar;
    // End of variables declaration//GEN-END:variables

    private PreparedStatement conexion(String selec__from_persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
