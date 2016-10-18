/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAAT;

import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
        public static void main(String[]args){
        try {
           // file = new File("C:\Users\Nahara\Documents\UNICAMP\ORIENTADA II\AcidenteTrabalho\FonteAcidente.csv");
           String csvFilename = "C:/FonteAcidente.csv"; 
           Tabnetdatasus data = new Tabnetdatasus();
            data.load(csvFilename);
            System.out.println("Obtido do Arquivo: " + data.toString());
            
            File arq = new File("cdatasus.ser");
            data.save(arq);
            Tabnetdatasus redata = new Tabnetdatasus();
            redata.load(arq);
            System.out.println("Obtido localmente: " + redata.toString());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
}    
    
}
