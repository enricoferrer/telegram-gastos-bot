package com.ferrer.enrico.gastos.bot.infrastructure.persistance.repository;

import com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity.LancamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LancamentoRepositoryImpl extends JpaRepository<LancamentoEntity, String> {
    Optional<LancamentoEntity> findById(String id);
    List<LancamentoEntity> findByUsuarioId(String id);
}
