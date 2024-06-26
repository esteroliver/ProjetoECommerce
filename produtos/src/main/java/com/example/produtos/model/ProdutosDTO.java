package com.example.produtos.model;

public class ProdutosDTO {
    private Long id;
    private Double valor;
    private String nome;
    private Integer quantidade;
    private String descricao;
    public ProdutosDTO() {
    }
    public ProdutosDTO(Long id, Double valor, String nome, Integer quantidade, String descricao) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
