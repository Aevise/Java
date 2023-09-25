package pl.Aevise.code.projekt.mortgage.services;

import pl.Aevise.code.projekt.mortgage.model.InputData;
import pl.Aevise.code.projekt.mortgage.model.Rate;

import java.util.List;

public interface RateCalculationService {

    List<Rate> calculate(InputData inputData);
}
