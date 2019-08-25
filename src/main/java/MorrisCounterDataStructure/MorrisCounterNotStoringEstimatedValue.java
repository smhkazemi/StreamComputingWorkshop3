package MorrisCounterDataStructure;

import edu.princeton.cs.introcs.StdRandom;

class MorrisCounterNotStoringEstimatedValue extends AbstractMorrisCounter
{
    private short counter;

    MorrisCounterNotStoringEstimatedValue()
    {
        counter = 0;
    }

    @Override
    void increment()
    {
        if(StdRandom.uniform() < 1D / (1 << counter))
        {
            counter++;
        }
    }

    @Override
    Double getEstimate() {
        return ((1 << counter) - 1D);
    }
}
