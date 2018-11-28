/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BD.DatabaseConnection;
import java.sql.Connection;
import java.util.ArrayList;
import model.*;
import modelDAO.AssociadosDAO;

/**
 *
 * @author Bento
 */
public class associadoController {

    principalController controlerPrincipal;
    AssociadosDAO assDAO = new AssociadosDAO();

    public associadoController(principalController principal) {
        this.controlerPrincipal = principal;
    }

    //Adiciona associado
    public void adicionarAssociado(String nomeAssociado, String cpfAssociado, String rgAssociado, String dataNascimento,
            String cep, String uf, String endCidade, String endBairro, String endRua, short endNum, String telefone) {
        assDAO.add(new Associados(
                nomeAssociado, cpfAssociado, rgAssociado, dataNascimento, cep, uf, endCidade, endBairro, endRua, endNum, telefone)
        );
    }

    //Busca um associado pelo nome
    public Associados buscarAssociado(String nomeAssociado) {
        return assDAO.showNome(nomeAssociado);
    }

    //Busca um associado pelo ID
    public Associados buscaAssociadoID(long id) {
        return assDAO.showID(id);
    }

    public void editarAssociado(Associados antigo, Associados novo) {
        assDAO.edit(antigo, novo);
    }

    public void removeAssociado(String nomeAssociado) {
        assDAO.delete(buscarAssociado(nomeAssociado));
    }

    public ArrayList getListaAssociados() {
        return assDAO.showAll();
    }
}
