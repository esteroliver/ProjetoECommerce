package com.example.produtos.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.produtos.model.Produtos;
import com.example.produtos.model.ProdutosDTO;
import com.example.produtos.repository.ProdutosRepository;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository repository;

    public ProdutosDTO adicionarProdutos(ProdutosDTO prod){
        Produtos prod_novo = new Produtos();
        BeanUtils.copyProperties(prod, prod_novo);
        repository.save(prod_novo);
        return prod;
    }

    public ProdutosDTO atualizaProdutos(ProdutosDTO prod){
        Optional<Produtos> prod_atualizado = repository.findById(prod.getId());
        if(prod_atualizado.isEmpty()){
            throw new RuntimeException("Produto não existe.");
        }
        Produtos prod_atualizado_novo = prod_atualizado.get();
        repository.save(prod_atualizado_novo);
        return prod;
    }
}
