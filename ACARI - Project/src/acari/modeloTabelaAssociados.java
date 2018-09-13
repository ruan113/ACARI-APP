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
    private String[] colunas = {"Nome", "CPF", "RG", "Cidade", "Rua", "Numero", "Bairro", "UF", "Complemento"};//Colunas

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
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return linhas.get(linha).getNomeAssociado();
            case 1:
                return linhas.get(linha).getCpfAssociado();
            case 2:
                return linhas.get(linha).getRgAssociado();
            case 3:
                return linhas.get(linha).getCidadeAssociado();
            case 4:
                return linhas.get(linha).getEndRua();
            case 5:
                return linhas.get(linha).getEndNum();
            case 6:
                return linhas.get(linha).getEndBairro();
            case 7:
                return linhas.get(linha).getUf();
            case 8:
                return linhas.get(linha).getEndComplemento();
        }
        return null;
    }
}
