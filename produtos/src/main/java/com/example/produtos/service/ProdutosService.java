package com.example.produtos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<ProdutosDTO> encontrarProduto(UUID id){
        Optional<Produtos> prod_01 = repository.findById(id);
        if(prod_01.isEmpty()){
            throw new RuntimeException("Produto não existe.");
        }
        ProdutosDTO prod_02 = new ProdutosDTO();
        BeanUtils.copyProperties(prod_01, prod_02);
        return Optional.of(prod_02);
    }

    public List<ProdutosDTO> listarProdutos(){
        List<Produtos> prods_01 = repository.findAll();
        List<ProdutosDTO> prods_02 = new ArrayList<>();
        BeanUtils.copyProperties(prods_01, prods_02);
        return prods_02;
    }

    public ProdutosDTO adicionarProdutos(ProdutosDTO prod){
        Produtos prod_01 = new Produtos();
        BeanUtils.copyProperties(prod, prod_01);
        repository.save(prod_01);
        return prod;
    }

    public Optional<ProdutosDTO> atualizaProdutos(ProdutosDTO prod){
        Optional<Produtos> prod_01= repository.findById(prod.getId());
        if(prod_01.isEmpty()){
            throw new RuntimeException("Produto não existe.");
        }
        Produtos prod_02 = prod_01.get();
        repository.save(prod_02);
        return Optional.of(prod);
    }

    public Optional<ProdutosDTO> deletarProduto(ProdutosDTO prod){
        Optional<Produtos> prod_01 = repository.findById(prod.getId());
        if(prod_01.isEmpty()){
            throw new RuntimeException("Produto não existe.");
        }
        Produtos prod_02 = prod_01.get();
        repository.delete(prod_02);
        return Optional.of(prod);
    }
}
