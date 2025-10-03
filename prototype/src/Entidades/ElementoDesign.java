package Entidades;

public interface ElementoDesign {
    ElementoDesign clone();
    String getCorFundo();
    String getCorTexto();
    String getFonte();
    void setCorFundo(String cor);
    void setCorTexto(String cor);
    void setFonte(String fonte);
}