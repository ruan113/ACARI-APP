/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author Bento
 */
public class associadoController {

    principalController controlerPrincipal;
    
    ArrayList listaAss = new ArrayList();
    
    public associadoController(principalController principal) {
        this.controlerPrincipal = principal;
        adicionarAssociado(0, "Nome1", "Cpf1", "Rg1", (short)1, "Rua1", "Bairro1", "MG");
        adicionarAssociado(1, "Nome2", "Cpf2", "Rg2", (short)2, "Rua2", "Bairro2", "MG");
        adicionarAssociado(2, "Nome3", "Cpf3", "Rg3", (short)3, "Rua2", "Bairro2", "MG");
        adicionarAssociado(3, "Nome4", "Cpf4", "Rg4", (short)4, "Rua3", "Bairro3", "MG");
        adicionarAssociado(4, "Nome5", "Cpf5", "Rg5", (short)5, "Rua1", "Bairro1", "MG");
    }

    public void adicionarAssociado(int idAssociado, String nomeAssociado, String cpfAssociado, String rgAssociado, Short endNum, String endRua, String endBairro, String uf) {
        listaAss.add(new Associados(idAssociado, nomeAssociado, cpfAssociado, rgAssociado, endNum, endRua, endBairro, uf));    
    }

    public void editarAssociado(int idAssociado, String cpfAssociado, String rgAssociado, Short endNum, String endRua, String endBairro, String uf) {

    }

    public ArrayList getListaAssociados() {
        return listaAss;
    }

    public void setListaAssociados(ArrayList listaAssociados) {
        this.listaAss = listaAssociados;
    }
    
}
