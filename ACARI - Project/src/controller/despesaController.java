/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Despesas;
import modelDAO.DespesasDAO;

/**
 *
 * @author Bento
 */
public class despesaController {

    principalController controlerPrincipal;
    ArrayList<Despesas> listaDesp = new ArrayList();
    DespesasDAO despesasDAO = new DespesasDAO();
    
    public despesaController(principalController principal) {
        this.controlerPrincipal = principal;
    }

    public void adicionarDespesa(String titulo, String tipo, double valor, String data) {
        despesasDAO.add(new Despesas(titulo,valor,tipo,data));
    }

    //Busca uma Despesa pelo ID
    public Despesas buscaDespesaID(long id) {
        return despesasDAO.showID(id);
    }

    //Edita uma empresa 
    public void editarDespesa(Despesas antigo, Despesas novo) {
        despesasDAO.edit(antigo,novo);
    }

    public void removeDespesa(long id) {
        despesasDAO.delete(id);
    }

    public ArrayList<Despesas> getListaDespesas() {
        return despesasDAO.showAll();
    }    
    
}
