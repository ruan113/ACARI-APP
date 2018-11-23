/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import BD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Associados;

/**
 *
 * @author Bento
 */
public class AssociadosDAO {

    Connection db;

    public AssociadosDAO() {
        this.db = new DatabaseConnection().dbConnection();
    }

    public void add(Associados associado) {

        String sql
                = "INSERT INTO Associados (nome,cpf,rg,cidade,end_num,end_rua,end_bairro,uf,complemento)"
                + "VALUES"
                + "(?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, associado.getNomeAssociado());
            statement.setString(2, associado.getCpfAssociado());
            statement.setString(3, associado.getRgAssociado());
            statement.setString(4, associado.getCidadeAssociado());
            statement.setString(5, associado.getEndNum().toString());
            statement.setString(6, associado.getEndRua());
            statement.setString(7, associado.getEndBairro());
            statement.setString(8, associado.getUf());
            statement.setString(9, associado.getEndComplemento());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void edit(Associados associado) {
        String sql
                = "UPDATE Associados set nome = ?,cpf = ?,rg = ?,cidade = ?,end_num = ?,end_rua = ?,end_bairro = ?,uf = ?,complemento = ?)";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, associado.getNomeAssociado());
            statement.setString(2, associado.getCpfAssociado());
            statement.setString(3, associado.getRgAssociado());
            statement.setString(4, associado.getCidadeAssociado());
            statement.setString(5, associado.getEndNum().toString());
            statement.setString(6, associado.getEndRua());
            statement.setString(7, associado.getEndBairro());
            statement.setString(8, associado.getUf());
            statement.setString(9, associado.getEndComplemento());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(Associados associado) {
        String sql
                = "DELETE FROM Associados where nome = ? "
                + "AND cpf = ? "
                + "AND rg = ?"
                + "AND cidade = ?"
                + "AND end_num = ?"
                + "AND end_rua = ?"
                + "AND end_bairro = ?"
                + "AND uf = ?"
                + "AND complemento = ?)";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, associado.getNomeAssociado());
            statement.setString(2, associado.getCpfAssociado());
            statement.setString(3, associado.getRgAssociado());
            statement.setString(4, associado.getCidadeAssociado());
            statement.setString(5, associado.getEndNum().toString());
            statement.setString(6, associado.getEndRua());
            statement.setString(7, associado.getEndBairro());
            statement.setString(8, associado.getUf());
            statement.setString(9, associado.getEndComplemento());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void show(String nome) {
        String sql
                = "Select * FROM Associados where nome = ? ";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, nome);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void showAll() {
        String sql
                = "Select * FROM Associados";

        try {
            PreparedStatement statement = db.prepareStatement(sql);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
