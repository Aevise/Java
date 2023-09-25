package pl.Aevise.code.projekt.mortgage.services;

import pl.Aevise.code.projekt.mortgage.model.InputData;
import pl.Aevise.code.projekt.mortgage.model.MortgageResidual;
import pl.Aevise.code.projekt.mortgage.model.Rate;
import pl.Aevise.code.projekt.mortgage.model.RateAmounts;

public interface ResidualCalculationService {

    MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData);

    MortgageResidual calculate(RateAmounts rateAmounts, final InputData inputData, Rate previousRate);

}
