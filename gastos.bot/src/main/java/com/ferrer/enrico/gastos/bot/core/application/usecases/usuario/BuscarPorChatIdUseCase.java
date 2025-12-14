package com.ferrer.enrico.gastos.bot.core.application.usecases.usuario;

import com.ferrer.enrico.gastos.bot.core.application.ports.UsuarioRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.domain.usuario.Usuario;

public class BuscarPorChatIdUseCase {
    private final UsuarioRepositoryPort repository;

    public BuscarPorChatIdUseCase(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    public Usuario executar(Long chatId){
        validarEntradas(chatId);
        return repository.buscarPorChatId(chatId);
    }

    private void validarEntradas(Long chatId){
        if(chatId == null || chatId <= 0){
            throw new IllegalArgumentException("ChatId inválido");
        }
    }
}
