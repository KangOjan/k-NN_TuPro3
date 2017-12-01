/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author fznrm
 */
public class DataTesting {

    private String id;
    private int like;
    private int provokasi;
    private int komentar;
    private int emosi;
    private int kelas;
    private double jarak;

    public DataTesting() {
    }

    public DataTesting(String id, int like, int provokasi, int komentar, int emosi, int kelas, double jarak) {
        this.id = id;
        this.like = like;
        this.provokasi = provokasi;
        this.komentar = komentar;
        this.emosi = emosi;
        this.kelas = kelas;
        this.jarak = jarak;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getProvokasi() {
        return provokasi;
    }

    public void setProvokasi(int provokasi) {
        this.provokasi = provokasi;
    }

    public int getKomentar() {
        return komentar;
    }

    public void setKomentar(int komentar) {
        this.komentar = komentar;
    }

    public int getEmosi() {
        return emosi;
    }

    public void setEmosi(int emosi) {
        this.emosi = emosi;
    }

    public int getKelas() {
        return kelas;
    }

    public void setKelas(int kelas) {
        this.kelas = kelas;
    }

    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }

   
}
