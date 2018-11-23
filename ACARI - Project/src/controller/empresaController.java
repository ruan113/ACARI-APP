/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BD.DatabaseConnection;
import java.sql.Connection;
import java.util.ArrayList;
import model.Vendas;
import model.Empresas;

/**
 *
 * @author Bento
 */
public class empresaController {

    principalController controlerPrincipal;
    ArrayList<Empresas> listaEmp = new ArrayList();
    
    Connection db = null;

    public empresaController(principalController principal) {
        this.controlerPrincipal = principal;

        DatabaseConnection dbConnection = new DatabaseConnection();
        this.db = dbConnection.dbConnection();

        adicionarEmpresa("Nome1", "0000.000.0000");
        adicionarEmpresa("Nome2", "0000.000.0000");
        adicionarEmpresa("Nome3", "0000.000.0000");
        adicionarEmpresa("Nome4", "0000.000.0000");
        adicionarEmpresa("Nome5", "0000.000.0000");
    }

    public void adicionarEmpresa(String nomeEmpresa, String CNPJ) {
        listaEmp.add(new Empresas(nomeEmpresa, CNPJ));
    }

    //Busca uma empresa pelo nome
    public Empresas buscarEmpresa(String nomeEmpresa) {
        for (int i = 0; i < listaEmp.size(); i++) {
            if (nomeEmpresa.equals(listaEmp.get(i).getNomeEmpresa())) {
                return listaEmp.get(i);
            }
        }
        return null;
    }
    
    //Busca um associado pelo ID
    public Empresas buscaEmpresaID(int id) {
        return listaEmp.get(id);
    }

    //Edita uma empresa 
    public void editarEmpresa(Empresas antigo, Empresas novo) {
        //Remove o antigo registro
        listaEmp.remove(antigo);
        //Adiciona o novo
        listaEmp.add(novo);
    }

    public void removeEmpresa(String nomeEmpresa) {
        listaEmp.remove(buscarEmpresa(nomeEmpresa));
    }

    public ArrayList<Empresas> getListaEmpresas() {
        return listaEmp;
    }

    public void setListaEmpresas(ArrayList<Empresas> listaEmp) {
        this.listaEmp = listaEmp;
    }
    
}
