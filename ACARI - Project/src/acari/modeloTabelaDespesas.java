/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acari;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Despesas;

/**
 *
 * @author Bento
 */
public class modeloTabelaDespesas extends AbstractTableModel {

    //MODELO DA TABELA
    private ArrayList<Despesas> linhas = null;//Linhas
    private String[] colunas = {"Titulo", "Tipo","Valor", "Data"};//Colunas

    public modeloTabelaDespesas(ArrayList lin) {
        setLinhas(lin);
    }

    public ArrayList<Despesas> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<Despesas> linhas) {
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
                return linhas.get(linha).getTitulo();
            case 1:
                return linhas.get(linha).getTipo();
            case 2:
                return linhas.get(linha).getValor();
            case 3:
                return linhas.get(linha).getData();
        }
        return null;
    }
}
