package com.ferrer.enrico.gastos.bot.core.application.ports;

import com.ferrer.enrico.gastos.bot.core.domain.lancamento.Lancamento;

import java.util.List;

public interface LancamentoRepositoryPort {
    public Lancamento salvarLancamento(Lancamento lancamento);
    public Lancamento buscarPorId(String id);
    public List<Lancamento> buscarPorUsuarioId(String usuarioId);
    public void deletarLancamento(String id);
}
