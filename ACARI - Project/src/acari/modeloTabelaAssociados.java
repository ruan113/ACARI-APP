/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acari;

import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;
import model.Associados;

/**
 *
 * @author Bento
 */
public class modeloTabelaAssociados extends AbstractTableModel {

    //MODELO DA TABELA
    private ArrayList<Associados> linhas = null;//Linhas
    private String[] colunas = {"Nome", "Cidade", "Estado"};//Colunas

    public modeloTabelaAssociados(ArrayList lin) {
        setLinhas(lin);
    }

    public ArrayList<Associados> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<Associados> linhas) {
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
                return linhas.get(linha).getNomeAssociado();
            case 1:
                return linhas.get(linha).getCidadeAssociado();
            case 2:
                return linhas.get(linha).getUf();
        }
        return null;
    }
}
