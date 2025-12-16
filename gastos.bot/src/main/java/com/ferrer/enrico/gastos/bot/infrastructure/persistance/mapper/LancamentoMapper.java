package com.ferrer.enrico.gastos.bot.infrastructure.persistance.mapper;

import com.ferrer.enrico.gastos.bot.core.adapters.dtos.lancamentoDtos.LancamentoRequestDto;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.Lancamento;
import com.ferrer.enrico.gastos.bot.core.domain.usuario.Usuario;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity.LancamentoEntity;
import com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity.UsuarioEntity;

public class LancamentoMapper {
    public static LancamentoEntity toEntity(Lancamento lancamento){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(lancamento.getUsuario().getId().getValue().toString());

        return new LancamentoEntity(
                lancamento.getId().getValue().toString(),
                usuarioEntity,
                lancamento.getDescricao().getValue(),
                lancamento.getValor().doubleValue(),
                lancamento.getTipo().getDisplayName(),
                lancamento.getData()
        );
    }

    public static Lancamento toDomain(LancamentoEntity entity){
        Usuario usuario = UsuarioMapper.toDomain(entity.getUsuario());

        return Lancamento.existingLancamento(
                entity.getId(),
                entity.getValor(),
                entity.getDescricao(),
                entity.getTipo(),
                entity.getData(),
                usuario
        );
    }

    public static Lancamento toDomain(LancamentoRequestDto dto, Usuario usuario){
        return Lancamento.newLancamento(
                dto.valor(),
                dto.descricao(),
                dto.tipo(),
                usuario
        );
    }
}
