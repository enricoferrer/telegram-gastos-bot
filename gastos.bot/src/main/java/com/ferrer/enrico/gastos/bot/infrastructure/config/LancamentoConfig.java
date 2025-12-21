package com.ferrer.enrico.gastos.bot.infrastructure.config;

import com.ferrer.enrico.gastos.bot.core.application.ports.LancamentoRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.application.ports.UsuarioRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento.BuscarPorUsuarioIdUseCase;
import com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento.DeletarLancamentoUseCase;
import com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento.SalvarLancamentoUseCase;
import com.ferrer.enrico.gastos.bot.core.application.usecases.usuario.BuscarPorChatIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LancamentoConfig {

    @Bean
    public SalvarLancamentoUseCase salvarLancamentoUseCase(LancamentoRepositoryPort repositoryPort, UsuarioRepositoryPort usuarioRepositoryPort){
        return new SalvarLancamentoUseCase(repositoryPort, usuarioRepositoryPort);
    }

    @Bean
    public BuscarPorChatIdUseCase buscarPorChatIdUseCase(UsuarioRepositoryPort usuarioRepositoryPort){
        return new BuscarPorChatIdUseCase(usuarioRepositoryPort);
    }

    @Bean
    public BuscarPorUsuarioIdUseCase buscarPorUsuarioIdUseCase(LancamentoRepositoryPort repositoryPort){
        return new BuscarPorUsuarioIdUseCase(repositoryPort);
    }

    @Bean
    public DeletarLancamentoUseCase deletarLancamentoUseCase(LancamentoRepositoryPort repositoryPort){
        return new DeletarLancamentoUseCase(repositoryPort);
    }
}
