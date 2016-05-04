/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TTSDictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
/*
import java.awt.event.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
*/


/**
 *
 * @author XXL
 * date 02-05-2016
 */
public class mainFrame extends javax.swing.JFrame{
    
    //private volatile boolean running = false;
    private BufferedImage img;
    private static DefaultListModel  listdata;
    private static ArrayList<Word> lw;
    SpeechSynthesizer speech;
    Word w;
    
    public void change_status(String s){
        jLabelStatus.setText("<html><head></head><body style='font-color: red;'>" + s + "</body></html>");
        System.out.println(s);
    }
    public void clean_status(){
        jLabelStatus.setText("");
    }
    /*
    public void run() {
        change_text();
        while (speech.isAlive()) { 
            // do nothing;
        }
        stop();
    }
    public void stop() {
        running = true;
    } */
    // private Set<Integer> keysDown = Collections.synchronizedSet(new HashSet<Integer>());
    /**
     * Creates new form mainFramemicrophone
     */
    public mainFrame() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("icon.jpg")).getImage());
        clean_status();
        File f = new File("azdictor.txt");
        ParseData pd = new ParseData(f);
        pd.start();
        try {
            pd.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TTSDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }

        lw = pd.getWordList();
        listdata = new DefaultListModel();
        for(Word w : lw){
            listdata.addElement(w.getWord());
        }
        lstWord.setModel(listdata);
        
//        txtWord.getDocument().addDocumentListener(new DocumentListener(){
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                System.out.println(txtWord.getText());
//            }
//            
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        try {
            img = ImageIO.read(new URL("https://4.bp.blogspot.com/-MwHljnJCvLo/VyXmlk_bNLI/AAAAAAAALuM/Y7jdeOi5cAkWkPYVRbxwoAXmPJpHmiWzACLcB/s1600/EjnYYz2.gif"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(img.getWidth(), img.getHeight());
            }};
            txtWord = new javax.swing.JTextField();
            jScrollPane1 = new javax.swing.JScrollPane();
            lstWord = new javax.swing.JList();
            jScrollPane2 = new javax.swing.JScrollPane();
            txtMeaning = new javax.swing.JEditorPane();
            ImageIcon II = new ImageIcon("microphone.jpg");
            jButton1 = new javax.swing.JButton(II);
            jLabelStatus = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("BiDictionary");
            setBackground(new java.awt.Color(243, 198, 0));
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            setForeground(new java.awt.Color(0, 255, 255));
            setMinimumSize(new java.awt.Dimension(800, 500));
            addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    formKeyPressed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            jDesktopPane1.setBackground(new java.awt.Color(74, 72, 74));
            jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

            txtWord.setBackground(new java.awt.Color(197, 194, 189));
            txtWord.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
            txtWord.setToolTipText("Enter key here");
            txtWord.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            txtWord.setPreferredSize(new java.awt.Dimension(100, 6));
            txtWord.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtWordActionPerformed(evt);
                }
            });
            txtWord.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtWordKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtWordKeyReleased(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtWordKeyTyped(evt);
                }
            });

            lstWord.setBackground(new java.awt.Color(204, 204, 204));
            lstWord.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
            lstWord.setForeground(new java.awt.Color(0, 0, 0));
            lstWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lstWord.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    lstWordValueChanged(evt);
                }
            });
            jScrollPane1.setViewportView(lstWord);

            jScrollPane2.setBackground(new java.awt.Color(197, 194, 189));

            txtMeaning.setEditable(false);
            txtMeaning.setBackground(new java.awt.Color(197, 194, 189));
            txtMeaning.setContentType("text/html"); // NOI18N
            txtMeaning.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
            txtMeaning.setForeground(new java.awt.Color(0, 0, 0));
            txtMeaning.setText("<html>\r   <head>\r \r   </head>\r   <body>\r     <p style=\"margin-top: 0\">\r       \r     </p>\r   </body>\r </html>\r ");
            txtMeaning.setAlignmentX(0.0F);
            txtMeaning.setAutoscrolls(false);
            txtMeaning.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            jScrollPane2.setViewportView(txtMeaning);
            txtMeaning.getAccessibleContext().setAccessibleName("");

            jButton1.setBackground(new java.awt.Color(0, 0, 0));
            jButton1.setForeground(new java.awt.Color(255, 255, 255));
            jButton1.setText("Speak");
            jButton1.createImage(24, 24);
            jButton1.setToolTipText("Speak");
            jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jButton1MouseEntered(evt);
                }
            });
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jButton1KeyPressed(evt);
                }
            });

            jDesktopPane1.setLayer(txtWord, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
            jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

            javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
            jDesktopPane1.setLayout(jDesktopPane1Layout);
            jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(txtWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2)))
                    .addContainerGap())
            );
            jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtWord, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(10, 10, 10)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addContainerGap())
            );

            jLabelStatus.setForeground(new java.awt.Color(250, 0, 0));
            jLabelStatus.setToolTipText("Status");
            jLabelStatus.setMaximumSize(new java.awt.Dimension(700, 25));
            jLabelStatus.setMinimumSize(new java.awt.Dimension(6, 6));
            jLabelStatus.setPreferredSize(new java.awt.Dimension(24, 24));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jDesktopPane1)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDesktopPane1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void lstWordValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstWordValueChanged
        int pos = this.lstWord.getSelectedIndex();
        w = lw.get(pos);
        //System.out.println();
        
        //this.txtMeaning.setText(w.getMind());
        this.txtMeaning.setContentType("text/html");
        this.txtMeaning.setText("<html><head></head><body style=';'>"+ w.getMind() +"</body></html>");
        this.txtMeaning.setCaretPosition(0);
    }//GEN-LAST:event_lstWordValueChanged

    private void txtWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWordKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtWordKeyTyped

    private void txtWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWordKeyReleased
        // TODO add your handling code here:
        //System.out.println();
        Search se = new Search(txtWord.getText(), lw);
        System.out.println(se.getIndex());
        int i = se.getIndex();
        lstWord.setSelectedIndex(i);
        lstWord.ensureIndexIsVisible(i);
    }//GEN-LAST:event_txtWordKeyReleased

    private void txtWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWordKeyPressed
        // TODO add your handling code here:
        //keysDown.add(evt.getKeyCode());
    }//GEN-LAST:event_txtWordKeyPressed

    private void txtWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWordActionPerformed
        // TODO add your handling code here:
        //keysDown.remove(evt.getKeyCode());
    }//GEN-LAST:event_txtWordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*
        if(!speech.isAlive()){
            try {
                speech.join();                            //current thread main() waits til pd finishes it's execution. Once done, main() resumes
            } catch (InterruptedException ex) {
                Logger.getLogger(TTSDictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        change_status("reading the word");
        speech = new SpeechSynthesizer(w);
        speech.start();
    //    /*if(speech.isAlive())*/{ speech.interrupt(); }
        try{
            change_status("Voice Synthesizer running");
            speech.join();
        }
        catch(InterruptedException ex) {
            change_status("Voice Synthesizer Stopped forcefully");
            Logger.getLogger(TTSDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
        clean_status();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            change_status("reading the word(TTS)");
            speech = new SpeechSynthesizer(w);
            speech.start();
    //        /*if(speech.isAlive())*/{ speech.interrupt(); }
            try{
                change_status("Voice Synthesizer running");
                speech.join();
            }
            catch(InterruptedException ex) {
                change_status("Voice Synthesizer Stopped forcefully");
                Logger.getLogger(TTSDictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
            clean_status();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    /*    if(KeyEvent.VK_ALT == evt.getKeyCode()){
            change_status("reading the word");
            speech = new SpeechSynthesizer(w);
            speech.start();
            
            try{
                change_status("Voice Synthesizer running");
                speech.join();
            }
            catch(InterruptedException ex) {
                change_status("Voice Synthesizer Stopped forcefully");
                Logger.getLogger(TTSDictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
            clean_status();
        }
    */
    }//GEN-LAST:event_formKeyPressed
    
    
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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
                            // create word list
                            
                        }
                    });
        */
        java.awt.EventQueue.invokeLater(() -> {
            new mainFrame().setVisible(true);
            // create word list
        });
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstWord;
    private javax.swing.JEditorPane txtMeaning;
    private javax.swing.JTextField txtWord;
    // End of variables declaration//GEN-END:variables
}