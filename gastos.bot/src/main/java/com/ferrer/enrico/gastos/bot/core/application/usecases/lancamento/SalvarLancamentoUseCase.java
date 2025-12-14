package com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento;

import com.ferrer.enrico.gastos.bot.core.application.ports.LancamentoRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.Lancamento;

public class SalvarLancamentoUseCase {
    private final LancamentoRepositoryPort repository;

    public SalvarLancamentoUseCase(LancamentoRepositoryPort repository) {
        this.repository = repository;
    }

    public Lancamento executar(Lancamento lancamento){
        validarEntradas(lancamento);
        return repository.salvarLancamento(lancamento);
    }

    private void validarEntradas(Lancamento lancamento){
        if(lancamento == null){
            throw new IllegalArgumentException("Lançamento não pode ser nulo");
        }
        if(lancamento.getDescricao() == null || lancamento.getDescricao().getValue().isEmpty()){
            throw new IllegalArgumentException("Descrição do lançamento é obrigatória");
        }
        if(lancamento.getValor() == null){
            throw new IllegalArgumentException("Valor do lançamento deve ser maior que zero");
        }
        if(lancamento.getTipo() == null || lancamento.getTipo().getDisplayName().isEmpty()){
            throw new IllegalArgumentException("Tipo do lançamento é obrigatório");
        }
    }
}
