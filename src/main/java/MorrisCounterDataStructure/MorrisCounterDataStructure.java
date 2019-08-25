package MorrisCounterDataStructure;

import MorrisCounterDataStructure.MorrisCounter.MorrisCounterInterface;
import MorrisCounterDataStructure.MorrisCounter.MorrisCounterNotStoringEstimatedValue;

import java.util.ArrayList;
import java.util.Comparator;

public class MorrisCounterDataStructure {

    private MorrisCounterInterface[][]
            morrisCounters;

    public MorrisCounterDataStructure(Double probabilityOfBadEstimate,
                               Double normalizedFactorOfDeferenceWithExactSolution)
    {
        morrisCounters =
                new MorrisCounterNotStoringEstimatedValue
                        [(int) (12D * Math.log(1D / probabilityOfBadEstimate)) + 1]
                        [(int) (2D / Math.pow(normalizedFactorOfDeferenceWithExactSolution, 2)) + 1];
        for(int indexOnRow = 0; indexOnRow < morrisCounters.length; indexOnRow++)
        {
            for(int indexOnColumn = 0; indexOnColumn < morrisCounters[0].length; indexOnColumn++)
            {
                morrisCounters[indexOnRow][indexOnColumn] = new MorrisCounterNotStoringEstimatedValue();
            }
        }
    }

    public void increment()
    {
        for (MorrisCounterInterface[] row : morrisCounters)
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
        Double meanForCurrentRow = 0D;
        int numberOfColumns = morrisCounters[0].length;
        for (MorrisCounterInterface[] morrisCounter : morrisCounters)
        {
            for (int indexOnColumn = 0; indexOnColumn < numberOfColumns; indexOnColumn++)
            {
                meanForCurrentRow += morrisCounter[indexOnColumn].getEstimate();
            }
            meanForCurrentRow /= numberOfColumns;
            meanValuesOfRows.add(meanForCurrentRow);
            meanForCurrentRow = 0D;
        }
        meanValuesOfRows.sort(Comparator.naturalOrder());
        return meanValuesOfRows.get(meanValuesOfRows.size() >> 1);
    }

}
