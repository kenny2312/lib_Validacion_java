/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TABLA_MANEJO;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author kenny
 */
public class TABLA_MSelectRow {
     /**
    * ESte metodo permite el elemento de la fila de una tabla  
    * donde se encuentran botones
    * para usarlo ecribir de la siguiete manera
    * new TABLA_MSelectRow().SelectedThisTabla(evt,tabla,message,mesagge2,objt1).
    @param evt Recibe el evento MouseEvent de MouseClicked.
    @param tabla Recibe  la tabla que se encuebtra en el frame.
    @param message Muestra el mensanje de modificacion o joption futuro.
    @param mesagge2 Muestra el mensanje de eliminacion del Joption.pane.
    @param objt1 Objeto de la clase tabla que llamara 
    * (metodos descrito en esa clase) en este caso eliminar.
    */

     public void SelectedThisTabla(java.awt.event.MouseEvent evt,JTable tabla,String message ,String mesagge2 ,Tabla objt1){
        
         int column = tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tabla.getRowHeight();
        
        if(row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0){
            Object value = tabla.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("+")){
                    System.out.println(message);
                    
                }
              int delete=0;
                if(boton.getName().equals("x")){
                  delete=  JOptionPane.showConfirmDialog(null, mesagge2, "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println(""+delete);
                    if(delete==0){
                         objt1. eliminar(tabla);
                    }

                }
            }
            if(value instanceof JCheckBox){
                //((JCheckBox)value).doClick();
                JCheckBox ch = (JCheckBox)value;
                if(ch.isSelected()==true){
                    ch.setSelected(false);
                }
                if(ch.isSelected()==false){
                    ch.setSelected(true);
                }
                
            }
        }
    }
}
