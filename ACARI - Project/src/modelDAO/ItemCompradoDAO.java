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
import model.Compras;
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
    
    /*
    public void edit(Compras compraVelho, Compras compraNovo) {
        String sql
                = "UPDATE Compras set id_associado = ?,tipo = ? where nome = ? AND id = ?;";

        try {
            String[] auxData = compraNovo.getData().split("/");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(auxData[2]));
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(auxData[0]));
            calendar.set(Calendar.MONTH, Integer.parseInt(auxData[1])); // Assuming you wanted May 1st

            java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());
            
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, compraNovo.get());
            statement.setString(2, compraNovo.getTipoMaterial());
            statement.setString(3, compraVelho.getMaterialNome());
            statement.setLong(4, compraVelho.getIdMaterial());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }*/
 /*public void delete(Compras compra) {
        String sql
                = "DELETE FROM Compras where id = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, compra.getMaterialNome());
            statement.setString(2, compra.getTipoMaterial());
            statement.setLong(3, compra.getIdMaterial());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }*/
    public ItemComprado showID(long id_material, long id_compra) {
        String sql
                = "Select * FROM itens_comprados where id_material = ? AND id_compra = ?";
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
