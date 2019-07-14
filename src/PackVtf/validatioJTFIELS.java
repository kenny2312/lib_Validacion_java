package PackVtf;


import java.awt.Color;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kenny
 */
public class validatioJTFIELS {
    
       /*
    /las que reciben un evento van en keytype con sus pararamentros respectivos
    
    */
    
     public void onlyNumber(java.awt.event.KeyEvent evt) {
        int key = (int) evt.getKeyChar();
        if (key < 48 || key > 57) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void onlyText(java.awt.event.KeyEvent evt) {
        int key = (int) evt.getKeyChar();
        if ((key < 65 || key > 90) && (key < 97 || key > 122) && key != 209 && key != 241) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

    }
    
    /**
     *
     * @param evt
     */
    public void onlyTextAndSpace(java.awt.event.KeyEvent evt) {
       int key = (int) evt.getKeyChar();
 
        if ( ( key < 32 || key >=33)&& ( key < 65 || key > 90 ) && (key < 97 || key > 122) && (key != 209 && key != 241)  ) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

    }
    

    public void lengthTextField(javax.swing.JTextField txt, int length) {
        if (txt.getText().length() >= length) {
            txt.setText(txt.getText().substring(0, length - 1));
            txt.requestFocus();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    
    public boolean validarDouble(javax.swing.JTextField txt){

        boolean esDouble = false;
        double num = -1;
       
            String cadena = txt.getText();
            try {
                num = Double.parseDouble(cadena);
                esDouble = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Escriba un valor valido");
                esDouble = false;
            }
       
        return esDouble;
    

    }
    public boolean isEmpty(javax.swing.JTextField[] txts) {
        boolean flag = true;
        for (JTextField txt : txts) {
            if (txt.getText().trim().length() < 2) {
                flag = false;
                txt.setBackground(Color.red);
                txt.requestFocus();
                //break;
            }
        }
        return flag;
    }

    public boolean isEmail(javax.swing.JTextField txt) {
        boolean flag = true;
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt.getText());
        if (!matcher.matches()) {
            flag = false;
            txt.setBackground(Color.red);
            txt.requestFocus();
            Toolkit.getDefaultToolkit().beep();
        }
        return flag;
    }
    
    
}
