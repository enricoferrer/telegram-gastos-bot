package com.ferrer.enrico.gastos.bot.infrastructure.persistance.adapter.jpa;

import com.ferrer.enrico.gastos.bot.core.application.ports.UsuarioRepositoryPort;
import com.ferrer.enrico.gastos.bot.core.domain.usuario.Usuario;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity.UsuarioEntity;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.mapper.UsuarioMapper;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.repository.UsuarioRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioJpaAdapter implements UsuarioRepositoryPort {
    private final UsuarioRepositoryImpl repository;

    public UsuarioJpaAdapter(UsuarioRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity registrado = repository.save(entity);
        return UsuarioMapper.toDomain(registrado);
    }

    @Override
    public Usuario buscarPorChatId(Long chatId) {
        UsuarioEntity entity = repository.findByChatId(chatId);
        return UsuarioMapper.toDomain(entity);
    }
}
