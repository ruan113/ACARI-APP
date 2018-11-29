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
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.ItemComprado;
import model.ItemComprado;

/**
 *
 * @author Bento
 */
public class ItemCompradoDAO {

    Connection db;

    public ItemCompradoDAO() {
        this.db = new DatabaseConnection().dbConnection();
    }

    public void add(ItemComprado itemComprado) {

        String sql
                = "INSERT INTO itens_comprados (id_material, id_compra, quantidade, preco_kg, preco_total)"
                + "VALUES"
                + "(?,?,?,?,?);";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, itemComprado.getId_material());
            statement.setLong(2, itemComprado.getId_compra());
            statement.setDouble(3, itemComprado.getQuantidade());
            statement.setDouble(4, itemComprado.getPreco_kg());
            statement.setDouble(5, itemComprado.getPreco_total());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void edit(ItemComprado compraVelha, ItemComprado compraNova) {
        String sql
                = "UPDATE Itens_comprados set id_material = ?, quantidade = ?, preco_kg = ?, preco_total=? "
                + "where id_compra = ? AND id_material = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, compraNova.getId_material());
            statement.setDouble(2, compraNova.getQuantidade());
            statement.setDouble(3, compraNova.getPreco_kg());
            statement.setDouble(4, compraNova.getPreco_total());
            statement.setLong(5, compraVelha.getId_compra());
            statement.setLong(6, compraVelha.getId_material());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(long id_compra, long id_material) {
        String sql
                = "DELETE FROM itens_comprados where id_material = ? AND id_compra = ?;";
        System.out.println(id_material);
        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id_material);
            statement.setLong(2, id_compra);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<ItemComprado> showID(long id_compra) {
        String sql
                = "Select * FROM itens_comprados where id_compra = ?";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id_compra);
            rs = statement.executeQuery();
            
            ArrayList<ItemComprado> listaItens = new ArrayList();

            while (rs.next()) {
                ItemComprado item = new ItemComprado(rs.getLong("id_material"), rs.getLong("id_compra"), rs.getDouble("quantidade"),
                        rs.getDouble("preco_kg"), rs.getDouble("preco_total"));
                listaItens.add(item);
            }

            statement.close();

            return listaItens;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ItemComprado showEspecific(long id_compra, long id_material) {
        String sql
                = "Select * FROM Itens_comprados where id_material = ? AND id_compra = ?";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id_material);
            statement.setLong(2, id_compra);
            rs = statement.executeQuery();
            rs.next();

            ItemComprado item = new ItemComprado(rs.getLong("id_material"), rs.getLong("id_compra"), rs.getDouble("quantidade"),
                    rs.getDouble("preco_kg"), rs.getDouble("preco_total"));
            statement.close();

            return item;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ArrayList<ItemComprado> showAll() {
        String sql
                = "Select * FROM itens_comprados";
        ResultSet rs = null;
        ArrayList<ItemComprado> itens = new ArrayList<ItemComprado>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                ItemComprado item = new ItemComprado(rs.getLong("id_material"), rs.getLong("id_compra"), rs.getDouble("quantidade"),
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
