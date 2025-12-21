package com.ferrer.enrico.gastos.bot.infrastructure.persistance.adapter;

import com.ferrer.enrico.gastos.bot.core.application.ports.LancamentoRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.Lancamento;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity.LancamentoEntity;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.mapper.LancamentoMapper;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.repository.LancamentoRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LancamentoJpaAdapter implements LancamentoRepositoryPort {
    private final LancamentoRepositoryImpl repository;

    public LancamentoJpaAdapter(LancamentoRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Lancamento salvarLancamento(Lancamento lancamento) {
        LancamentoEntity entity = LancamentoMapper.toEntity(lancamento);
        LancamentoEntity saved = repository.save(entity);
        return LancamentoMapper.toDomain(saved);
    }

    @Override
    public Lancamento buscarPorId(String id) {
        Optional<LancamentoEntity> possivelEntity = repository.findById(id);
        return possivelEntity.map(LancamentoMapper::toDomain).orElse(null);
    }

    @Override
    public List<Lancamento> buscarPorUsuarioId(String usuarioId) {
        List<LancamentoEntity> listaLancamentosEntities = repository.findByUsuarioId(usuarioId);
        return listaLancamentosEntities.stream().map(LancamentoMapper::toDomain).toList();
    }

    @Override
    public void deletarLancamento(String id) {
        repository.deleteById(id);
    }
}
