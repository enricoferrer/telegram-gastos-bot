package com.ferrer.enrico.gastos.bot.core.adapters.dtos.lancamentoDtos;

public record LancamentoRequestDto(
        String descricao,
        Double valor,
        String tipo,
        Long usuarioChatId) {
}
