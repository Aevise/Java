package pl.Aevise.code.projekt.mortgage.services;


import pl.Aevise.code.projekt.mortgage.model.InputData;
import pl.Aevise.code.projekt.mortgage.model.Overpayment;
import pl.Aevise.code.projekt.mortgage.model.Rate;
import pl.Aevise.code.projekt.mortgage.model.RateAmounts;

public interface ConstantAmountsCalculationService {

    RateAmounts calculate(InputData inputData, Overpayment overpayment);

    RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
