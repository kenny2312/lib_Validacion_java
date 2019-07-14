/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility_Jpanel;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kenny
 */
public class SliderPanel {
    
    /**
     *
     * @author kenny2312
     * @param ta velocidad con la que se desliza el panel de 25 a 50 recomendada
     * @param Panel el panel a mover
     * @param BTN el boton que movera el panel
     * @param Estado estado que define a que direccion se movera 
     *   el panel 1 a la izquierda o a la derecha. 
     */
     public void moverPanel(int ta, JPanel Panel ,JButton  BTN, int Estado){
             Thread t = new Thread(){
            
            public void run() {
                int valor=Estado;
        if(valor==1){
           
         BTN.setEnabled(false);
            for (int i = 0; i < 20; i++) {
               
                Panel.setLocation(Panel.getLocation().x-i, Panel.getLocation().y);
            
                try {
                    sleep(ta);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(SliderPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BTN.setEnabled(true);
                
        
         
          valor =0;
       }else{
             BTN.setEnabled(false);
            for (int i = 0; i < 20; i++) {
                  Panel.setLocation(Panel.getLocation().x+i, Panel.getLocation().y);
                try {
                    sleep(ta);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SliderPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           BTN.setEnabled(true);
             valor =1;
       }
        
    }
        
        
    };
      t.start();
       
       
    }
}
