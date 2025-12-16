package com.ferrer.enrico.gastos.bot.core.adapters.dtos.usuarioDtos;

public record UsuarioRequestDto(
        Long chatId,
        String username
) {
}
