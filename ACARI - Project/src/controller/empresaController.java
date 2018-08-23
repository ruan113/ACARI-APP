/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Empresas;

/**
 *
 * @author Bento
 */
public class empresaController {

    principalController controlerPrincipal;
    ArrayList<Empresas> listaEmp = new ArrayList();

    public empresaController(principalController principal) {
        this.controlerPrincipal = principal;
        adicionarEmpresa(1, "Nome1", "0000.000.0000");
        adicionarEmpresa(2, "Nome2", "0000.000.0000");
        adicionarEmpresa(3, "Nome3", "0000.000.0000");
        adicionarEmpresa(4, "Nome4", "0000.000.0000");
        adicionarEmpresa(5, "Nome5", "0000.000.0000");
    }
    
    public void adicionarEmpresa(int idEmpresa, String nomeEmpresa, String CNPJ) {
        listaEmp.add(new Empresas(idEmpresa, nomeEmpresa, CNPJ));    
    }
    
    public ArrayList<Empresas> getListaEmpresas() {
        return listaEmp;
    }

    public void setListaEmpresas(ArrayList<Empresas> listaEmp) {
        this.listaEmp = listaEmp;
    }
}
