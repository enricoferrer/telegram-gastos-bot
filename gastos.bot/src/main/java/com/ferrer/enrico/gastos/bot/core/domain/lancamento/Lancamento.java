package com.ferrer.enrico.gastos.bot.core.domain.lancamento;

import com.ferrer.enrico.gastos.bot.core.domain.ValueObjects.Id;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.ValueObjects.Descricao;
import com.ferrer.enrico.gastos.bot.core.domain.lancamento.ValueObjects.Tipo;
import com.ferrer.enrico.gastos.bot.core.domain.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Lancamento {
    private Id id;
    private BigDecimal valor;
    private Descricao descricao;
    private Tipo tipo;
    private LocalDateTime data;
    private Usuario usuario;

    public static Lancamento newLancamento(BigDecimal valor, Descricao descricao, Tipo tipo, LocalDateTime data, Usuario usuario){
        return new Lancamento(
          Id.newId(),
          valor,
          descricao,
          tipo,
          data,
          usuario
        );
    }

    private Lancamento(Id id, BigDecimal valor, Descricao descricao, Tipo tipo, LocalDateTime data, Usuario usuario) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
        this.data = data;
        this.usuario = usuario;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
