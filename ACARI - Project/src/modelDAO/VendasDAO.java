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
import model.Vendas;

/**
 *
 * @author Bento
 */
public class VendasDAO {

    Connection db;

    public VendasDAO() {
        this.db = new DatabaseConnection().dbConnection();
    }

    public long add(Vendas venda) {

        String sql
                = "INSERT INTO Vendas (id,id_empresa,data_vendas,nota_fiscal)"
                + "VALUES"
                + "(nextval('vendas_id_seq'),?,?,?)"
                + "RETURNING id;";

        try {
            Calendar calendar = Calendar.getInstance();

            java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());

            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, venda.getId_empresa());
            statement.setDate(2, data);
            statement.setBoolean(3, venda.getNota_fiscal());

            ResultSet rs = statement.executeQuery();
            rs.next();
            long id = rs.getLong("id");
            statement.close();

            return id;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return -1;
    }

    public void edit(long id, long id_empresa) {
        String sql
                = "UPDATE Compras set id_empresa = ? where id = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id_empresa);
            statement.setLong(2, id);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(long id) {
        String sql
                = "DELETE FROM Compras where id = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Vendas showID(long id) {
        String sql
                = "Select * FROM Vendas where id = ? ";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id);
            rs = statement.executeQuery();
            rs.next();

            String[] auxDate = rs.getDate("data_vendas").toString().split("-");
            String date = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];

            Vendas venda = new Vendas(rs.getLong("id"), rs.getLong("id_empresa"), date, rs.getBoolean("nota_fiscal"));

            statement.close();

            return venda;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ArrayList<Vendas> showAll() {
        String sql
                = "Select * FROM Vendas";
        ResultSet rs = null;
        ArrayList<Vendas> vendas = new ArrayList<Vendas>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {

                String[] auxDate = rs.getDate("data_vendas").toString().split("-");
                String date = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];

                Vendas venda = new Vendas(rs.getLong("id"), rs.getLong("id_empresa"), date, rs.getBoolean("nota_fiscal"));
                vendas.add(venda);
            }

            statement.close();

            return vendas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
