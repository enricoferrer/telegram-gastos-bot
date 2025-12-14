package com.ferrer.enrico.gastos.bot.core.domain.ValueObjects;

import java.util.UUID;

public class Id {
    private UUID value;

    public static Id newId(){
        return new Id(
          UUID.randomUUID()
        );
    }

    public static Id existingId(String idString){
        return new Id(
                UUID.fromString(idString)
        );
    }

    private Id(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }
}
