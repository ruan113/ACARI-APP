/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BD.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import model.Compras;
import model.ItensComprados;

/**
 *
 * @author Bento
 */
public class compraController {

    principalController controlerPrincipal;
    Connection db = null;

    ArrayList<Compras> carrinho = new ArrayList<>();
    ArrayList<ItensComprados> compras = new ArrayList<>();
    
    public compraController(principalController principal) {
        this.controlerPrincipal = principal;
        DatabaseConnection dbConnection = new DatabaseConnection();
        this.db = dbConnection.dbConnection();
    }

    public ArrayList<ItensComprados> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<ItensComprados> compras) {
        this.compras = compras;
    }
    
    public void addCompras(){
        compras.add(new ItensComprados(compras.size(), carrinho));
    }

    public ArrayList<Compras> getCarrinho(){
        return carrinho;
    }
    
    public void setCarrinho(ArrayList<Compras> c){
        this.carrinho = c;
    }
    
    public void addCompraCarrinho(Compras compra, int index) {
        
        carrinho.add(index,compra);
        
        /*try {
            Statement st = db.createStatement();
            String query = "";
            for (Compras compra : compras) {
                
            }
        } catch (Exception e) {
            System.out.println("Error on Add Compras: " + e);
        }*/
    }
    
    public void limparCarrinho(){
        carrinho = new ArrayList<>();
    }

    public float getPrecoTotalCarrinho(){
        float pt = 0;
        
        for(Compras c : carrinho){
            pt += c.getPrecoTotal();
        }
        
        return pt;
    }
    
    public long getMaiorId(){
        long id = 0;
        
        for(Compras c : carrinho){
            if(c.getIdCompra() > id){
                id = c.getIdCompra();
            }
        }
        
        return id;
    }
    
    public Compras getItem(long id){
        
        for(Compras c : carrinho){
            if(c.getIdCompra() == id){
                return c;
            }
        }
        
        return null;
    }
}
