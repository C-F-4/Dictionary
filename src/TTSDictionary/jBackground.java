/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTSDictionary;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author XXL
 */
public class jBackground extends JDesktopPane {
    
    jBackground(){
        //this.paintComponent();
    }
    
    protected void paintComponent(Graphics g){
        Image img = new ImageIcon(this.getClass().getResource("bg.gif")).getImage();
        
        try{
            Graphics2D g2d = (Graphics2D) g;
            double dh = img.getHeight(null);
            double dw = img.getWidth(null);
            g2d.scale(getWidth()/dh, getHeight()/dw);
            g2d.drawImage(img, 0, 0, this);
        }
        catch(Exception e) {
            System.out.println("Error occured while creating the background");
        }
    }
    
}
