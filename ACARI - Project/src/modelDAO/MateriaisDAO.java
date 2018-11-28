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
import model.Materiais;

/**
 *
 * @author Bento
 */
public class MateriaisDAO {

    Connection db;

    public MateriaisDAO() {
        this.db = new DatabaseConnection().dbConnection();
    }

    public void add(Materiais material) {

        String sql
                = "INSERT INTO Materiais (id,nome,tipo)"
                + "VALUES"
                + "(nextval('materiais_id_seq'),?,?);";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, material.getMaterialNome());
            statement.setString(2, material.getTipoMaterial());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void edit(Materiais materialVelho, Materiais materialNovo) {
        String sql
                = "UPDATE Materiais set nome = ?,tipo = ? where nome = ? AND id = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, materialNovo.getMaterialNome());
            statement.setString(2, materialNovo.getTipoMaterial());
            statement.setString(3, materialVelho.getMaterialNome());
            statement.setLong(4, materialVelho.getIdMaterial());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(Materiais material) {
        String sql
                = "DELETE FROM Materiais where nome = ? "
                + "AND tipo = ? AND id = ?"
                + ";";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, material.getMaterialNome());
            statement.setString(2, material.getTipoMaterial());
            statement.setLong(3, material.getIdMaterial());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Materiais showNome(String nome) {
        String sql
                = "Select * FROM Materiais where nome = ? ";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            rs.next();

            Materiais mat = new Materiais(rs.getLong("id"), rs.getString("nome"), rs.getString("tipo"));

            statement.close();

            return mat;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
    public Materiais showID(long id) {
        String sql
                = "Select * FROM Associados where id = ? ";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id);
            rs = statement.executeQuery();
            rs.next();

            Materiais mat = new Materiais(rs.getLong("id"), rs.getString("nome"), rs.getString("cnpj"));

            statement.close();

            return mat;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ArrayList<Materiais> showAll() {
        String sql
                = "Select * FROM Materiais";
        ResultSet rs = null;
        ArrayList<Materiais> materiais = new ArrayList<Materiais>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Materiais mat = new Materiais(rs.getLong("id"), rs.getString("nome"), rs.getString("tipo"));
                materiais.add(mat);
            }

            statement.close();

            return materiais;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
