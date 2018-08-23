/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Bento
 */
public class principalController {

    private associadoController controladorAssociados;
    private compraController controladorCompras;
    private empresaController controladorEmpresas;
    private materialController controladorMateriais;
    private vendaController controladorVendas;

    public principalController() {
        //Inicialização dos controladores
        controladorAssociados = new associadoController(this);
        controladorCompras = new compraController(this);
        controladorEmpresas = new empresaController(this);
        controladorMateriais = new materialController(this);
        controladorVendas = new vendaController(this);
    }

    public associadoController getControladorAssociados() {
        return controladorAssociados;
    }

    public compraController getControladorCompras() {
        return controladorCompras;
    }

    public empresaController getControladorEmpresas() {
        return controladorEmpresas;
    }

    public materialController getControladorMateriais() {
        return controladorMateriais;
    }

    public vendaController getControladorVendas() {
        return controladorVendas;
    }

}
