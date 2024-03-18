package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    
}
