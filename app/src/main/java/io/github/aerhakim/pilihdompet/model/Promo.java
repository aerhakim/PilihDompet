package io.github.aerhakim.pilihdompet.model;

public class Promo {

    String judul,deskripsi, gambar, snk, ewallet, tglendpromo, user;
    int id;


    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getEwallet() {
        return ewallet;
    }

    public void setEwallet(String ewallet) {
        this.ewallet = ewallet;
    }

    public String getSnk() {
        return snk;
    }

    public void setSnk(String snk) {
        this.snk = snk;
    }

    public String getTglendpromo() {
        return tglendpromo;
    }

    public void setTglendpromo(String tglendpromo) {
        this.tglendpromo = tglendpromo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Promo(int id, String judul, String deskripsi, String gambar, String ewallet, String snk, String tglendpromo, String user) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.ewallet = ewallet;
        this.snk = snk;
        this.tglendpromo = tglendpromo;
        this.user = user;
        this.id = id;
    }
}
