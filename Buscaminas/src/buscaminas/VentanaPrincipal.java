/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 07-ene-2011, 7:04:03
 */
package buscaminas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import buscaminas.MatrizMinas;
import buscaminas.MatrizVisibles;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class VentanaPrincipal extends javax.swing.JFrame implements  ActionListener, Runnable{

    JButton Botones[][] = new JButton[5][5];
    MatrizMinas Minas = new MatrizMinas();
    MatrizVisibles Visibles = new MatrizVisibles();
    
    
    Thread timer; 
    float tiempo;

    /** Creates new form Principal */
    public VentanaPrincipal() {
        initComponents();
       
       
        
        tiempo=0;
        timer = new Thread(this);
        timer.start();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        txtTiempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_como_hacer_caras_smiley_en_facebook_o_messenger_312_orig.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        txtTiempo.setEditable(false);
        txtTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ponerBotones(); 
        nuevaPartida();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        nuevaPartida();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void nuevaPartida() {
        Minas.colocarMinas();
        Minas.calcularMinas();
        Visibles.visibilizar(false);
        Visualizar();
    }   
    
     
      
   public void pulsarBoton(Object obj) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (obj == Botones[y][x]) {
                    pulsarCasilla(y, x);
                }
            }
        }
    }
  
     public void ponerBotones() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                Botones[y][x] = new JButton();
                jPanel1.add(Botones[y][x]);
                Botones[y][x].setBounds(y * 50, x * 50, 50, 50);
     
                Botones[y][x].addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                pulsarBoton(e.getSource());
                            }
                        });
            }
        }
    }
     
   public void pulsarCasillaRec(int y, int x) {
        if (y>=0&&y<5&&x>=0&&x<5&&Visibles.isValor(y, x) == false) {
            Visibles.setVisible(y, x, true);
            if (Minas.getMina(y, x) == 4) {
                Visibles.visibilizar(true);
            }
            if(Minas.getMina(y, x)==0){
                pulsarCasillaRec(y, x-1);
                pulsarCasillaRec(y, x+1);
                pulsarCasillaRec(y-1, x);
                pulsarCasillaRec(y+1, x);
            }
        }        
    }

    public void pulsarCasilla(int y, int x) {
        pulsarCasillaRec(y, x);
        Visualizar();
    }  
     
     
      public void Visualizar() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (Visibles.isValor(y, x)) {
                    if (Minas.getMina(y, x) == 4) {
                        Botones[y][x].setLabel("");
                        Botones[y][x].setBackground(Color.BLACK);
                    } else if (Minas.getMina(y, x) == 0) {
                        Botones[y][x].setLabel("");
                        Botones[y][x].setBackground(Color.WHITE);
                    } else {
                        Botones[y][x].setLabel("" + Minas.getMina(y, x));
                        Botones[y][x].setBackground(Color.GRAY);
                    }
                } else {
                    Botones[y][x].setLabel("");
                    Botones[y][x].setBackground(Color.GRAY);
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
     while(true){
       tiempo++;
       
       int minutos = (int)(tiempo / 60f);
       int segundos = (int)(tiempo % 60f); 
       
       txtTiempo.setText(""+tiempo);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
       
        }
      }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    

   
