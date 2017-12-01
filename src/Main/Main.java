/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


/**
 *
 * @author fznrm
 */
public class Main {

    public static void main(String[] args) {
        ProcessKNN pro = new ProcessKNN();
        pro.ambilDataTrain();
        
        //jika ingin mengetahui seberapa bagus algoritma KNN-nya, gunakan data validasi
        //un-comment : 
//        pro.ambilDataValidasi();
//        pro.prediksiDataValidasi();
//        pro.tampilDataValid();
        
        //ketiga method dibawah ini digunakan untuk mencari kelas pada data testing
        pro.ambilDataTest();
        pro.prediksiDataTesting();
        pro.tampilDataTest();
    }
}
