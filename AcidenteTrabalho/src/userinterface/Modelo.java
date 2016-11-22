
package userinterface;

import dados.Datasus;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nahara Pacheco
 */
public class Modelo extends javax.swing.JPanel {   
    /**
     * Creates new form Tabela
     */
    public Modelo(Datasus datas, int anoInicial, int anoFinal) {       
        initComponents();  
        jTable1.setModel(new AnoMorteModel(datas, anoInicial, anoFinal));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}

class AnoMorteModel extends AbstractTableModel {
   List anos;
   Datasus datas;
    
    public AnoMorteModel(Datasus datas, int from, int to) {
        this.datas = datas;
        anos = datas.anos(from, to);
    }

    @Override
    public int getRowCount() {
        return anos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) 
            return anos.get(rowIndex);
        else {
            return datas.valor((int) anos.get(rowIndex));
        }
    }

    @Override
    public String getColumnName(int colIndex) {
        return colIndex == 0 ? "Ano" : "Mortes" ;
    }
    
    @Override
    public Class getColumnClass(int colIndex) {
        return Integer.class;
    }
}