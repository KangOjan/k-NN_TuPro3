/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fznrm
 */
public class BacaFile {

    public ArrayList<String[]> getString(String path) {
        String[] array = null;
        ArrayList<String[]> daftarArray = new ArrayList<>();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(new File(path)));
            String kata;
            while ((kata = dis.readLine()) != null) {
                array = kata.split("\t");
                daftarArray.add(array);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BacaFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BacaFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("selesai");
        return daftarArray;
    }
}
