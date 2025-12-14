package com.ferrer.enrico.gastos.bot.core.application.ports;

import com.ferrer.enrico.gastos.bot.core.domain.usuario.Usuario;

public interface UsuarioRepositoryPort {
    public Usuario registrar(Usuario usuario);
    public Usuario buscarPorChatId(Long chatId);
}
