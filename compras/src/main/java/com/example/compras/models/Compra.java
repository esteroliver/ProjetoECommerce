package com.example.compras.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private List<ProdutosResponse> produtos;
    public Compra() {
    }
    public Compra(Long id, String codigo, List<ProdutosResponse> produtos) {
        this.id = id;
        this.codigo = codigo;
        this.produtos = produtos;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public List<ProdutosResponse> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<ProdutosResponse> produtos) {
        this.produtos = produtos;
    }
    public void addProduto(ProdutosResponse prod){
        produtos.add(prod);
    }
}
