
package SAAT;
//import SAAT.Datasus; 
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
//testabdi


public class Tabnetdatasus {
    Collection <Datasus> cdatasus;

    public Tabnetdatasus(){
  cdatasus = new ArrayList<>();
 }
    public void load(String csvFilename) throws IOException{
        // Reader source = new InputStreamReader(csvFilename.openStream());
         CSVReader reader = new CSVReader(new FileReader(csvFilename),';');
        String[] line;
        
     while ((line = reader.readNext()) != null) {
         Datasus datasus = new Datasus();
         datasus.setMunicipio(line[0]);
         datasus.setNoveseis(line[1]);
         datasus.setNovesete(line[2]);
         datasus.setNoveoito(line[3]);
         datasus.setNovenove(line[4]);
         datasus.setDoiszero(line[5]);
         datasus.setDoisum(line[6]);
         datasus.setDoisdois(line[7]);
         datasus.setDoistres(line[8]);
         datasus.setDoisquatro(line[9]);
         datasus.setDoiscinco(line[10]);
         datasus.setDoisseis(line[11]);
         datasus.setDoissete(line[12]);
         datasus.setDoisoito(line[13]);
         datasus.setDoisnove(line[14]);
         datasus.setDoisdez(line[15]);
         datasus.setDoisonze(line[16]);
         datasus.setDoisdoze(line[17]);
         datasus.setDoistreze(line[18]);
         datasus.setDoiscatorze(line[19]);
         datasus.setTotal(line[20]);
         
         cdatasus.add(datasus);
     }
      reader.close();
      //source.close();
    }
    
    public void save(File persist) throws IOException{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(persist));
           if (cdatasus != null){
               output.writeObject(cdatasus);
           }
         }
    
    public void load(File persist) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(persist));
        cdatasus = (Collection) input.readObject();
    }

    @Override
    
    public String toString(){
        String resposta = "Null";
        
        if(cdatasus != null){
           resposta = "[ ";
           for (Datasus datasus : cdatasus) {
               resposta = resposta.concat(datasus.getMunicipio() + " ");
           }  
           resposta = resposta.concat("]");
        }
        return resposta;
      }
 }