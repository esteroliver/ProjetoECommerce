package com.example.compras.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.compras.models.Compra;
import com.example.compras.models.CompraDTO;
import com.example.compras.models.ProdutosResponse;
import com.example.compras.proxy.ProdutosProxy;
import com.example.compras.repository.CompraRepository;

@Service
public class CompraService {
    @Autowired
    private CompraRepository repository;

    @Autowired
    private ProdutosProxy produtos_proxy;

    /*
     * obterCompra
     * listarCompras
     * adicionarCompra
     * atualizarCompra
     * deletarCompra
     * 
     * adicionarProduto
     * finalizarCompra
    */

    //CRUD
    public Optional<CompraDTO> obterCompra(Long id){
        Optional<Compra> compra = repository.findById(id);
        if(compra.isEmpty()){
            throw new RuntimeException("Compra não foi encontrada.");
        }
        CompraDTO compra_dto = new CompraDTO();
        BeanUtils.copyProperties(compra, compra_dto);
        return Optional.of(compra_dto);
    }

    public List<CompraDTO> listarCompras(){
        List<Compra> compras = repository.findAll();
        List<CompraDTO> compras_dto = new ArrayList<>();
        BeanUtils.copyProperties(compras, compras_dto);
        return compras_dto;
    }

    public CompraDTO adicionarCompra(CompraDTO compra){
        Compra compra_01 = new Compra();
        BeanUtils.copyProperties(compra, compra_01);
        repository.save(compra_01);
        return compra;
    }

    public Optional<CompraDTO> atualizarCompra(CompraDTO compra){
        Optional<Compra> compra_01 = repository.findById(compra.getId());
        if(compra_01.isEmpty()){
            throw new RuntimeException("Compra não foi encontrada.");
        }
        Compra compra_02 = compra_01.get();
        repository.save(compra_02);
        return Optional.of(compra);
    }

    public Optional<CompraDTO> deletarCompra(CompraDTO compra){
        Optional<Compra> compra_01 = repository.findById(compra.getId());
        if(compra_01.isEmpty()){
            throw new RuntimeException("Compra não foi encontrada.");
        }
        Compra compra_02 = compra_01.get();
        Compra compra_03 = new Compra();
        BeanUtils.copyProperties(compra, compra_03);
        if(compra_02 == compra_03)
            repository.delete(compra_02);
        else
            throw new RuntimeException("Compra são incompatíveis.");
        return Optional.of(compra);
    }

    //MÉTODOS
    public CompraDTO adicionarProduto(ProdutosResponse prod, CompraDTO compra){
        List<ProdutosResponse> produtos_disponiveis = produtos_proxy.produtosDisponiveis().getBody();
        Boolean produto_existe = false;
        for (ProdutosResponse prodResponse : produtos_disponiveis) {
            if(prod == prodResponse){
                produto_existe = true;
                break;
            }
        }
        Compra compra_01 = new Compra();
        BeanUtils.copyProperties(compra, compra_01);
        if(produto_existe){
            compra_01.addProduto(prod);
            compra.addProduto(prod);
        }
        repository.save(compra_01);
        return compra;
    }
    public CompraDTO finalizarCompra(CompraDTO compra){
        Compra compra_finalizada = new Compra();
        BeanUtils.copyProperties(compra, compra_finalizada);
        repository.delete(compra_finalizada);
        return compra;
    } //esse método vai ser usado pelo serviço Pedido
}
