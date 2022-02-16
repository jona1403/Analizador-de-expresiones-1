/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Tabla.Siguiente;
import Tabla.Table;
import Transiciones.TablaTrans;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author HUGO
 */
public class AppFrame extends javax.swing.JFrame {

    public static String path = "";
    public static int Contadorfiles = 0;
    public static int ContadorNodos = 0;
    public static int identificador;
    public static int contadoraux = 0;
    public static String aux = "";
    public static ArrayList<Integer> primeros;
    public static ArrayList<Integer> ultimos;
    public static Map<String, Arbol.Nodo> Arboles = new HashMap<String, Arbol.Nodo>();
    public static Map<String, ArrayList<Tabla.Siguiente>> TablasSigPos = new HashMap<String, ArrayList<Tabla.Siguiente>>();
    public static ArrayList<Tabla.Siguiente> siguientes;
    public static ArrayList<Integer> auxiliarSigpor;
    public static ArrayList<Transiciones.TablaTrans> transTable;
    public static ArrayList<Transiciones.Estado> estados;

    /**
     * Creates new form AppFrame
     */
    public AppFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArchivoMenu = new javax.swing.JPopupMenu();
        AbrirItem = new javax.swing.JMenuItem();
        GuardarItem = new javax.swing.JMenuItem();
        GuardarComoItem = new javax.swing.JMenuItem();
        XMLItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        OptionsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CodeArea = new javax.swing.JTextArea();
        AutomatasButton = new javax.swing.JButton();
        EntradaButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ExitArea = new javax.swing.JTextArea();
        AnteriorButton = new javax.swing.JButton();
        SiguienteButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jComboBox1 = new javax.swing.JComboBox<>();

        AbrirItem.setText("Abrir");
        AbrirItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbrirItemMouseClicked(evt);
            }
        });
        AbrirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirItemActionPerformed(evt);
            }
        });
        ArchivoMenu.add(AbrirItem);

        GuardarItem.setText("Guardar");
        GuardarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarItemActionPerformed(evt);
            }
        });
        ArchivoMenu.add(GuardarItem);

        GuardarComoItem.setText("Guardar como ...");
        GuardarComoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarComoItemActionPerformed(evt);
            }
        });
        ArchivoMenu.add(GuardarComoItem);

        XMLItem.setText("Generar XML de salida");
        ArchivoMenu.add(XMLItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OptionsButton.setText("Archivo");
        OptionsButton.setComponentPopupMenu(ArchivoMenu);
        OptionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Archivo de entrada");

        CodeArea.setColumns(20);
        CodeArea.setRows(5);
        jScrollPane1.setViewportView(CodeArea);

        AutomatasButton.setText("Generar Automatas");
        AutomatasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutomatasButtonActionPerformed(evt);
            }
        });

        EntradaButton.setText("Analizar Entrada");
        EntradaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Salida");

        ExitArea.setColumns(20);
        ExitArea.setRows(5);
        jScrollPane2.setViewportView(ExitArea);

        AnteriorButton.setText("Anterior");

        SiguienteButton.setText("Siguiente");

        jTree1.setModel(new FileSystemModel(new File("C:\\Users\\HUGO\\Desktop\\ExpAnalyzer")));
        jScrollPane3.setViewportView(jTree1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ver Imagenes", "Arboles", "Siguientes", "Transiciones", "Automatas" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SiguienteButton)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AutomatasButton)
                        .addGap(24, 24, 24)
                        .addComponent(EntradaButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(OptionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(AnteriorButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(158, 158, 158)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(267, 267, 267)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AnteriorButton)
                                    .addComponent(SiguienteButton))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(OptionsButton, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AutomatasButton)
                    .addComponent(EntradaButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OptionsButtonActionPerformed

    private void AbrirItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbrirItemMouseClicked

    }//GEN-LAST:event_AbrirItemMouseClicked

    private void AbrirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirItemActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        fc.setFileFilter(filtro);
        int seleccion = fc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            path = fichero.getAbsolutePath();
            try ( FileReader fr = new FileReader(fichero)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena = cadena + (char) valor;
                    valor = fr.read();
                }
                this.CodeArea.setText(cadena);
            } catch (IOException el) {
                el.printStackTrace();
            }
        }
    }//GEN-LAST:event_AbrirItemActionPerformed

    private void GuardarComoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarComoItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        fc.setFileFilter(filtro);
        int seleccion = fc.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            try ( FileWriter fw = new FileWriter(fichero)) {
                fw.write(this.CodeArea.getText());
            } catch (IOException el) {
                el.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Documento Guardado exitosamente!");
    }//GEN-LAST:event_GuardarComoItemActionPerformed

    private void GuardarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarItemActionPerformed
        // TODO add your handling code here:
        if (this.path != "") {
            File fichero = new File(this.path);
            try ( FileWriter fw = new FileWriter(fichero)) {
                fw.write(this.CodeArea.getText());
            } catch (IOException el) {
                el.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Documento Guardado exitosamente!");
        } else {
            JOptionPane.showMessageDialog(null, "Aun no existe una ruta predefinida");
        }
    }//GEN-LAST:event_GuardarItemActionPerformed

    private void EntradaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaButtonActionPerformed
        try {
            interpretar(CodeArea.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EntradaButtonActionPerformed

    private void AutomatasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutomatasButtonActionPerformed
        // TODO add your handling code here:
        Grafica.Arbol gr = new Grafica.Arbol();
        Grafica.TablaSig ts = new Grafica.TablaSig();
        Transiciones.TablaTrans tbl = new TablaTrans();
        for (Iterator<Map.Entry<String, Arbol.Nodo>> entries = Arboles.entrySet().iterator(); entries.hasNext();) {
            contadoraux = 0;
            Map.Entry<String, Arbol.Nodo> entry = entries.next();
            gr.dibujarArbol(entry.getValue(), entry.getKey());
            entry.getValue().GenerateSiguientes();
            TablasSigPos.put(entry.getKey(), siguientes);
            ts.dibujarTabla(entry.getKey(), siguientes);
            
            tbl.setNombre(entry.getKey());
            tbl.setTerms(entry.getValue().getTerms());
            tbl.calcTrans(entry.getValue().getPrimeros(), siguientes);
            System.out.println("");
            System.out.println(entry.getKey());
            for(int i = 0; i < tbl.getEstados().size(); i++){
                System.out.println(tbl.getEstados().get(i).getNombre()+"   "+tbl.getEstados().get(i).getLista()+"   "+tbl.getEstados().get(i).getTerminales());
            }
            tbl = new TablaTrans();
        }
    }//GEN-LAST:event_AutomatasButtonActionPerformed

    private void getEstados(){
        
    }
    
    public void interpretar(String Cadena) throws FileNotFoundException {
        Reader input = new StringReader(Cadena);
        BufferedReader reader = new BufferedReader(input);
        Parser.Sintactico pars;
        try {
            pars = new Parser.Sintactico(new Parser.Lexico(reader));
            pars.parse();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada OLC.");
            System.out.println("Causa: " + ex.getCause());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbrirItem;
    private javax.swing.JButton AnteriorButton;
    private javax.swing.JPopupMenu ArchivoMenu;
    private javax.swing.JButton AutomatasButton;
    private javax.swing.JTextArea CodeArea;
    private javax.swing.JButton EntradaButton;
    private javax.swing.JTextArea ExitArea;
    private javax.swing.JMenuItem GuardarComoItem;
    private javax.swing.JMenuItem GuardarItem;
    private javax.swing.JButton OptionsButton;
    private javax.swing.JButton SiguienteButton;
    private javax.swing.JMenuItem XMLItem;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
