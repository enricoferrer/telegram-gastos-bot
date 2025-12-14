package com.ferrer.enrico.gastos.bot.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UsuarioEntity {
    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private Long chatId;

    private String username;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<LancamentoEntity> lancamentos;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public UsuarioEntity(String id, Long chatId, String username) {
        this.id = id;
        this.chatId = chatId;
        this.username = username;
    }
}
