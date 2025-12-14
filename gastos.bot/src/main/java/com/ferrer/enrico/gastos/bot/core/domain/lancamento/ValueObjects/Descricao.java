package com.ferrer.enrico.gastos.bot.core.domain.lancamento.ValueObjects;

public class Descricao {
    private String value;

    public static Descricao newDescricao(String value){
        if (value.length() > 100){
            throw new IllegalArgumentException("Descricao não pode ter mais de 100 caracteres");
        }
        return new Descricao(
          value
        );
    }

    private Descricao(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
