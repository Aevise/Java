package pl.Aevise.code.projekt.mortgage.services;

import pl.Aevise.code.projekt.mortgage.model.InputData;
import pl.Aevise.code.projekt.mortgage.model.MortgageReference;
import pl.Aevise.code.projekt.mortgage.model.Rate;
import pl.Aevise.code.projekt.mortgage.model.RateAmounts;

public interface ReferenceCalculationService {

    MortgageReference calculate(RateAmounts rateAmounts, InputData inputData);

    MortgageReference calculate(RateAmounts rateAmounts, final InputData inputData, Rate previousRate);

}
