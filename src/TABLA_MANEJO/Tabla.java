/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TABLA_MANEJO;


import com.sun.rowset.internal.Row;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Tabla{
     JButton btn1 = new JButton("+");
     JButton btn2 = new JButton("x");
   static  DefaultTableModel d;
   
   
    public static void ver_tabla(JTable Lista,String tabla1[]){
        
        Lista.setDefaultRenderer(Object.class, new Render());
        
        

        d = new DefaultTableModel(tabla1,0 )
        
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        Lista.setModel(d);
       Lista.setPreferredScrollableViewportSize(Lista.getPreferredSize());
    }
    
    
    
    
    public  void agregar(JTable Lista,String[] obj){
        
       btn1.setName("+");
       btn2.setName("x");
        Lista.setDefaultRenderer(Object.class, new Render());
         Object[] row = new Object[7];

            row[5]=btn2;
            row[4]=btn1;
            row[3] =obj[3];
            row[2] =obj[2];
            row[1] = obj[1];
            row[0] = obj[0];
   
         d.addRow(row);
         Lista.setModel(d);
         
          
       
         
    }
    
    public  void eliminar(JTable tabla){
       
         int fila = tabla.getSelectedRow();
         if (fila >= 0) {
            d.removeRow(fila);
        }
         }
        /**
         * 
         * @param tabla la tabla de la cual se va a tomar los valores a calcular
         * @param columna la columna a la cual se va hacer el calculo de 0-->n
         * @param columna2 la columna a la cual se va hacer el calculo de 0-->n
         * @return  retorna los valores totales de un detalle factura
         */
         public  double calculartotal(JTable tabla ,int columna,int columna2){
           double total=0;
           
           double valor;
           
           double totalt=0;
          for (int i = 0; i < tabla.getRowCount(); i++) {

               
               valor=(double) tabla.getValueAt(i, columna);
               total=Integer.parseInt(tabla.getValueAt(i, columna2).toString())*valor;
               totalt= total+totalt;
               System.out.println(""+totalt);
               
               
          }
          
          return totalt;
    }
         
    }
   
 

