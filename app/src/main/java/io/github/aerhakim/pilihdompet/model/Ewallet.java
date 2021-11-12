package io.github.aerhakim.pilihdompet.model;

public class Ewallet {

    int id;
    String nama,feetrx, size, gambar, rating, detail;

    public Ewallet(int id, String nama, String detail, String feetrx, String size, String gambar, String rating) {
        this.id = id;
        this.nama = nama;
        this.feetrx = feetrx;
        this.size = size;
        this.rating = rating;
        this.detail = detail;
        this.gambar = gambar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFeetrx() {
        return feetrx;
    }

    public void setFeetrx(String feetrx) {
        this.feetrx = feetrx;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
