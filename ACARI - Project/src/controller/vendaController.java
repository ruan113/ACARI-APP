/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Vendas;
import model.ItemVendido;
import modelDAO.ItemVendidoDAO;
import modelDAO.VendasDAO;

/**
 *
 * @author Bento
 */
public class vendaController {

    principalController controlerPrincipal;
    
    ArrayList<ItemVendido> carrinho = new ArrayList<ItemVendido>();
    VendasDAO vendasDAO = new VendasDAO();
    ItemVendidoDAO itensVendidosDAO = new ItemVendidoDAO();

    public vendaController(principalController principal) {
        this.controlerPrincipal = principal;
    }

    public ArrayList<Vendas> getVendas() {
        return vendasDAO.showAll();
    }

    public void finalizarVenda(long id_empresa, boolean nota_fiscal) {
        
        long id_venda = vendasDAO.add(new Vendas(id_empresa, nota_fiscal));

        //Relaciona cada item com o registro de venda criado
        for (ItemVendido c : carrinho) {
            c.setId_venda(id_venda);
            itensVendidosDAO.add(c);
        }

        limparCarrinho();//Reseta carrinho
    }

    public ArrayList<ItemVendido> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<ItemVendido> c) {
        this.carrinho = c;
    }

    public boolean addVendaCarrinho(ItemVendido item, int index) {
        //Valida que aquela item não esta sendo repetido no carrinho, se estiver, o programa ira juntar os itens em um só
        for (ItemVendido i : carrinho) {
            if (item.getId_material() == i.getId_material()) {
                item.setId_venda(-1);
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

        for (ItemVendido item : carrinho) {
            pt += item.getPreco_total();
        }

        return pt;
    }

    public long getMaiorId() {
        long id = 0;
        for (ItemVendido c : carrinho) {
            if (c.getId_venda() > id) {
                id = c.getId_venda();
            }
        }
        return id;
    }

    public ItemVendido getItem(long id) {
        for (ItemVendido c : carrinho) {
            if (c.getId_venda() == id) {
                return c;
            }
        }
        return null;
    }
}
