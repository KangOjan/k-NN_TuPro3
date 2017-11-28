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
public class ProcessKNN {

    private final int[] like_train = {29, 27, 19, 21, 27, 13, 40, 22, 30, 27, 12, 12, 10, 20, 14, 23, 39, 18, 13, 21};
    private final int[] provokasi_train = {66, 23, 43, 90, 56, 34, 69, 21, 97, 66, 34, 28, 22, 38, 50, 48, 67, 50, 45, 51};
    private final int[] komentar_train = {52, 74, 54, 90, 49, 80, 47, 79, 45, 43, 56, 82, 70, 82, 75, 57, 48, 66, 54, 87};
    private final int[] emosi_train = {70, 52, 33, 85, 53, 30, 70, 64, 82, 45, 49, 44, 54, 47, 63, 48, 70, 67, 47, 69};

    private final int[] like_test = {14, 18, 36, 18, 18, 36, 10, 13, 35, 10, 34, 11, 18, 17, 12, 36, 31, 11, 18, 12};
    private final int[] provokasi_test = {55, 76, 68, 43, 62, 67, 55, 40, 36, 62, 85, 76, 31, 53, 55, 85, 81, 40, 57, 22};
    private final int[] komentar_test = {68, 72, 68, 45, 71, 56, 71, 51, 73, 64, 54, 74, 53, 62, 54, 74, 44, 75, 58, 70};
    private final int[] emosi_test = {45, 74, 69, 56, 45, 61, 61, 72, 61, 71, 72, 70, 77, 64, 62, 73, 62, 70, 64, 79};

    private double[] hasilnya;

    public void jumlahan() {
        for (int i = 0; i <= like_test.length; i++) {
            int like_temp = ((like_test[i] - like_train[i]) ^ 2);
            int provokasi_temp = ((provokasi_test[i] - provokasi_train[i]) ^ 2);
            int komentar_temp = ((komentar_test[i] - komentar_train[i]) ^ 2);
            int emosi_temp = ((emosi_test[i] - emosi_train[i]) ^ 2);
            hasilnya[i] = Math.sqrt(like_temp + provokasi_temp + komentar_temp + emosi_temp);
        }
        tampil();
    }

    public void tampil() {
        for (int i = 0; i < hasilnya.length; i++) {
            System.out.println(hasilnya[i]);
        }
    }

    public double jumlah(int like1, int like2, int provokasi1, int provokasi2) {
        int jum1 = (like2 - like1) ^ 2;
        int jum2 = (provokasi2 - provokasi1) ^ 2;
        double hasil = Math.sqrt(jum1 + jum2);
        return hasil;
    }
}
