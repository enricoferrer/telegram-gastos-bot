package com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LancamentoEntity {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioEntity usuario;

    private String descricao;

    @Column(nullable = false)
    private Double valor;

    private String tipo;

    private LocalDateTime data;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
