package com.example.produtos.model;

import java.util.UUID;

public class ProdutosDTO {
    private UUID id;
    private Double valor;
    private String nome;
    private Integer quantidade;
    private String descricao;
    public ProdutosDTO() {
    }
    public ProdutosDTO(UUID id, Double valor, String nome, Integer quantidade, String descricao) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
