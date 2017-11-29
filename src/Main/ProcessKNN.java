/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.DataTesting;
import Model.DataTraining;
import Model.DataValidating;
import java.util.ArrayList;

/**
 *
 * @author fznrm
 */
public class ProcessKNN {

    ArrayList<DataTraining> train = new ArrayList<DataTraining>();
    ArrayList<DataValidating> valid = new ArrayList<DataValidating>();
    ArrayList<DataTesting> test = new ArrayList<DataTesting>();
    private double hasil[];
    private double hasilValidasi;
    private double hasilTest;

    public double validasi() {
        for (int i = 1; i < valid.size(); i++) {
            for (int j = 1; j < train.size(); j++) {

            }
        }
        return hasilValidasi;
    }

    public double nilaiAkhir() {
        for (int i = 1; i < test.size(); i++) {
            for (int j = 1; j < train.size(); j++) {

            }
        }
        return hasilTest;
    }

//    public void jarakEuclidean() {
//        int like_temp;
//        for (int i = 1; i < test.size(); i++) { //untuk looping sebanyak data test
//            for (int j = 1; j < train.size(); j++) { //untuk looping sebanyak data train
//                //data tes ke 1 di cari nilai euclideannya dari semua data training
//                //hasilnya akan disimpan di array hasil untuk data tes ke 1, dst
//            }
//        }
//        tampil();
//    }
//
//    public void tampil() {
//        for (int i = 0; i < hasilnya.length; i++) {
//            System.out.println(hasilnya[i]);
//        }
//    }
//
//    public double jumlah(int like1, int like2, int provokasi1, int provokasi2) {
//        int jum1 = (like2 - like1) ^ 2;
//        int jum2 = (provokasi2 - provokasi1) ^ 2;
//        double hasil = Math.sqrt(jum1 + jum2);
//        return hasil;
//    }
}
