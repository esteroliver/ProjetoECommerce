package com.example.compras.view;

import org.springframework.web.bind.annotation.RestController;

import com.example.compras.models.CompraDTO;
import com.example.compras.models.CompraRequest;
import com.example.compras.models.CompraResponse;
import com.example.compras.service.CompraService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService service;

    @GetMapping("")
    public ResponseEntity<List<CompraResponse>> listarCompras(){
        List<CompraDTO> compras = service.listarCompras();
        List<CompraResponse> compras_response = new ArrayList<>();
        BeanUtils.copyProperties(compras, compras_response);
        return new ResponseEntity<>(compras_response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CompraResponse>> obterCompra(@PathVariable Long id) {
        Optional<CompraDTO> compra = service.obterCompra(id);
        CompraResponse compra_response = new CompraResponse();
        BeanUtils.copyProperties(compra, compra_response);
        return new ResponseEntity<>(Optional.of(compra_response), HttpStatus.OK);
    }

    @PutMapping("/nova-compra")
    public ResponseEntity<CompraResponse> novaCompra(@RequestBody CompraRequest compra) {
        CompraDTO nova_compra = new CompraDTO();
        BeanUtils.copyProperties(compra, nova_compra);
        service.adicionarCompra(nova_compra);
        CompraResponse compra_response = new CompraResponse();
        BeanUtils.copyProperties(compra, compra_response);
        return new ResponseEntity<>(compra_response, HttpStatus.CREATED);
    }

    @PostMapping("/atualizar-compra")
    public ResponseEntity<Optional<CompraResponse>> atualizarCompra(@RequestBody CompraRequest compra) {
        CompraDTO atualizar_compra = new CompraDTO();
        BeanUtils.copyProperties(compra, atualizar_compra);
        service.atualizarCompra(atualizar_compra);
        CompraResponse compra_response = new CompraResponse();
        BeanUtils.copyProperties(compra, compra_response);
        return new ResponseEntity<>(Optional.of(compra_response), HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar-compra")
    public ResponseEntity<Optional<CompraResponse>> deletarCompra(@RequestBody CompraRequest compra){
        CompraDTO deletar_compra = new CompraDTO();
        BeanUtils.copyProperties(compra, deletar_compra);
        service.deletarCompra(deletar_compra);
        CompraResponse compra_response = new CompraResponse();
        BeanUtils.copyProperties(compra, compra_response);
        return new ResponseEntity<>(Optional.of(compra_response), HttpStatus.OK);
    }

    
    
}
