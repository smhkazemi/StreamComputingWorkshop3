package MorrisCounterDataStructure;

import edu.princeton.cs.introcs.StdRandom;

public class MorrisCounterNotStoringEstimatedValue implements MorrisCounterInterface
{
    private short counter;

    MorrisCounterNotStoringEstimatedValue()
    {
        counter = 0;
    }

    @Override
    public void increment()
    {
        if(StdRandom.uniform() < 1D / (1 << counter))
        {
            counter++;
        }
    }

    @Override
    public Double getEstimate() {
        return ((1 << counter) - 1D);
    }
}
