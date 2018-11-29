/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Materiais;
import modelDAO.MateriaisDAO;

/**
 *
 * @author Bento
 */
public class materialController {

    principalController controlerPrincipal;
    MateriaisDAO matDAO = new MateriaisDAO();

    public materialController(principalController principal) {
        this.controlerPrincipal = principal;
    }
    
    public void adicionarMaterial(String nomeMaterial, String tipo) {
        matDAO.add(new Materiais(nomeMaterial, tipo));
    }

    //Busca uma Empresa pelo nome
    public Materiais buscarMaterial(String nomeMaterial) {
        return matDAO.showNome(nomeMaterial);
    }
    
    //Busca uma Empresa pelo ID
    public Materiais buscaMaterialID(long id) {
        return matDAO.showID(id);
    }

    //Edita uma empresa 
    public void editarMaterial(Materiais antigo, Materiais novo) {
        matDAO.edit(antigo,novo);
    }

    public void removeMaterial(String nomeMaterial) {
        matDAO.delete(buscarMaterial(nomeMaterial));
    }

    public ArrayList<Materiais> getListaMateriais() {
        return matDAO.showAll();
    }    
}
