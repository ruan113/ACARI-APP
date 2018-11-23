/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Vendas;
import model.ItensVendidos;

/**
 *
 * @author Bento
 */
public class vendaController {

    principalController controlerPrincipal;

    ArrayList<Vendas> carrinho = new ArrayList<>();
    ArrayList<ItensVendidos> vendas = new ArrayList<>();

    public vendaController(principalController principal) {
        this.controlerPrincipal = principal;
    }

    public void addVendas() {
        vendas.add(new ItensVendidos(vendas.size(), carrinho));
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

        for (Vendas c : carrinho) {
            pt += c.getPrecoTotal();
        }

        return pt;
    }

    public long getMaiorId() {
        long id = 0;

        for (Vendas c : carrinho) {
            if (c.getIdVenda() > id) {
                id = c.getIdVenda();
            }
        }

        return id;
    }

    public Vendas getItem(long id) {

        for (Vendas c : carrinho) {
            if (c.getIdVenda() == id) {
                return c;
            }
        }

        return null;
    }

}
