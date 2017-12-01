/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.DataTesting;
import Model.DataTraining;
import Model.DataValidating;
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

    //untuk membaca file
    public ArrayList<String[]> ambilRecord(String path) {
        String[] arrayRecord = null;
        ArrayList<String[]> dataArray = new ArrayList<>();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(new File(path)));
            String kata;
            while ((kata = dis.readLine()) != null) {
                arrayRecord = kata.split("\t");
                dataArray.add(arrayRecord);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("selesai");
        return dataArray;
    }

    public void ambilDataTrain() {
        ArrayList<String[]> txt = ambilRecord("./DataSet/DataTrain.txt");
        for (int i = 0; i < txt.size(); i++) {
            int like_tr = Integer.valueOf(txt.get(i)[1]);
            int provokasi_tr = Integer.valueOf(txt.get(i)[2]);
            int komentar_tr = Integer.valueOf(txt.get(i)[3]);
            int emosi_tr = Integer.valueOf(txt.get(i)[4]);
            train.add(new DataTraining(like_tr, provokasi_tr, komentar_tr, emosi_tr));
        }
    }

    public void ambilDataValidasi() {
        ArrayList<String[]> txt = ambilRecord("./DataSet/DataValidate.txt");
        for (int i = 0; i < txt.size(); i++) {
            int like_val = Integer.valueOf(txt.get(i)[1]);
            int provokasi_val = Integer.valueOf(txt.get(i)[2]);
            int komentar_val = Integer.valueOf(txt.get(i)[3]);
            int emosi_val = Integer.valueOf(txt.get(i)[4]);
            valid.add(new DataValidating(like_val, provokasi_val, komentar_val, emosi_val));
        }
    }

    public void ambilDataTest() {
        ArrayList<String[]> txt = ambilRecord("./DataSet/DataTest.txt");
        for (int i = 0; i < txt.size(); i++) {
            int like_ts = Integer.valueOf(txt.get(i)[1]);
            int provokasi_ts = Integer.valueOf(txt.get(i)[2]);
            int komentar_ts = Integer.valueOf(txt.get(i)[3]);
            int emosi_ts = Integer.valueOf(txt.get(i)[4]);
            test.add(new DataTesting(like_ts, provokasi_ts, komentar_ts, emosi_ts));
        }
    }

    public void tampilDataTrain() {
        for (DataTraining dataTraining : train) {
            System.out.println("Like : " + dataTraining.getLike() + ", emosi : " + dataTraining.getEmosi() + ", provokasi : " + dataTraining.getProvokasi() + ", komentar : " + dataTraining.getKomentar());
        }
    }
}
