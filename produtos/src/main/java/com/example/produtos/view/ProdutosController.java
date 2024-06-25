package com.example.produtos.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtos.service.ProdutosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.produtos.model.ProdutosDTO;
import com.example.produtos.model.ProdutosRequest;
import com.example.produtos.model.ProdutosResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosService service;

    @GetMapping("")
    public ResponseEntity<List<ProdutosResponse>> listarProdutos() {
        List<ProdutosDTO> produtos = service.listarProdutos();
        List<ProdutosResponse> produtos_response = new ArrayList<>();
        BeanUtils.copyProperties(produtos, produtos_response);
        return new ResponseEntity<>(produtos_response, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutosResponse>> encontrarProduto(@PathVariable UUID id) {
        Optional<ProdutosDTO> prod = service.encontrarProduto(id);
        ProdutosResponse prod_response = new ProdutosResponse();
        BeanUtils.copyProperties(prod, prod_response);
        return new ResponseEntity<>(Optional.of(prod_response), HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<ProdutosResponse> adicionarProdutos(@RequestBody ProdutosRequest prod) {
        ProdutosDTO produto = new ProdutosDTO();
        BeanUtils.copyProperties(prod, produto);
        service.adicionarProdutos(produto);
        ProdutosResponse produto_response = new ProdutosResponse();
        BeanUtils.copyProperties(prod, produto_response);
        return new ResponseEntity<>(produto_response, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Optional<ProdutosResponse>> atualizarProdutos(@RequestBody ProdutosRequest prod) {
        ProdutosDTO produto = new ProdutosDTO();
        BeanUtils.copyProperties(prod, produto);
        service.atualizaProdutos(produto);
        ProdutosResponse produto_response = new ProdutosResponse();
        BeanUtils.copyProperties(prod, produto_response);
        return new ResponseEntity<>(Optional.of(produto_response), HttpStatus.OK);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Optional<ProdutosResponse>> deletarProdutos(@RequestBody ProdutosRequest prod){
        ProdutosDTO produto = new ProdutosDTO();
        BeanUtils.copyProperties(prod, produto);
        service.deletarProduto(produto);
        ProdutosResponse produto_response = new ProdutosResponse();
        BeanUtils.copyProperties(prod, produto_response);
        return new ResponseEntity<>(Optional.of(produto_response), HttpStatus.ACCEPTED);
    }
    
    
}
