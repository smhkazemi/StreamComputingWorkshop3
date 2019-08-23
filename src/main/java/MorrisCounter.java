import edu.princeton.cs.introcs.StdRandom;

public class MorrisCounter
{
    private short counter;

    MorrisCounter()
    {
        counter = 0;
    }

    void increment()
    {
        if(StdRandom.uniform() < 1D / Math.pow(2, counter))
        {
            counter++;
        }
    }

    public int estimatedCount()
    {
        return (int) (Math.pow(2, counter) - 1);
    }
}
