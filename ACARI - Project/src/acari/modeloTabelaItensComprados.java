/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acari;

import controller.principalController;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.ItemComprado;

/**
 *
 * @author Bento
 */
public class modeloTabelaItensComprados extends AbstractTableModel {

    //MODELO DA TABELA
    private ArrayList<ItemComprado> linhas = null;//Linhas
    private String[] colunas = {"Material", "Quantidade","Preco/KG", "Preco_Total"};//Colunas
    private principalController principalControlador;

    public modeloTabelaItensComprados(ArrayList lin, principalController principalControlador) {
        setLinhas(lin);
        this.principalControlador = principalControlador; 
    }

    public ArrayList<ItemComprado> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<ItemComprado> linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return colunas[index];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return principalControlador.getControladorMateriais().buscaMaterialID(linhas.get(linha).getId_material()).getMaterialNome();
            case 1:
                return linhas.get(linha).getQuantidade();
            case 2:
                return linhas.get(linha).getPreco_kg();
            case 3:
                return linhas.get(linha).getPreco_total();
        }
        return null;
    }
}
