package com.ferrer.enrico.gastos.bot.core.application.usecases.usuario;

import com.ferrer.enrico.gastos.bot.core.application.ports.UsuarioRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.domain.usuario.Usuario;

public class RegistrarUsuarioUseCase {
    private final UsuarioRepositoryPort repository;

    public RegistrarUsuarioUseCase(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    public Usuario executar(Long chatId, String username){
        validarEntradas(chatId, username);

        Usuario usuarioPossivel = repository.buscarPorChatId(chatId);
        if(usuarioPossivel != null){
            throw new IllegalArgumentException("Usuário já registrado");
        }

        Usuario novoUsuario = Usuario.newUsuario(chatId, username);
        return repository.registrar(novoUsuario);
    }

    private void validarEntradas(Long chatId, String username){
        if(chatId == null || chatId <= 0){
            throw new IllegalArgumentException("ChatId inválido");
        }
        if(username == null || username.isBlank()){
            throw new IllegalArgumentException("Username não pode ser vazio");
        }
    }
}
