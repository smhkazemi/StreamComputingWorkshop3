package MorrisCounterDataStructure.MorrisCounter;

import edu.princeton.cs.introcs.StdRandom;

public class MorrisCounterNotStoringEstimatedValue implements MorrisCounterInterface
{
    private short counter;

    public MorrisCounterNotStoringEstimatedValue()
    {
        counter = 0;
    }

    @Override
    public void increment()
    {
        if(StdRandom.uniform() < 1D / Math.pow(2, counter))
        {
            counter++;
        }
    }

    @Override
    public Double getEstimate() {
        return (Math.pow(2, counter) - 1);
    }
}
