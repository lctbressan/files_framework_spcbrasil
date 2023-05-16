package com.br.spcbrasil.dto;

public class thusDbLocal {

    String Produto;
    Double preco;
    String TPN;

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String produto) {
        Produto = produto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTPN() {        return TPN;    }

    public void setTPN(String TPN) {        this.TPN = TPN;    }
}
