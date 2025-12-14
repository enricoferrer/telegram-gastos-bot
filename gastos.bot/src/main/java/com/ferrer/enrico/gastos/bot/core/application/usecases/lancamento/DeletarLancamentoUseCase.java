package com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento;

import com.ferrer.enrico.gastos.bot.core.application.ports.LancamentoRepositoryPort;

public class DeletarLancamentoUseCase {
    private final LancamentoRepositoryPort repository;

    public DeletarLancamentoUseCase(LancamentoRepositoryPort repository) {
        this.repository = repository;
    }

    public void executar(String id){
        validarEntradas(id);
        repository.deletarLancamento(id);
    }

    private void validarEntradas(String id){
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID do lançamento é obrigatório");
        }
    }
}
