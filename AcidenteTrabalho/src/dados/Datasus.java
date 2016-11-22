
package dados;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahara Pacheco
 */
public class Datasus {
    private final SortedMap<Integer,Integer> dados;
    
    public Datasus(File source) throws FileNotFoundException, IOException {
        dados = new TreeMap<>();
        CSVReader r = new CSVReader(new FileReader(source), ';');
        String[] line;
        Integer ano;
        Integer valor;
        while ((line = r.readNext()) != null) {
            ano = new Integer(line[0]);
            valor = new Integer(line[1]);
            dados.put(ano, valor);
        }
    }
    
    public int size() {
        return dados.size();
    }
    
    public int valor(int ano) {
        return (dados.get(ano));
    }
    
    public List<Integer> anos() {
        return new ArrayList(dados.keySet());
    }
    
    public List<Integer> anos(int from, int to) {
        return new ArrayList(dados.subMap(from, to).keySet());
    }
    
    /**
     * Teste básico
     */
    public static void main(String[] args) {
        File f = new File("MorteAcidente.csv");
        try {
            if (f.exists()) {
            Datasus datas = new Datasus(f);
            System.out.println(datas.size());
            System.out.println("1980: " + datas.valor(1980));
            }
            else {
                System.err.println(f.getAbsoluteFile() + " not found.");
            }
        } catch (Exception ex) {
            Logger.getLogger(Datasus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
