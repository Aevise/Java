package pl.Aevise.code.projekt.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MortgageType {
    CONSTANT("CONSTANT"),
    DECREASING("DECREASING");

    @Getter
    private final String value;

}
