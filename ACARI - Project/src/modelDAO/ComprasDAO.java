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

/**
 *
 * @author Bento
 */
public class ComprasDAO {

    Connection db;

    public ComprasDAO() {
        this.db = new DatabaseConnection().dbConnection();
    }

    public long add(long id_associado) {

        String sql
                = "INSERT INTO Compras (id,id_associado,data_compras)"
                + "VALUES"
                + "(nextval('compras_id_seq'),?,?)"
                + "RETURNING id;";

        try {
            Calendar calendar = Calendar.getInstance();

            java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());

            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id_associado);
            statement.setDate(2, data);

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

    public void edit(long id, long id_associado) {
        String sql
                = "UPDATE Compras set id_associado = ? where id = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id_associado);
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

    public Compras showID(long id) {
        String sql
                = "Select * FROM Compras where id = ? ";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id);
            rs = statement.executeQuery();
            rs.next();

            String[] auxDate = rs.getDate("data_compras").toString().split("-");
            String date = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];

            Compras comp = new Compras(rs.getLong("id"), rs.getLong("id_associado"), date);

            statement.close();

            return comp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ArrayList<Compras> showAll() {
        String sql
                = "Select * FROM Compras";
        ResultSet rs = null;
        ArrayList<Compras> compras = new ArrayList<Compras>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {

                String[] auxDate = rs.getDate("data_compras").toString().split("-");
                String date = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];

                Compras comp = new Compras(rs.getLong("id"), rs.getLong("id_associado"), date);
                compras.add(comp);
            }

            statement.close();

            return compras;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
