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
import modelDAO.EmpresasDAO;

/**
 *
 * @author Bento
 */
public class empresaController {

    principalController controlerPrincipal;
    ArrayList<Empresas> listaEmp = new ArrayList();
    EmpresasDAO empDAO = new EmpresasDAO();
    
    public empresaController(principalController principal) {
        this.controlerPrincipal = principal;
    }

    public void adicionarEmpresa(String nomeEmpresa, String CNPJ) {
        empDAO.add(new Empresas(nomeEmpresa, CNPJ));
    }

    //Busca uma Empresa pelo nome
    public Empresas buscarEmpresa(String nomeEmpresa) {
        return empDAO.showNome(nomeEmpresa);
    }
    
    //Busca uma Empresa pelo ID
    public Empresas buscaEmpresaID(long id) {
        return empDAO.showID(id);
    }

    //Edita uma empresa 
    public void editarEmpresa(Empresas antigo, Empresas novo) {
        empDAO.edit(antigo,novo);
    }

    public void removeEmpresa(String nomeEmpresa) {
        empDAO.delete(buscarEmpresa(nomeEmpresa));
    }

    public ArrayList<Empresas> getListaEmpresas() {
        return empDAO.showAll();
    }    
}
