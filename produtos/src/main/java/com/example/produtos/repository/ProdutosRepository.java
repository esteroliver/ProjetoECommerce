package com.example.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.produtos.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

}
