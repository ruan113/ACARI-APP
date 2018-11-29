/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import BD.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
                = "INSERT INTO Associados (id,nome,cpf,rg,data_nasc,cep, uf,end_cidade,end_bairro,end_rua,end_num,telefone)"
                + "VALUES"
                + "(nextval('associados_id_seq'),?,?,?,?,?,?,?,?,?,?,?);";

        try {
            String[] auxData = associado.getDataNascimento().split("/");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(auxData[2]));
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(auxData[0]));
            calendar.set(Calendar.MONTH, Integer.parseInt(auxData[1])); // Assuming you wanted May 1st

            java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());

            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, associado.getNomeAssociado());
            statement.setString(2, associado.getCpfAssociado());
            statement.setString(3, associado.getRgAssociado());
            statement.setDate(4, data);
            statement.setString(5, associado.getCep());
            statement.setString(6, associado.getUf());
            statement.setString(7, associado.getCidadeAssociado());
            statement.setString(8, associado.getEndBairro());
            statement.setString(9, associado.getEndRua());
            statement.setShort(10, associado.getEndNum());
            statement.setString(11, associado.getTelefone());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void edit(Associados associadoVelho, Associados associadoNovo) {
        String sql
                = "UPDATE Associados set "
                + "nome = ?, "
                + "cpf = ?, "
                + "rg = ?, "
                + "data_nasc = ?,"
                + "cep = ?, "
                + "uf = ?, "
                + "end_cidade = ?, "
                + "end_bairro = ?, "
                + "end_rua = ?, "
                + "end_num = ?, "
                + "telefone = ? "
                + "where nome = ? AND id = ?;";

        try {

            String[] auxData = associadoNovo.getDataNascimento().split("/");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(auxData[2]));
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(auxData[0]));
            calendar.set(Calendar.MONTH, Integer.parseInt(auxData[1])); // Assuming you wanted May 1st

            java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());

            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, associadoNovo.getNomeAssociado());
            statement.setString(2, associadoNovo.getCpfAssociado());
            statement.setString(3, associadoNovo.getRgAssociado());
            statement.setDate(4, data);
            statement.setString(5, associadoNovo.getCep());
            statement.setString(6, associadoNovo.getUf());
            statement.setString(7, associadoNovo.getCidadeAssociado());
            statement.setString(8, associadoNovo.getEndBairro());
            statement.setString(9, associadoNovo.getEndRua());
            statement.setShort(10, associadoNovo.getEndNum());
            statement.setString(11, associadoNovo.getTelefone());
            statement.setString(12, associadoVelho.getNomeAssociado());
            statement.setLong(13, associadoVelho.getIdAssociado());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(Associados associado) {
        String sql
                = "DELETE FROM Associados where id = ? AND nome = ?;";

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, associado.getIdAssociado());
            statement.setString(2, associado.getNomeAssociado());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Associados showNome(String nome) {
        String sql
                = "Select * FROM Associados where nome = ? ";
        ResultSet rs = null;
        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            rs.next();

            String[] auxDate = rs.getDate("data_nasc").toString().split("-");
            String data = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];

            Associados ass = new Associados(
                    rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), data,
                    rs.getString("cep"), rs.getString("uf"), rs.getString("end_cidade"), rs.getString("end_bairro"),
                    rs.getString("end_rua"), rs.getShort("end_num"), rs.getString("telefone")
            );

            statement.close();

            return ass;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public Associados showID(long id) {
        String sql
                = "Select * FROM Associados where id = ? ";
        ResultSet rs = null;

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setLong(1, id);
            rs = statement.executeQuery();
            rs.next();

            String[] auxDate = rs.getDate("data_nasc").toString().split("-");
            String date = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];

            Associados ass = new Associados(
                    rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), date,
                    rs.getString("cep"), rs.getString("uf"), rs.getString("end_cidade"), rs.getString("end_bairro"),
                    rs.getString("end_rua"), rs.getShort("end_num"), rs.getString("telefone")
            );

            statement.close();

            return ass;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ArrayList<Associados> showAll() {
        String sql
                = "Select * FROM Associados";
        ResultSet rs = null;
        ArrayList<Associados> associados = new ArrayList<Associados>();

        try {
            PreparedStatement statement = db.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                String[] auxDate = rs.getDate("data_nasc").toString().split("-");
                String date = auxDate[2] + "/" + auxDate[1] + "/" + auxDate[0];
                
                Associados ass = new Associados(
                        rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), date,
                        rs.getString("cep"), rs.getString("uf"), rs.getString("end_cidade"), rs.getString("end_bairro"),
                        rs.getString("end_rua"), rs.getShort("end_num"), rs.getString("telefone")
                );
                associados.add(ass);
            }

            statement.close();

            return associados;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
