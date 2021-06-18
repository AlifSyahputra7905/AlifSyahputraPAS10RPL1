package com.example.alifsyahputrapas10rpl1;

public class Data {
               private String nama;
               private String pesan;
               private Integer gambar;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Integer getGambar() {
        return gambar;
    }

    public void setGambar(Integer gambar) {
        this.gambar = gambar;
    }

    public Data(String nama, String pesan, Integer gambar) {
        this.nama = nama;
        this.pesan = pesan;
        this.gambar = gambar;
    }
}
