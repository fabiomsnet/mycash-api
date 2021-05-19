package org.bootcamp.spring.mycashapi.repository;

import org.bootcamp.spring.mycashapi.domain.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
}
