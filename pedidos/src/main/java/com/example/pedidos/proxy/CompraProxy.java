package com.example.pedidos.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "compras", url = "localhost:8010")
public interface CompraProxy {
    
}
