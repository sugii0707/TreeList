package com.example.treelist;

public class Product {
    private int id;
    private String shugam;
    private String tulguur;
    private String zurag;
    private String temdeglel;

    public Product(int id, String shugam, String tulguur, String zurag, String temdeglel) {
        this.id = id;
        this.shugam = shugam;
        this.tulguur = tulguur;
        this.zurag = zurag;
        this.temdeglel = temdeglel;
    }

    public int getId() {
        return id;
    }

    public String getShugam() {
        return shugam;
    }

    public String getTulguur() {
        return tulguur;
    }

    public String getZurag() {
        return zurag;
    }

    public String getTemdeglel(){
        return temdeglel;
    }

}
