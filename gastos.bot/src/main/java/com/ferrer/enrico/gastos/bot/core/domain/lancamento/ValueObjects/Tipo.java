package com.ferrer.enrico.gastos.bot.core.domain.lancamento.ValueObjects;

import java.math.BigDecimal;
import java.util.Optional;

public enum Tipo {
    RECEITA("Receita", 1),
    DESPESA("Despesa", -1);

    private final String displayName;
    private final int sign;

    Tipo(String displayName, int sign) {
        this.displayName = displayName;
        this.sign = sign;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * Numeric sign to apply to amounts: +1 for RECEITA, -1 for DESPESA.
     */
    public int getSign() {
        return sign;
    }

    public boolean isReceita() {
        return this == RECEITA;
    }

    /**
     * Apply the tipo sign to a monetary amount (null-safe).
     */
    public BigDecimal applySign(BigDecimal amount) {
        if (amount == null) return null;
        return amount.multiply(BigDecimal.valueOf(sign));
    }

    /**
     * Tolerant parser: accepts enum name (case-insensitive), display name, or simple signs like "+"/"-".
     * Returns Optional.empty() when the input is null or cannot be parsed.
     */
    public static Optional<Tipo> fromString(String value) {
        if (value == null) return Optional.empty();
        String norm = value.trim();
        if (norm.isEmpty()) return Optional.empty();

        String up = norm.toUpperCase();
        for (Tipo t : values()) {
            if (t.name().equalsIgnoreCase(norm) || t.displayName.equalsIgnoreCase(norm)) {
                return Optional.of(t);
            }
        }

        // accept simple signs
        if ("+".equals(norm) || "+1".equals(norm) || "1".equals(norm)) return Optional.of(RECEITA);
        if ("-".equals(norm) || "-1".equals(norm) || "0".equals(norm)) return Optional.of(DESPESA);

        return Optional.empty();
    }

    /**
     * Strict parser that throws IllegalArgumentException for invalid input.
     */
    public static Tipo parse(String value) {
        return fromString(value).orElseThrow(() -> new IllegalArgumentException("Unknown Tipo: '" + value + "'"));
    }

    @Override
    public String toString() {
        return displayName;
    }
}
