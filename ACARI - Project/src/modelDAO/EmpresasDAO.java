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
import model.Empresas;

/**
 *
 * @author Bento
 */
public class EmpresasDAO {

    Connection db;

    public EmpresasDAO() {
        this.db = new DatabaseConnection().dbConnection();
    }

    public void add(Empresas empresa) {

        String sql
                = "INSERT INTO Empresas (id,nome,cnpj)"
                + "VALUES"
                + "(nextval('empresas_id_seq'),?,?);";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, empresa.getNomeEmpresa());
            statement.setString(2, empresa.getCnpj());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void edit(Empresas empresaAntiga, Empresas empresaNova) {
        String sql
                = "UPDATE Empresas set nome = ?,cnpj = ? where nome = ? AND id = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, empresaNova.getNomeEmpresa());
            statement.setString(2, empresaNova.getCnpj());
            statement.setString(3, empresaAntiga.getNomeEmpresa());
            statement.setLong(4, empresaAntiga.getIdEmpresa());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(Empresas empresa) {
        String sql
                = "DELETE FROM Empresas where nome = ? "
                + "AND cnpj = ? AND id = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, empresa.getNomeEmpresa());
            statement.setString(2, empresa.getCnpj());
            statement.setLong(3, empresa.getIdEmpresa());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Empresas showNome(String nome) {
        String sql
                = "Select * FROM Empresas where nome = ?;";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            rs.next();

            Empresas emp = new Empresas(rs.getLong("id"), rs.getString("nome"), rs.getString("cnpj"));

            statement.close();

            return emp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public Empresas showID(long id) {
        String sql
                = "Select * FROM Associados where id = ?;";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id);
            rs = statement.executeQuery();
            rs.next();

            Empresas emp = new Empresas(rs.getLong("id"), rs.getString("nome"), rs.getString("cnpj"));

            statement.close();

            return emp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ArrayList<Empresas> showAll() {
        String sql
                = "Select * FROM Empresas;";
        ResultSet rs = null;
        ArrayList<Empresas> empresas = new ArrayList<Empresas>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Empresas emp = new Empresas(rs.getLong("id"), rs.getString("nome"), rs.getString("cnpj"));
                empresas.add(emp);
            }

            statement.close();

            return empresas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
