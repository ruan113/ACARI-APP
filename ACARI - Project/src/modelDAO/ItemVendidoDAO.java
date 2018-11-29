/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import BD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ItemVendido;

/**
 *
 * @author Bento
 */
public class ItemVendidoDAO {

    Connection db;

    public ItemVendidoDAO() {
        this.db = new DatabaseConnection().dbConnection();
    }

    public void add(ItemVendido itemVendido) {

        String sql
                = "INSERT INTO itens_vendidos (id_material, id_venda, quantidade, preco_kg, preco_total)"
                + "VALUES"
                + "(?,?,?,?,?);";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, itemVendido.getId_material());
            statement.setLong(2, itemVendido.getId_venda());
            statement.setDouble(3, itemVendido.getQuantidade());
            statement.setDouble(4, itemVendido.getPreco_kg());
            statement.setDouble(5, itemVendido.getPreco_total());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void edit(ItemVendido vendaVelha, ItemVendido vendaNova) {
        String sql
                = "UPDATE itens_vendidos set id_material = ?, quantidade = ?, preco_kg = ?, preco_total=? "
                + "where id_venda = ? AND id_material = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, vendaNova.getId_material());
            statement.setDouble(2, vendaNova.getQuantidade());
            statement.setDouble(3, vendaNova.getPreco_kg());
            statement.setDouble(4, vendaNova.getPreco_total());
            statement.setLong(5, vendaVelha.getId_venda());
            statement.setLong(6, vendaVelha.getId_material());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(ItemVendido venda) {
        String sql
                = "DELETE FROM itens_vendidos where id_material = ? AND id_venda = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, venda.getId_material());
            statement.setLong(2, venda.getId_venda());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<ItemVendido> showID(long id_venda) {
        String sql
                = "Select * FROM itens_vendidos where id_venda = ?";
        ResultSet rs = null;
        ArrayList<ItemVendido> itens = new ArrayList<ItemVendido>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id_venda);
            rs = statement.executeQuery();
            rs.next();

            while (rs.next()) {
                ItemVendido item = new ItemVendido(rs.getLong("id_material"), rs.getLong("id_venda"), rs.getDouble("quantidade"),
                        rs.getDouble("preco_kg"), rs.getDouble("preco_total"));
                itens.add(item);
            }

            statement.close();

            return itens;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ArrayList<ItemVendido> showAll() {
        String sql
                = "Select * FROM itens_vendidos";
        ResultSet rs = null;
        ArrayList<ItemVendido> itens = new ArrayList<ItemVendido>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                ItemVendido item = new ItemVendido(rs.getLong("id_material"), rs.getLong("id_venda"), rs.getDouble("quantidade"),
                        rs.getDouble("preco_kg"), rs.getDouble("preco_total"));
                itens.add(item);
            }

            statement.close();

            return itens;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
