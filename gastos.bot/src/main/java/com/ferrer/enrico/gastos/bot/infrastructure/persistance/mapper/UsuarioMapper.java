package com.ferrer.enrico.gastos.bot.infrastructure.persistance.mapper;

import com.ferrer.enrico.gastos.bot.core.adapters.dtos.usuarioDtos.UsuarioRequestDto;
import com.ferrer.enrico.gastos.bot.core.domain.usuario.Usuario;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity.UsuarioEntity;

public class UsuarioMapper {
    public static UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(
                usuario.getId().getValue().toString(),
                usuario.getChatId(),
                usuario.getUsername()
        );
    }

    public static Usuario toDomain(UsuarioEntity entity){
        return Usuario.existingUsuario(
                entity.getId(),
                entity.getChatId(),
                entity.getUsername()
        );
    }

    public static Usuario toDomain(UsuarioRequestDto dto){
        return Usuario.newUsuario(
            dto.chatId(),
            dto.username()
        );
    }

}
