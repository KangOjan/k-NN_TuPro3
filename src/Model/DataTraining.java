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
public class DataTraining {

    private int like;
    private int provokasi;
    private int komentar;
    private int emosi;
    private int kelas;

    public DataTraining() {
    }

    public DataTraining(int like, int provokasi, int komentar, int emosi, int kelas) {
        this.like = like;
        this.provokasi = provokasi;
        this.komentar = komentar;
        this.emosi = emosi;
        this.kelas = kelas;
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
    
    
}
