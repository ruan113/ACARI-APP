/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BD.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Compras;
import model.ItemComprado;
import modelDAO.ComprasDAO;
import modelDAO.ItemCompradoDAO;

/**
 *
 * @author Bento
 */
public class compraController {

    principalController controlerPrincipal;

    ArrayList<ItemComprado> carrinho = new ArrayList<ItemComprado>();
    ComprasDAO comprasDAO = new ComprasDAO();
    ItemCompradoDAO itensCompradosDAO = new ItemCompradoDAO();

    public compraController(principalController principal) {
        this.controlerPrincipal = principal;
    }

    public ArrayList<Compras> getCompras() {
        return comprasDAO.showAll();
    }

    public void finalizarCompra(long id_associado) {
        

        long id_compra = comprasDAO.add(id_associado);

        //Relaciona cada item com o registro de compra criado
        for (ItemComprado c : carrinho) {
            c.setId_compra(id_compra);
            itensCompradosDAO.add(c);
        }

        limparCarrinho();//Reseta carrinho
    }

    public ArrayList<ItemComprado> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<ItemComprado> c) {
        this.carrinho = c;
    }

    public boolean addCompraCarrinho(ItemComprado item, int index) {
        //Valida que aquela item não esta sendo repetido no carrinho, se estiver, o programa ira juntar os itens em um só
        for (ItemComprado i : carrinho) {
            if (item.getId_material() == i.getId_material()) {
                item.setId_compra(-1);
                if (item.getPreco_kg() == i.getPreco_kg()) {
                    i.setPreco_total(i.getPreco_kg() * (i.getQuantidade() + item.getQuantidade()));
                } else {
                    int option = JOptionPane.showConfirmDialog(null, "Existe um item no carrinho com o mesmo material, porém com preço por kilo diferente.\n"
                            + "Yes = Usar o preço Atual (" + item.getPreco_kg() + ")\n"
                            + "No = Usar o preço Antigo (" + i.getPreco_kg() + ")\n"
                            + "Cancel = Cancelar Adição do Item ao carrinho");

                    switch (option) {
                        case 0:
                            i.setPreco_kg(item.getPreco_kg());
                            i.setPreco_total(i.getPreco_kg() * (i.getQuantidade() + item.getQuantidade()));
                            break;
                        case 1:
                            i.setPreco_total(i.getPreco_kg() * (i.getQuantidade() + item.getQuantidade()));
                            break;
                        case 2:
                            return false;
                    }
                }
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                return true;
            }
        }
        carrinho.add(index, item);
        return true;
    }

    public void limparCarrinho() {
        carrinho = new ArrayList<>();
    }

    public float getPrecoTotalCarrinho() {
        float pt = 0;

        for (ItemComprado item : carrinho) {
            pt += item.getPreco_total();
        }

        return pt;
    }

    public long getMaiorId() {
        long id = 0;
        for (ItemComprado c : carrinho) {
            if (c.getId_compra() > id) {
                id = c.getId_compra();
            }
        }
        return id;
    }

    public ItemComprado getItem(long id) {
        for (ItemComprado c : carrinho) {
            if (c.getId_compra() == id) {
                return c;
            }
        }
        return null;
    }
}
