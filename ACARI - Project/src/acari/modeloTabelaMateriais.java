/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acari;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Materiais;

/**
 *
 * @author Bento
 */
public class modeloTabelaMateriais extends AbstractTableModel {

    //MODELO DA TABELA
    private ArrayList<Materiais> linhas = null;//Linhas
    private String[] colunas = {"Nome", "Tipo"};//Colunas

    public modeloTabelaMateriais(ArrayList lin) {
        setLinhas(lin);
    }

    public ArrayList<Materiais> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<Materiais> linhas) {
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
                return linhas.get(linha).getMaterialNome();
            case 1:
                return linhas.get(linha).getTipoMaterial();
        }
        return null;
    }
}
