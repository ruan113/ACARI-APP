/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acari;

import controller.principalController;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Vendas;

/**
 *
 * @author Bento
 */
public class modeloTabelaVendas extends AbstractTableModel {

    //MODELO DA TABELA
    private ArrayList<Vendas> linhas = null;//Linhas
    private String[] colunas = {"Empresa", "Data","Valor Total", "Nota Fiscal"};//Colunas
    private principalController principalControlador;

    public modeloTabelaVendas(ArrayList lin, principalController principalControlador) {
        setLinhas(lin);
        this.principalControlador = principalControlador; 
    }

    public ArrayList<Vendas> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<Vendas> linhas) {
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
                return principalControlador.getControladorEmpresas().buscaEmpresaID(linhas.get(linha).getId_empresa()).getNomeEmpresa();
            case 1:
                return linhas.get(linha).getData();
            case 2:
                return principalControlador.getControladorVendas().getPrecoTotalVendaID(linhas.get(linha).getId_venda());
            case 3:
                return (linhas.get(linha).getNota_fiscal() ? "X" : "");
        }
        return null;
    }
}
