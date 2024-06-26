package com.example.compras.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.compras.models.ProdutosResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@FeignClient(name = "produtos", url = "localhost:8100")
public interface ProdutosProxy {
    @GetMapping("/produtos/disponiveis")
    public ResponseEntity<List<ProdutosResponse>> produtosDisponiveis();
}
