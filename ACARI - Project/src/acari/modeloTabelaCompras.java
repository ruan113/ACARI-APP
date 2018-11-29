/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acari;

import controller.principalController;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Compras;

/**
 *
 * @author Bento
 */
public class modeloTabelaCompras extends AbstractTableModel {

    //MODELO DA TABELA
    private ArrayList<Compras> linhas = null;//Linhas
    private String[] colunas = {"Associado", "Data","Valor"};//Colunas
    private principalController principalControlador;

    public modeloTabelaCompras(ArrayList lin, principalController principalControlador) {
        setLinhas(lin);
        this.principalControlador = principalControlador; 
    }

    public ArrayList<Compras> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<Compras> linhas) {
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
                return principalControlador.getControladorAssociados().buscaAssociadoID( linhas.get(linha).getIdAssociado()).getNomeAssociado();
            case 1:
                return linhas.get(linha).getData();
            case 2:
                return principalControlador.getControladorCompras().getPrecoTotalCompraID(linhas.get(linha).getIdCompra());
        }
        return null;
    }
}
