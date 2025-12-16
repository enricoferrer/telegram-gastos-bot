package com.ferrer.enrico.gastos.bot.infrastructure.persistance.repository;

import com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryImpl extends JpaRepository<UsuarioEntity, String> {
}
