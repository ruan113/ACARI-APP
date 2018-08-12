package model;
// Generated 08/08/2018 15:24:22 by Hibernate Tools 4.3.1



/**
 * Associados generated by hbm2java
 */
public class Associados  implements java.io.Serializable {


     private int idAssociado;
     private String cpfAssociado;
     private String rgAssociado;
     private Short endNum;
     private String endRua;
     private String endBairro;
     private String uf;

    public Associados() {
    }

	
    public Associados(int idAssociado) {
        this.idAssociado = idAssociado;
    }
    public Associados(int idAssociado, String cpfAssociado, String rgAssociado, Short endNum, String endRua, String endBairro, String uf) {
       this.idAssociado = idAssociado;
       this.cpfAssociado = cpfAssociado;
       this.rgAssociado = rgAssociado;
       this.endNum = endNum;
       this.endRua = endRua;
       this.endBairro = endBairro;
       this.uf = uf;
    }
   
    public int getIdAssociado() {
        return this.idAssociado;
    }
    
    public void setIdAssociado(int idAssociado) {
        this.idAssociado = idAssociado;
    }
    public String getCpfAssociado() {
        return this.cpfAssociado;
    }
    
    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }
    public String getRgAssociado() {
        return this.rgAssociado;
    }
    
    public void setRgAssociado(String rgAssociado) {
        this.rgAssociado = rgAssociado;
    }
    public Short getEndNum() {
        return this.endNum;
    }
    
    public void setEndNum(Short endNum) {
        this.endNum = endNum;
    }
    public String getEndRua() {
        return this.endRua;
    }
    
    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }
    public String getEndBairro() {
        return this.endBairro;
    }
    
    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }
    public String getUf() {
        return this.uf;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
    }




}


