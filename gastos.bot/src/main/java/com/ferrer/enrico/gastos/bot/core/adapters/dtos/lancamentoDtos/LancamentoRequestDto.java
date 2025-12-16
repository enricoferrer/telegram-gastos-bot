package com.ferrer.enrico.gastos.bot.core.adapters.dtos.lancamentoDtos;

import java.math.BigDecimal;

public record LancamentoRequestDto(
        String descricao,
        BigDecimal valor,
        String tipo,
        Long usuarioChatId
) {
}
