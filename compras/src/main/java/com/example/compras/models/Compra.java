package com.example.compras.models;

import java.util.List;
import java.util.UUID;

public class Compra {
    private UUID id;
    private String codigo;
    private List<ProdutosResponse> produtos;
}
