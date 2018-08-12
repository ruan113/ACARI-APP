package model;
// Generated 08/08/2018 15:24:22 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Compras generated by hbm2java
 */
public class Compras  implements java.io.Serializable {


     private long idCompra;
     private Integer idAssociado;
     private Set itensCompradoses = new HashSet(0);

    public Compras() {
    }

	
    public Compras(long idCompra) {
        this.idCompra = idCompra;
    }
    public Compras(long idCompra, Integer idAssociado, Set itensCompradoses) {
       this.idCompra = idCompra;
       this.idAssociado = idAssociado;
       this.itensCompradoses = itensCompradoses;
    }
   
    public long getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(long idCompra) {
        this.idCompra = idCompra;
    }
    public Integer getIdAssociado() {
        return this.idAssociado;
    }
    
    public void setIdAssociado(Integer idAssociado) {
        this.idAssociado = idAssociado;
    }
    public Set getItensCompradoses() {
        return this.itensCompradoses;
    }
    
    public void setItensCompradoses(Set itensCompradoses) {
        this.itensCompradoses = itensCompradoses;
    }




}


