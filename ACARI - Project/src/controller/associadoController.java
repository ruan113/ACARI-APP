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
    
    ArrayList<Associados> listaAss = new ArrayList();
    
    public associadoController(principalController principal) {
        this.controlerPrincipal = principal;
        adicionarAssociado("Nome1", "Cpf1", "Rg1", "Cidade1", (short)1, "Rua1", "Bairro1", "MG", "complemento1");
        adicionarAssociado("Nome2", "Cpf2", "Rg2", "Cidade2",(short)2, "Rua2", "Bairro2", "MG", "complemento2");
        adicionarAssociado("Nome3", "Cpf3", "Rg3", "Cidade3",(short)3, "Rua2", "Bairro2", "MG", "complemento3");
        adicionarAssociado("Nome4", "Cpf4", "Rg4", "Cidade4",(short)4, "Rua3", "Bairro3", "MG", "complemento4");
        adicionarAssociado("Nome5", "Cpf5", "Rg5", "Cidade5",(short)5, "Rua1", "Bairro1", "MG", "complemento5");
    }

    //Adiciona associado
    public void adicionarAssociado(String nomeAssociado, String cpfAssociado, String rgAssociado, String cidadeAssociado, Short endNum, String endRua, String endBairro, String uf, String endComplemento) {
        listaAss.add(new Associados(nomeAssociado, cpfAssociado, rgAssociado, cidadeAssociado, endNum, endRua, endBairro, uf, endComplemento));    
    }

    //Busca um associado pelo nome
    public Associados buscarAssociado(String nomeAssociado) {
        for(int i = 0; i < listaAss.size(); i++){
            if(nomeAssociado.equals(listaAss.get(i).getNomeAssociado())){
                return listaAss.get(i);
            }
        }
        return null;
    }
    
    public void editarAssociado(Associados antigo, Associados novo){
        //Remove o antigo registro
        listaAss.remove(antigo);
        //Adiciona o novo
        listaAss.add(novo);
    }

    public void removeAssociado(String nomeAssociado){
        listaAss.remove(buscarAssociado(nomeAssociado));
    }
    
    public ArrayList getListaAssociados() {
        return listaAss;
    }

    public void setListaAssociados(ArrayList listaAssociados) {
        this.listaAss = listaAssociados;
    }
    
}
