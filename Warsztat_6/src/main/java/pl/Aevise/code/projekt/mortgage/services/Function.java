package pl.Aevise.code.projekt.mortgage.services;

import pl.Aevise.code.projekt.mortgage.model.Rate;

import java.math.BigDecimal;

public interface Function {

    BigDecimal calculate(Rate rate);
}
