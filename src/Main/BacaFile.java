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
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("selesai");
        return daftarArray;
    }
}
