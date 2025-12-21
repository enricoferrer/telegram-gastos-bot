package com.ferrer.enrico.gastos.bot.infrastructure.config;

import com.ferrer.enrico.gastos.bot.core.application.ports.UsuarioRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.application.usecases.usuario.BuscarPorChatIdUseCase;
import com.ferrer.enrico.gastos.bot.core.application.usecases.usuario.RegistrarUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(UsuarioRepositoryPort repositoryPort){
        return new RegistrarUsuarioUseCase(repositoryPort);
    }

    @Bean
    public BuscarPorChatIdUseCase buscarPorChatIdUseCase(UsuarioRepositoryPort repositoryPort){
        return new BuscarPorChatIdUseCase(repositoryPort);
    }
}
