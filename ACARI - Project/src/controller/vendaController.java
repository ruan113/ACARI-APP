/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Vendas;
import model.ItemVendido;

/**
 *
 * @author Bento
 */
public class vendaController {

    principalController controlerPrincipal;
    
    
    ArrayList<Vendas> carrinho = new ArrayList<>();
    
    public vendaController(principalController principal) {
        this.controlerPrincipal = principal;
    }

    public void addVendas() {
        //vendas.add(new ItemVendido(vendas.size(), carrinho));
    }

    public ArrayList<Vendas> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Vendas> c) {
        this.carrinho = c;
    }

    public void addVendaCarrinho(Vendas venda, int index) {

        carrinho.add(index, venda);

        /*try {
            Statement st = db.createStatement();
            String query = "";
            for (Vendas venda : vendas) {
                
            }
        } catch (Exception e) {
            System.out.println("Error on Add Vendas: " + e);
        }*/
    }

    public void limparCarrinho() {
        carrinho = new ArrayList<>();
    }

    public float getPrecoTotalCarrinho() {
        float pt = 0;


        return pt;
    }

    public long getMaiorId() {
        long id = 0;


        return id;
    }

    public Vendas getItem(long id) {

        

        return null;
    }

}
