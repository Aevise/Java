package pl.Aevise.code.projekt.mortgage.services;

import lombok.RequiredArgsConstructor;
import pl.Aevise.code.projekt.mortgage.model.InputData;
import pl.Aevise.code.projekt.mortgage.model.Rate;
import pl.Aevise.code.projekt.mortgage.model.Summary;

import java.util.List;

@RequiredArgsConstructor
public class MortgageCalculationServiceImpl implements MortgageCalculationService {

    private final RateCalculationService rateCalculationService;

    private final PrintingService printingService;

    private final SummaryService summaryService;


    @Override
    public void calculate(InputData inputData) {
        printingService.printIntroInformation(inputData);

        List<Rate> rates = rateCalculationService.calculate(inputData);
        Summary summary = summaryService.calculateSummary(rates);

        printingService.printSummary(summary);
        printingService.printSchedule(rates, inputData);
    }

}
