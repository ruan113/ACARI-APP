/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Materiais;

/**
 *
 * @author Bento
 */
public class materialController {

    principalController controlerPrincipal;
    ArrayList<Materiais> listaMat = new ArrayList();

    public materialController(principalController principal) {
        this.controlerPrincipal = principal;
    }
    
    public void adicionarMaterial(String nomeMaterial, String tipo) {
        listaMat.add(new Materiais(nomeMaterial, tipo));
    }

    //Busca uma empresa pelo nome
    public Materiais buscarMaterial(String nomeMaterial) {
        for (int i = 0; i < listaMat.size(); i++) {
            if (nomeMaterial.equals(listaMat.get(i).getMaterialNome())) {
                return listaMat.get(i);
            }
        }
        return null;
    }
    
    //Busca um associado pelo ID
    public Materiais buscaMaterialID(int id) {
        return listaMat.get(id);
    }

    //Edita uma empresa 
    public void editarMaterial(Materiais antigo, Materiais novo) {
        //Remove o antigo registro
        listaMat.remove(antigo);
        //Adiciona o novo
        listaMat.add(novo);
    }

    public void removeMaterial(String nomeMaterial) {
        listaMat.remove(buscarMaterial(nomeMaterial));
    }

    public ArrayList<Materiais> getListaMateriais() {
        return listaMat;
    }

    public void setListaMateriais(ArrayList<Materiais> listaMat) {
        this.listaMat = listaMat;
    }
    
}
