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
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author fznrm
 */
public class ProcessKNN {

    ArrayList<DataTraining> train = new ArrayList<DataTraining>();
    ArrayList<DataValidating> valid = new ArrayList<DataValidating>();
    ArrayList<DataTesting> test = new ArrayList<DataTesting>();

    public double itungJarakTesting(DataTraining dtra, DataTesting dtes) {
        return Math.sqrt(
                Math.pow((dtra.getLike() - dtes.getLike()), 2)
                + Math.pow((dtra.getProvokasi() - dtes.getProvokasi()), 2)
                + Math.pow((dtra.getKomentar() - dtes.getKomentar()), 2)
                + Math.pow((dtra.getEmosi() - dtes.getEmosi()), 2)
        );
    }
    
    public double itungJarakValidasi(DataTraining dtra, DataValidating dval) {
        return Math.sqrt(
                Math.pow((dtra.getLike() - dval.getLike()), 2)
                + Math.pow((dtra.getProvokasi() - dval.getProvokasi()), 2)
                + Math.pow((dtra.getKomentar() - dval.getKomentar()), 2)
                + Math.pow((dtra.getEmosi() - dval.getEmosi()), 2)
        );
    }

    public void prediksiDataTesting() {
        //ini untuk menyimpan nilai jarak tiap satuan nilai data set
        ArrayList<DataTesting> jarakDataTest = new ArrayList<>();

        for (int i = 0; i < test.size(); i++) {
            //untuk memperbaharui nilai pada array jarak
            jarakDataTest = new ArrayList<>();
            for (int j = 0; j < train.size(); j++) {
                double jarak = itungJarakTesting(train.get(j), test.get(i));

                DataTesting datatest = new DataTesting();
                //menyimpan jarak pada satu nilai nilai testing terhadap semua nilai training
                datatest.setJarak(jarak);
                //menyimpan kelas berdasarkan jarak yang didapat dari euclidean 
                //gunanya untuk voting kelas nanti
                datatest.setKelas(train.get(j).getKelas());
                jarakDataTest.add(datatest);
            }
            //untuk sorting ascending
            Collections.sort(jarakDataTest, new Comparator<DataTesting>() {
                @Override
                public int compare(DataTesting o1, DataTesting o2) {
                    return Double.compare(o1.getJarak(), o2.getJarak());
                }
            });
            //nilai k bisa ditentukan sendiri
            int k = 5;
            int increment0 = 0;
            int increment1 = 0;
            //untuk memilih dan menghitung data sebanyak nilai k
            for (int l = 0; l < k; l++) {
                if (jarakDataTest.get(l).getKelas() == 0) {
                    increment0++;
                } else {
                    increment1++;
                }
            }
            //untuk menentukan kelas dari satu record data pada data testing
            DataTesting testing = test.get(i);
            if (increment0 > increment1) {
                testing.setKelas(0);
                test.set(i, testing);
            } else {
                testing.setKelas(1);
                test.set(i, testing);
            }
        }
    }

    public void prediksiDataValidasi() {
        //ini untuk menyimpan nilai jarak tiap satuan nilai data set
        ArrayList<DataValidating> jarakDataValidasi = new ArrayList<>();
        for (int i = 0; i < test.size(); i++) {
            //untuk memperbaharui nilai pada array jarak
            jarakDataValidasi = new ArrayList<>();
            for (int j = 0; j < train.size(); j++) {
                double jarak = itungJarakValidasi(train.get(j), valid.get(i));

                DataValidating datavalid = new DataValidating();
                //menyimpan jarak pada satu nilai nilai testing terhadap semua nilai validasi
                datavalid.setJarak(jarak);
                //menyimpan kelas berdasarkan jarak yang didapat dari euclidean 
                //gunanya untuk voting kelas nanti
                datavalid.setKelas(train.get(j).getKelas());
                jarakDataValidasi.add(datavalid);
            }
            //untuk sorting ascending
            Collections.sort(jarakDataValidasi, new Comparator<DataValidating>() {
                @Override
                public int compare(DataValidating o1, DataValidating o2) {
                    return Double.compare(o1.getJarak(), o2.getJarak());
                }
            });
            int k = 5;
            int increment0 = 0;
            int increment1 = 0;
            //untuk memilih dan menghitung data sebanyak nilai k
            for (int l = 0; l < k; l++) {
                if (jarakDataValidasi.get(l).getKelas() == 0) {
                    increment0++;
                } else {
                    increment1++;
                }
            }
            //untuk menentukan kelas dari satu record data pada data validasi
            DataValidating validating = valid.get(i);
            if (increment0 > increment1) {
                validating.setKelas(0);
                valid.set(i, validating);
            } else {
                validating.setKelas(1);
                valid.set(i, validating);
            }
        }
    }

    //untuk membaca file
    public ArrayList<String[]> ambilRecord(String path) {
        String[] arrayRecord = null;
        ArrayList<String[]> dataArray = new ArrayList<>();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(new File(path)));
            String kata;
            while ((kata = dis.readLine()) != null) {
                //untuk menghapus tab pada file txt
                arrayRecord = kata.split("\t");
                dataArray.add(arrayRecord);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dataArray;
    }

    public void ambilDataTrain() {
        ArrayList<String[]> txt = ambilRecord("./DataSet/DataTrain.txt");
        for (int i = 0; i < txt.size(); i++) {
            //untuk menyimpan nilai dari data set train
            int like_tr = Integer.valueOf(txt.get(i)[1]);
            int provokasi_tr = Integer.valueOf(txt.get(i)[2]);
            int komentar_tr = Integer.valueOf(txt.get(i)[3]);
            int emosi_tr = Integer.valueOf(txt.get(i)[4]);
            int kelas_tr = Integer.valueOf(txt.get(i)[5]);
            train.add(new DataTraining(like_tr, provokasi_tr, komentar_tr, emosi_tr, kelas_tr));
        }
    }

    public void ambilDataValidasi() {
        ArrayList<String[]> txt = ambilRecord("./DataSet/DataValidate.txt");
        for (int i = 0; i < txt.size(); i++) {
            //untuk menyimpan nilai dari data set valid
            String id_val = txt.get(i)[0];
            int like_val = Integer.valueOf(txt.get(i)[1]);
            int provokasi_val = Integer.valueOf(txt.get(i)[2]);
            int komentar_val = Integer.valueOf(txt.get(i)[3]);
            int emosi_val = Integer.valueOf(txt.get(i)[4]);
            int kelas_vl = Integer.valueOf(txt.get(i)[5]);
            valid.add(new DataValidating(id_val, like_val, provokasi_val, komentar_val, emosi_val, kelas_vl, 0));
        }
    }

    public void ambilDataTest() {
        ArrayList<String[]> txt = ambilRecord("./DataSet/DataTest.txt");
        for (int i = 0; i < txt.size(); i++) {
            //untuk menyimpan nilai dari data set test
            String id_ts = txt.get(i)[0];
            int like_ts = Integer.valueOf(txt.get(i)[1]);
            int provokasi_ts = Integer.valueOf(txt.get(i)[2]);
            int komentar_ts = Integer.valueOf(txt.get(i)[3]);
            int emosi_ts = Integer.valueOf(txt.get(i)[4]);
            test.add(new DataTesting(id_ts, like_ts, provokasi_ts, komentar_ts, emosi_ts, 0, 0));
        }
    }

    public void tampilDataTest() {
        for (DataTesting dataTesting : test) {
            System.out.println(dataTesting.getId() + "\t"
                    + dataTesting.getLike() + "\t"
                    + dataTesting.getProvokasi() + "\t"
                    + dataTesting.getKomentar() + "\t"
                    + dataTesting.getEmosi() + "\t"
                    + dataTesting.getKelas());
        }
    }

    public void tampilDataValid() {
        for (DataValidating dataValidating : valid) {
            System.out.println(dataValidating.getId() + "\t"
                    + dataValidating.getLike() + "\t"
                    + dataValidating.getProvokasi() + "\t"
                    + dataValidating.getKomentar() + "\t"
                    + dataValidating.getEmosi() + "\t"
                    + dataValidating.getKelas());
        }
    }
}
