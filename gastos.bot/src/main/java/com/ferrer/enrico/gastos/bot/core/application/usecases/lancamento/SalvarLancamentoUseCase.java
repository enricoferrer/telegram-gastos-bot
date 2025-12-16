package com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento;

import com.ferrer.enrico.gastos.bot.core.adapters.dtos.lancamentoDtos.LancamentoRequestDto;
import com.ferrer.enrico.gastos.bot.core.application.ports.LancamentoRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.application.ports.UsuarioRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.Lancamento;
import com.ferrer.enrico.gastos.bot.core.domain.usuario.Usuario;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.mapper.LancamentoMapper;

public class SalvarLancamentoUseCase {
    private final LancamentoRepositoryPort repository;
    private final UsuarioRepositoryPort usuarioRepository;

    public SalvarLancamentoUseCase(LancamentoRepositoryPort repository, UsuarioRepositoryPort usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public Lancamento executar(LancamentoRequestDto dto){
        validarEntradas(dto);
        Usuario usuario = usuarioRepository.buscarPorChatId(dto.usuarioChatId());
        Lancamento lancamento = LancamentoMapper.toDomain(dto, usuario);
        return repository.salvarLancamento(lancamento);
    }

    private void validarEntradas(LancamentoRequestDto dto){
        if (dto == null || dto.descricao() == null || dto.valor() == null || dto.tipo() == null || dto.usuarioChatId() == null) {
            throw new IllegalArgumentException("Dados do lançamento são obrigatórios");
        }
    }
}
