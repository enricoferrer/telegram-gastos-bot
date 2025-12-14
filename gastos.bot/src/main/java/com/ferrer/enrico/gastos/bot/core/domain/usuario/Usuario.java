package com.ferrer.enrico.gastos.bot.core.domain.usuario;

import com.ferrer.enrico.gastos.bot.core.domain.ValueObjects.Id;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.Lancamento;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Id id;
    private Long chatId;
    private String username;
    private List<Lancamento> lancamentos;

    public static Usuario newUsuario(Long chatId, String username){
        return new Usuario(
               Id.newId(),
                chatId,
                username
        );
    }

    private Usuario(Id id, Long chatId, String username) {
        this.id = id;
        this.chatId = chatId;
        this.username = username;
        this.lancamentos = new ArrayList<>();
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
}
