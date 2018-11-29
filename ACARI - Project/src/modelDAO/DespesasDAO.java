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
import model.Despesas;

/**
 *
 * @author Bento
 */
public class DespesasDAO {

    Connection db;

    public DespesasDAO() {
        this.db = new DatabaseConnection().dbConnection();

    }

    public void add(Despesas despesa) {

        String sql
                = "INSERT INTO Despesas (id,titulo,tipo,valor, data)"
                + "VALUES"
                + "(nextval('despesas_id_seq'),?,?,?,?);";

        try {
            String[] auxData = despesa.getData().split("/");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(auxData[2]), Integer.parseInt(auxData[1]), Integer.parseInt(auxData[0]));

            java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());

            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, despesa.getTitulo());
            statement.setString(2, despesa.getTipo());
            statement.setDouble(3, despesa.getValor());
            statement.setDate(4, data);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void edit(Despesas despesaVelha, Despesas despesaNova) {
        String sql
                = "UPDATE Despesas set titulo = ?, tipo = ?, valor = ?, data = ? where id = ?;";

        try {
            String[] auxData = despesaNova.getData().split("/");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(auxData[2]), Integer.parseInt(auxData[1]), Integer.parseInt(auxData[0]));

            java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());

            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, despesaNova.getTitulo());
            statement.setString(2, despesaNova.getTipo());
            statement.setDouble(3, despesaNova.getValor());
            statement.setDate(4, data);
            statement.setLong(5, despesaVelha.getId_despesa());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(long id) {
        String sql
                = "DELETE FROM Despesas where id = ?"
                + ";";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Despesas showID(long id) {
        String sql
                = "Select * FROM Despesas where id = ? ";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id);
            rs = statement.executeQuery();
            rs.next();

            String[] auxDate = rs.getDate("data").toString().split("-");
            String data = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];
            
            Despesas desp = new Despesas(rs.getLong("id"), rs.getString("titulo"), rs.getDouble("valor"),
                    rs.getString("tipo"), data);

            statement.close();

            return desp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ArrayList<Despesas> showAll() {
        String sql
                = "Select * FROM Despesas";
        ResultSet rs = null;
        ArrayList<Despesas> despesas = new ArrayList<Despesas>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                String[] auxDate = rs.getDate("data").toString().split("-");
                String data = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];

                Despesas desp = new Despesas(rs.getLong("id"), rs.getString("titulo"), rs.getDouble("valor"),
                        rs.getString("tipo"), data);
                despesas.add(desp);
            }

            statement.close();

            return despesas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
