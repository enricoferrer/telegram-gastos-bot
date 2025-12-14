package com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento;

import com.ferrer.enrico.gastos.bot.core.application.ports.LancamentoRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.Lancamento;

import java.util.List;

public class BuscarPorUsuarioIdUseCase {
    private final LancamentoRepositoryPort repository;

    public BuscarPorUsuarioIdUseCase(LancamentoRepositoryPort repository) {
        this.repository = repository;
    }

    public List<Lancamento> executar(String usuarioId){
        validarEntradas(usuarioId);
        return repository.buscarPorUsuarioId(usuarioId);
    }

    private void validarEntradas(String usuarioId){
        if(usuarioId == null || usuarioId.isEmpty()){
            throw new IllegalArgumentException("ID do usuário é obrigatório");
        }
    }
}
