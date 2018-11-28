package model;
// Generated 08/08/2018 15:24:22 by Hibernate Tools 4.3.1

import java.util.ArrayList;

/**
 * ItensComprados generated by hbm2java
 */
public class ItemComprado implements java.io.Serializable {

    private long id_material;
    private long id_compra;
    private double quantidade;
    private double preco_kg;
    private double preco_total;

    public ItemComprado() {
    }
    
    public ItemComprado(long id_material, long id_compra, double quantidade, double preco_kg, double preco_total) {
        this.id_material = id_material;
        this.id_compra = id_compra;
        this.quantidade = quantidade;
        this.preco_kg = preco_kg;
        this.preco_total = preco_total;
    }

    public ItemComprado(double quantidade, double preco_kg, double preco_total) {
        this.quantidade = quantidade;
        this.preco_kg = preco_kg;
        this.preco_total = preco_total;
    }

    public long getId_material() {
        return id_material;
    }

    public void setId_material(long id_material) {
        this.id_material = id_material;
    }

    public long getId_compra() {
        return id_compra;
    }

    public void setId_compra(long id_compra) {
        this.id_compra = id_compra;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco_kg() {
        return preco_kg;
    }

    public void setPreco_kg(double preco_kg) {
        this.preco_kg = preco_kg;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }

    
    
}