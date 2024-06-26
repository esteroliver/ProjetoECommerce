package com.example.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.compras.models.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
    
}
