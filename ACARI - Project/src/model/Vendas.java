package model;
// Generated 08/08/2018 15:24:22 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Vendas generated by hbm2java
 */
public class Vendas  implements java.io.Serializable {


     private long idVenda;
     private long idEmpresa;

     private Boolean notaFiscal;
     
     private long idMaterial;
     private float QuantidadeKG;
     private float precoPorKilo;
     private float precoTotal;
     
     private Set itensVendidoses = new HashSet(0);

    public Vendas() {
    }

	
    public Vendas(long idVenda) {
        this.idVenda = idVenda;
    }
    public Vendas(long idVenda, Integer idEmpresa, Boolean notaFiscal, Set itensVendidoses) {
       this.idVenda = idVenda;
       this.idEmpresa = idEmpresa;
       this.notaFiscal = notaFiscal;
       this.itensVendidoses = itensVendidoses;
    }
    
      public long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public float getQuantidadeKG() {
        return QuantidadeKG;
    }

    public void setQuantidadeKG(float QuantidadeKG) {
        this.QuantidadeKG = QuantidadeKG;
    }

    public float getPrecoPorKilo() {
        return precoPorKilo;
    }

    public void setPrecoPorKilo(float precoPorKilo) {
        this.precoPorKilo = precoPorKilo;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
   
    public long getIdVenda() {
        return this.idVenda;
    }
    
    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }
    public long getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Boolean getNotaFiscal() {
        return this.notaFiscal;
    }
    
    public void setNotaFiscal(Boolean notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    public Set getItensVendidoses() {
        return this.itensVendidoses;
    }
    
    public void setItensVendidoses(Set itensVendidoses) {
        this.itensVendidoses = itensVendidoses;
    }




}


