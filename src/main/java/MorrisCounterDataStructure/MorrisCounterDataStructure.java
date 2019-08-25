package MorrisCounterDataStructure;

import java.util.ArrayList;
import java.util.Comparator;

public class MorrisCounterDataStructure {

    private AbstractMorrisCounter[][]
            morrisCounters;

    public MorrisCounterDataStructure(Double probabilityOfBadEstimate,
                               Double normalizedFactorOfDeferenceWithExactSolution)
    {
        morrisCounters =
                new MorrisCounterNotStoringEstimatedValue
                        [numberOfRows(probabilityOfBadEstimate)]
                        [numberOfColumns(normalizedFactorOfDeferenceWithExactSolution)];
        for(int indexOnRow = 0; indexOnRow < morrisCounters.length; indexOnRow++)
        {
            for(int indexOnColumn = 0; indexOnColumn < morrisCounters[0].length; indexOnColumn++)
            {
                morrisCounters[indexOnRow][indexOnColumn] = new MorrisCounterNotStoringEstimatedValue();
            }
        }
        MorrisCounterLogger.insertLogForDataStructureSize(morrisCounters);
    }

    public void increment()
    {
        for (AbstractMorrisCounter[] row : morrisCounters)
        {
            for (int indexOnColumn = 0; indexOnColumn < morrisCounters[0].length; indexOnColumn++)
            {
                row[indexOnColumn].increment();
            }
        }
    }

    public Double getEstimate()
    {
        ArrayList<Double> meanValuesOfRows = new ArrayList<>();
        Double meanForCurrentRow;
        for (AbstractMorrisCounter[] morrisCounter : morrisCounters)
        {
            meanForCurrentRow = 0D;
            for (int indexOnColumn = 0; indexOnColumn < morrisCounters[0].length; indexOnColumn++)
            {
                meanForCurrentRow += morrisCounter[indexOnColumn].getEstimate();
            }
            meanValuesOfRows.add(meanForCurrentRow / morrisCounters[0].length);
        }
        meanValuesOfRows.sort(Comparator.naturalOrder());
        return medianValueFor(meanValuesOfRows);
    }

    private Double medianValueFor(ArrayList<Double> meanValuesOfRows)
    {
        return meanValuesOfRows.get(meanValuesOfRows.size() >> 1);
    }

    private int numberOfRows(Double probabilityOfBadEstimate)
    {
        return (int)
                (
                        12D *
                                Math.log(1D / probabilityOfBadEstimate)
                )
                + 1;
    }

    private int numberOfColumns(Double normalizedFactorOfDeferenceWithExactSolution)
    {
        return (int)
                (
                        2D /
                                (normalizedFactorOfDeferenceWithExactSolution *
                                        normalizedFactorOfDeferenceWithExactSolution)
                )
                + 1;
    }

}
