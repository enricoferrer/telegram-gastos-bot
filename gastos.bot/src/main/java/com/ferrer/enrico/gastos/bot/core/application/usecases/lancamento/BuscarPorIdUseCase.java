package com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento;

import com.ferrer.enrico.gastos.bot.core.application.ports.LancamentoRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.Lancamento;

public class BuscarPorIdUseCase {
    private final LancamentoRepositoryPort repository;

    public BuscarPorIdUseCase(LancamentoRepositoryPort repository) {
        this.repository = repository;
    }

    public Lancamento executar(String id){
        validarEntradas(id);
        return repository.buscarPorId(id);
    }

    private void validarEntradas(String id){
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID do lançamento é obrigatório");
        }
    }
}
